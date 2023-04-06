package TableEntity;

import java.util.Date;
import java.util.Map;

/**
 * Данные о докторе
 */
public class Patient {
    private int intPatientId;
    private String txtPatientSurname;
    private String txtPatientName;
    private String txtPatientSecondName;
    private Date datBirthday;
    private String txtAddress;

    public void setIntPatientId(int intPatientId) {
        this.intPatientId = intPatientId;
    }

    public int getIntPatientId() {
        return intPatientId;
    }

    public void setTxtPatientSurname(String txtPatientSurname) {
        if (txtPatientSurname != null && txtPatientSurname.length() <= 30)
            this.txtPatientSurname = txtPatientSurname.trim();
        else this.txtPatientSurname = "";
    }

    public String getTxtPatientSurname() {
        return txtPatientSurname;
    }

    public void setTxtPatientName(String txtPatientName) {
        if (txtPatientName != null && txtPatientName.length() <= 25)
            this.txtPatientName = txtPatientName.trim();
        else this.txtPatientName = "";
    }

    public String getTxtPatientName() {
        return txtPatientName;
    }

    public void setTxtPatientSecondName(String txtPatientSecondName) {
        if (txtPatientSecondName != null && txtPatientSecondName.length() <= 30)
            this.txtPatientSecondName = txtPatientSecondName.trim();
        else this.txtPatientSecondName = "";
    }

    public String getTxtPatientSecondName() {
        return txtPatientSecondName;
    }

    public void setDatBirthday(Date datBirthday) {
        this.datBirthday = datBirthday;
    }

    public Date getDatBirthday() {
        return datBirthday;
    }

    public void setTxtAddress(String txtAddress) {
        if (txtAddress != null && txtAddress.length() <= 100)
            this.txtAddress = txtAddress.trim();
        else this.txtAddress = "";
    }

    public String getTxtAddress() {
        return txtAddress;
    }

    public Patient(Map<String, Object> map){
        this.setIntPatientId((int) map.get("intPatientId"));
        this.setTxtPatientSurname((String) map.get("txtPatientSurname"));
        this.setTxtPatientName((String) map.get("txtPatientName"));
        this.setTxtPatientSecondName((String) map.get("txtPatientSecondName"));
        this.setDatBirthday((Date) map.get("datBirthday"));
        this.setTxtAddress((String) map.get("txtAddress"));
    }
}