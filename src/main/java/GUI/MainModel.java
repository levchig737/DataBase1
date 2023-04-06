package GUI;

import Connection.DBConnection;
import TableEntity.Doctor;
import TableEntity.Patient;
import TableEntity.Reception;

import java.util.ArrayList;
import java.util.List;

/**
 * Основная модель с данным для таблицы
 */
public class MainModel {
    private final DBConnection connection = new DBConnection();
    int ptId;
    private Doctor selectedDoctor;
    String patientName;
//    public StageWrapper data = new StageWrapper();

    public List<Doctor> doctorList = new ArrayList<>();
    public List<Reception> receptionList = new ArrayList<>();
    public List<Patient> patientList = new ArrayList<>();

    /**
     * Конструктор с загрузкой всех таблиц
     */
    public MainModel() {
        this.loadDoctor();
        this.loadReception();
        this.loadPatient();
    }

    /**
     * Загрузка данных из таблицы tblDoctor
     */
    public void loadDoctor() {
        this.doctorList = connection.getDoctor();
    }

    /**
     * Установка выбранного доктора
     * @param doctor доктор
     */
    public void setSelectedDoctor(Doctor doctor) {
        this.selectedDoctor = doctor;
    }

    /**
     * Возвращает последнего нажатого доктора в таблице Доктора
     * @return нажатый доктор
     */
    public Doctor getSelectedDoctor() {
        return this.selectedDoctor;
    }

    /**
     * Загрузка данныз из таблицы tblReception
     */
    public void loadReception() {this.receptionList = connection.getReception();}

    public void loadPatient() {this.patientList = connection.getPatient();}

    /**
     * Добавление доктора в БД
     * @param doctor эл
     */
    public void addDoctor(Doctor doctor) {
        System.out.println("add doctor :" + doctor.toString());
        connection.InsertValue("tblDoctor", doctor);
        List<Doctor> dc = connection.getDoctor();
        doctorList.clear();
        doctorList.addAll(dc);
    }
}
