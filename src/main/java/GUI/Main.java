package GUI;

import Connection.DBConnection;
import TableEntity.Doctor;

/**
 * Запуск приложения
 */
public class Main {
    public static void main(String[] args) {
        DBConnection connection = new DBConnection();
        Doctor doctor = connection.getDoctor().get(0);
        String txtSpecialist = doctor.getTxtSpecialist();
        String datWork = doctor.getDatDoctorWork().toString();
        String name = doctor.getTxtDoctorName();
        int intReception = doctor.getIntReceptionCount();

//         Patient pt = connection.getPatients().get(0);
//         String name = pt.getTxtPatientName();

        System.out.println(name + " " + txtSpecialist + " " + datWork + " " + intReception);
    }
}
