package TableEntity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Данные о докторе
 */
public class Doctor {
    private int intDoctorId;
    private String txtDoctorName;
    private String txtSpecialist;
    private Date datDoctorWork;
    private int intReceptionCount = 0;

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

    /**
     * Геттер кол-ва приянтых пациентов
     * @return кол-во приянтых пациентов int
     */
    public int getIntReceptionCount() {return intReceptionCount;};

    /**
     * Сеттер кол-ва приянтых пациентов
     * @param intReceptionCount кол-ва приянтых пациентов типа int
     */
    public void setIntReceptionCount(int intReceptionCount) {
         this.intReceptionCount = intReceptionCount;
    }

    /**
     * Конструктор со значениями без map
     * @param txtDoctorName текстовое имя
     * @param txtSpecialist текстовая специальность
     * @param datDoctorWork дата работы
     */
    public Doctor(String txtDoctorName,
                  String txtSpecialist,
                  Date datDoctorWork) {
        this.setDatDoctorWork(datDoctorWork);
        this.setTxtDoctorName(txtDoctorName);
        this.setTxtSpecialist(txtSpecialist);
    }

    /***
     * Конструктор, устанавливает значения полям объекта
     * @param map хэш-таблица пар атрибут-кортеж
     */
    public Doctor(Map<String, Object> map)  {
        this.setIntDoctorId((int) map.get("intDoctorId"));
        this.setTxtSpecialist((String) map.get("txtSpecialist"));
        this.setTxtDoctorName((String) map.get("txtDoctorName"));
        this.setDatDoctorWork((Date)map.get("datDoctorWork"));
        this.setIntReceptionCount((int) map.get("intReceptionCount"));

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

        return String.format("'%s', '%s', '%s', '%s'",
                getTxtDoctorName(),
                getTxtSpecialist(),
                strDate,
                getIntReceptionCount());
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