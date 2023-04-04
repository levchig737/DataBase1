package GUI;

import Connection.DBConnection;
import TableEntity.Doctor;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Основная модель с данным для таблицы
 */
public class MainModel {
//    private List<Doctor> doctorList = new ArrayList<>();
    private final DBConnection connection = new DBConnection();


    /**
     * Конструктор с созданием списка
     */
    public MainModel() {
    }

    /**
     * Загрузка данных из таблицы
     */
    public List<Doctor> loadDoctor() {
        return connection.getDoctor();
    }
}
