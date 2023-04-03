package TableEntity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/***
 *  Класс данных о докторе
 */
public class Doctor {
    private int intDoctorId;
    private String txtDoctorName;
    private String txtSpecialist;
    private Date datDoctorWork;

    /**
     * Сеттер id доктора
     * @param intDoctorId id доктора
     */
    public void setIntDoctorId(int intDoctorId) {
        this.intDoctorId = intDoctorId;
    }

    /**
     * Геттер id доктора
     * @return id доктора типа int
     */
    public int getIntDoctorId() {
        return intDoctorId;
    }

    /**
     * Геттер имени доктора
     * @return имя доктора типа String
     */
    public String getTxtDoctorName() {
        return this.txtDoctorName;
    }

    /**
     * Сеттер имени доктора
     * @param txtDoctorName имя доктора типа String
     */
    public void setTxtDoctorName(String txtDoctorName) {
        if (txtDoctorName != null && txtDoctorName.length() <= 150)
            this.txtDoctorName = txtDoctorName.trim();
        else this.txtDoctorName = "";
    }

    /**
     * Геттер специальности доктора
     * @return специальность доктора типа String
     */
    public String getTxtSpecialist() {
        return txtSpecialist;
    }

    /**
     * Сеттер специальности доктора
     * @param txtSpecialist специальность доктор типа String
     */
    public void setTxtSpecialist(String txtSpecialist) {
        if (txtSpecialist != null && txtSpecialist.length() <= 35)
            this.txtSpecialist = txtSpecialist.trim();
        else
            this.txtSpecialist = "";
    }

    /***
     * Геттер
     * @return дату устройства на работу типа Date
     */
    public Date getDatDoctorWork() {
        return datDoctorWork;
    }

    /***
     * Сеттер
     * @param datDoctorWork дата устройства на работу
     */
    public void setDatDoctorWork(Date datDoctorWork) {
        this.datDoctorWork = datDoctorWork;
    }

//    public Doctor() {
//
//    }
//    public Doctor(String txtDoctorName,
//                  String txtSpecialist,
//                  Date datDoctorWork) {
//        this.setDatDoctorWork(datDoctorWork);
//        this.setTxtDoctorName(txtDoctorName);
//        this.setTxtSpecialist(txtSpecialist);
//    }

    /***
     *  Конструктор, устанавливает значения полям объекта
     * @param map хэш-таблица пар атрибут-кортеж
     */
    public Doctor(Map<String, Object> map)  {
        this.setIntDoctorId((int) map.get("intDoctorId"));
        this.setTxtSpecialist((String) map.get("txtSpecialist"));
        this.setTxtDoctorName((String) map.get("txtDoctorName"));
        this.setDatDoctorWork((Date)map.get("datDoctorWork"));
    }
//    public Doctor(int intDoctorId,
//                  String txtDoctorName,
//                  String txtSpecialist,
//                  Date datDoctorWork) {
//        this.intDoctorId = intDoctorId;
//        this.setDatDoctorWork(datDoctorWork);
//        this.setTxtDoctorName(txtDoctorName);
//        this.setTxtSpecialist(txtSpecialist);
//    }

    /**
     * Метод преобразования даты в строку типа String
     * @return Дата в формате строки String
     */
    public String toString() {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = formater.format(getDatDoctorWork());

        return String.format("N'%s', N'%s', '%s'",
                getTxtDoctorName(),
                getTxtSpecialist(),
                strDate);
    }
//    public String toString(int withId) {
//        if (withId != 1) return this.toString();
//        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
//        String strDate = formater.format(getDatDoctorWork());
//
//        return String.format("'%s', '%s', '%s', '%s'",
//                getIntDoctorId(),
//                getTxtDoctorName(),
//                getTxtSpecialist(),
//                strDate);
//    }
}