package GUI;

import Connection.DBConnection;
import TableEntity.Doctor;
import TableEntity.Patient;
import TableEntity.Reception;
import TableEntity.ReceptionWithNamePatient;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Основная модель с данным для таблицы
 */
public class MainModel {
    private final DBConnection connection = new DBConnection();
    private Doctor selectedDoctor;
    public List<Doctor> doctorList = new ArrayList<>();
    public List<Reception> receptionList = new ArrayList<>();
    public List<Patient> patientList = new ArrayList<>();
    public List<ReceptionWithNamePatient> receptionWithPatient = new ArrayList<>();

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

    public void addReception(Reception reception) {
        System.out.println("add reception :" + reception.toString());
        connection.InsertValue("tblReception", reception);
        List<Reception> rc = connection.getReception();
        receptionList.clear();
        receptionList.addAll(rc);
    }

    /**
     * Запрос на соединения 2х списков receptionList и patientList по patientId
     * Записываем данные в поле receptionWithPatient
     */
    public void connectReceptionWithPatient(){
        this.receptionWithPatient = this.receptionList.stream()
                .flatMap(reception -> // принимает функцию и преобразует каждый элемент исходного потока в новый поток
                        this.patientList.stream() // создаем поток по списку
                                .filter(patient -> reception.getIntPatientId() == patient.getIntPatientId()) // select
                                .map(patient -> new ReceptionWithNamePatient(reception, patient)) // создаем новый объект
                )
                .collect(Collectors.toList());
    }
}
