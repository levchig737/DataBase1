package Connection;

import TableEntity.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.*;

/***
 * Класс подключения к базе данных
 */
public class DBConnection {
    private Connection connection;
    //    public boolean isLog = false;
    private Statement statement;
    private String StrUseNameDB;


    /**
     * Получает логин и пароль пользователя sql server
     * @return список из 2 строк логин и пароль
     */
    public static List<String> getUserNameAndPassword() {
        File file = new File("src\\main\\java\\Connection\\userNameAndPassword.txt");
        List<String> result = new ArrayList<>();
        try(FileReader reader = new FileReader(file))
        {
            StringBuilder a = new StringBuilder();

            int c;
            while((c = reader.read()) != -1){
                if (c == '=') {
                    result.add(0, a.toString());
                    a.setLength(0); // чистим билдер
                    continue;
                }
                a.append((char)c);
            }
            result.add(1, a.toString());
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }

    /***
     * Сеттер use db...
     * @param strUseNameDB начала запроса use ...
     */
    public void setStrUseNameDB(String strUseNameDB) {
        this.StrUseNameDB = strUseNameDB;
    }

    /***
     * Конструктор задания соединения с БД
     */
    public DBConnection() {
        this.setStrUseNameDB("use db22207;");
        Properties p = new Properties();
        try {
            // Получаем данные из файла с паролем из бд
            List<String> loginAndPasswd = getUserNameAndPassword();

            p.setProperty("user", loginAndPasswd.get(0));
            p.setProperty("password", loginAndPasswd.get(1));
            p.setProperty("useUnicode", "true");
            p.setProperty("characterEncoding", "UTF-8");
            p.setProperty("CharacterSet", "UTF-8");
            String connectionUrl = "jdbc:sqlserver://localhost:1433";

            connection = DriverManager.getConnection(connectionUrl, p);
            statement = connection.createStatement();
        } catch (SQLException e) {
            connection = null;
            System.err.println(e.getMessage() + " Heeeeeeelp");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /***
     * Метод получения данных по запросу
     * @param query строка с запросом к БД
     * @return список хэш-таблиц атрибут-кортеж
     */
    public List<Map<String, Object>> ex(String query) {
//        if (isLog == true) {
//            System.out.println(query);
//        }
        try {
            if (!connection.isValid(1)) {
                throw new RuntimeException();
            }

            // Набор данных таблицы, по которым далее происходит проход
            ResultSet resultSet = statement.executeQuery(StrUseNameDB + query);

            List<Map<String, Object>> result = new ArrayList<>();
            if (resultSet == null) {
                return result;
            }

            // Цикл по данным БД
            while (resultSet.next()) {
                // Хэш-таблицы (словарь) пары ключ-значение: атрибут-кортеж
                Map<String, Object> resultMap = new HashMap<>();

                // Получаем и записываем данные в resultMap
                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); ++i) {
                    resultMap.put(resultSet.getMetaData().getColumnName(i),
                            resultSet.getObject(i));
                }
                // Добавление хэщ-таблицы resultMap в список результата
                result.add(resultMap);
            }

            return result;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    /***
     * Метод получения данных из таблицы Doctor
     * @return список типа Doctor кортежей из таблицы
     */
    public List<Doctor> getDoctor() {
        List<Doctor> docs = new ArrayList<>();
        this.ex("select * from tblDoctor").forEach(
                (current) -> docs.add(new Doctor(current))
        );
        return docs;
    }
    public <T> void InsertValue(String tableName, T value) {
        this.ex(String.format("insert into %s (txtDoctorName, txtSpecialist, datDoctorWork, intReceptionCount) values(%s, 0);",
                tableName,
                value.toString()));
    }
    public <T> void InsertValue(String tableName, List<T> value) {
        for(var current : value) {
            this.InsertValue(tableName, current);
        }
    }
}

