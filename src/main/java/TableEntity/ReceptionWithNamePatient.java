package TableEntity;

public class ReceptionWithNamePatient {
    private String txtReceptionDate;
    private String txtReceptionTime;
    private String txtReceptionRoom;
    private String txtPatientFullName;
    private String txtReceptionResult;

    public void setTxtReceptionResult(String txtReceptionResult) {
        this.txtReceptionResult = txtReceptionResult;
    }

    public String getTxtReceptionResult() {
        return txtReceptionResult;
    }

    public String getTxtPatientFullName() {
        return txtPatientFullName;
    }

    public void setTxtReceptionRoom(String txtReceptionRoom) {
        this.txtReceptionRoom = txtReceptionRoom;
    }

    public void setTxtReceptionTime(String txtReceptionTime) {
        this.txtReceptionTime = txtReceptionTime;
    }

    public void setTxtPatientFullName(String txtPatientFullName) {
        this.txtPatientFullName = txtPatientFullName;
    }

    public String getTxtReceptionDate() {
        return txtReceptionDate;
    }

    public String getTxtReceptionRoom() {
        return txtReceptionRoom;
    }

    public String getTxtReceptionTime() {
        return txtReceptionTime;
    }

    public void setTxtReceptionDate(String txtReceptionDate) {
        this.txtReceptionDate = txtReceptionDate;
    }

    public ReceptionWithNamePatient(Reception reception, Patient patient){
        this.txtReceptionDate = reception.getDatReceptionDate().toString();
        this.txtReceptionTime = reception.getTxtReceptionTime();
        this.txtReceptionRoom = reception.getTxtReceptionRoom();
        this.txtReceptionResult = reception.getTxtReceptionResult();
        this.txtPatientFullName = patient.getTxtPatientSurname() + " " + patient.getTxtPatientName();

    }
}
