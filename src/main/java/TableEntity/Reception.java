package TableEntity;

import java.util.Date;
import java.util.Map;

/**
 * Данные о приеме
 */
public class Reception {
    private int intReceptionId;
    private int intDoctorId; //FK tblDoctor
    private int intPatientId; //FK tblPatient
    private Date datReceptionDate;
    private String txtReceptionTime;
    private String txtReceptionRoom;
    private String txtReceptionResult;
    public int getIntReceptionId() {
        return intReceptionId;
    }

    public void setIntReceptionId(int intReceptionId) {
        this.intReceptionId = intReceptionId;
    }

    public int getIntDoctorId(){
        return intDoctorId;
    }

    public void setIntDoctorId(int intDoctorId) {
        this.intDoctorId = intDoctorId;
    }

    public int getIntPatientId() {
        return intPatientId;
    }

    public void setIntPatientId(int intPatientId) {
        this.intPatientId = intPatientId;
    }

    public Date getDatReceptionDate(){
        return datReceptionDate;
    }

    public void setDatReceptionDate(Date datReceptionDate) {
        this.datReceptionDate = datReceptionDate;
    }

    public String getTxtReceptionTime(){
        if (txtReceptionTime != null && txtReceptionTime.length() <= 5)
            this.txtReceptionTime = txtReceptionTime.trim();
        else this.txtReceptionTime = "";
        return txtReceptionTime;
    }

    public void setTxtReceptionTime(String txtReceptionTime) {
        this.txtReceptionTime = txtReceptionTime;
    }

    public String getTxtReceptionRoom(){
        if (txtReceptionRoom != null && txtReceptionRoom.length() <= 5)
            this.txtReceptionRoom = txtReceptionRoom.trim();
        else this.txtReceptionRoom = "";
        return txtReceptionRoom;
    }

    public void setTxtReceptionRoom(String txtReceptionRoom) {
        this.txtReceptionRoom = txtReceptionRoom;
    }

    public String getTxtReceptionResult(){
        if (txtReceptionResult != null && txtReceptionResult.length() <= 255)
            this.txtReceptionResult = txtReceptionResult.trim();
        else this.txtReceptionResult = "";
        return txtReceptionResult;
    }

    public void setTxtReceptionResult(String txtReceptionResult) {
        this.txtReceptionResult = txtReceptionResult;
    }

    /**
     * Конструктор Reception после запроса в БД
     * @param map хэш таблица с данными таблицы
     */
    public Reception(Map<String, Object> map){
        this.setIntReceptionId((int) map.get("intReceptionId"));
        this.setIntDoctorId((int) map.get("intDoctorId"));
        this.setIntPatientId((int) map.get("intPatientId"));
        this.setDatReceptionDate((Date) map.get("datReceptionDate"));
        this.setTxtReceptionTime((String) map.get("txtReceptionTime"));
        this.setTxtReceptionRoom((String) map.get("txtReceptionRoom"));
        this.setTxtReceptionResult((String) map.get("txtReceptionResult"));
    }
}