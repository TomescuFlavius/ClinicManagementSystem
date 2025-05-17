package app.appointments.models;

public class Appointment {
    private int id;
    private int idPacient;
    private int idDoctor;
    private String date;
    private String time;
    private String appointmentReason;

    public Appointment(int id, int idPacient, int idDoctor, String date, String time, String appointmentReason){
        this.id=id;
        this.idPacient=idPacient;
        this.idDoctor=idDoctor;
        this.date=date;
        this.time=time;
        this.appointmentReason=appointmentReason;
    }

    public Appointment(String text){
        text.split(",");
        id=Integer.parseInt(text.split(",")[0]);
        idPacient=Integer.parseInt(text.split(",")[1]);
        idDoctor=Integer.parseInt(text.split(",")[2]);
        date=text.split(",")[3];
        time=text.split(",")[4];
        appointmentReason=text.split(",")[5];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPacient() {
        return idPacient;
    }

    public void setIdPacient(int idPacient) {
        this.idPacient = idPacient;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAppointmentReason() {
        return appointmentReason;
    }

    public void setAppointmentReason(String appointmentReason) {
        this.appointmentReason = appointmentReason;
    }

    public String descriere(){
        String text="";
        text+="id:" + this.id + "\n";
        text+="id pacient:" + this.idPacient + "\n";
        text+="id doctor:" + this.idDoctor + "\n";
        text+="date:" + this.date + "\n";
        text+="time:" + this.time + "\n";
        text+="appointment reason:" + this.appointmentReason + "\n";
        return text;
    }

    public String toSaveAppointment(){
        return id+"," + idPacient+"," + idDoctor+"," + date+"," + time+"," +appointmentReason;
    }
}
