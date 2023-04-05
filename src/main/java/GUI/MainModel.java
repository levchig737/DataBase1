package GUI;

import Connection.DBConnection;
import TableEntity.Doctor;

import java.util.ArrayList;
import java.util.List;

/**
 * Основная модель с данным для таблицы
 */
public class MainModel {
    private final DBConnection connection = new DBConnection();
    int ptId;
    String patientName;
//    public StageWrapper data = new StageWrapper();

    List<Doctor> doctorList = new ArrayList<>();

    /**
     * Конструктор с созданием списка
     */
    public MainModel() {
    }

    /**
     * Загрузка данных из таблицы
     */
    public void loadDoctor() {
        this.doctorList = connection.getDoctor();
    }
    public void addDoctor(Doctor doctor) {
        System.out.println("add doctor :" + doctor.toString());
        connection.InsertValue("tblDoctor", doctor);
        List<Doctor> dc = connection.getDoctor();
        doctorList.clear();
        doctorList.addAll(dc);
    }
}
