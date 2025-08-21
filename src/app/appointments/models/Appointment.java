package app.appointments.models;

import app.doctors.models.Doctor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Appointment implements Comparable {
    private int id;
    private int idPacient;
    private int idDoctor;
    private LocalDate date;
    private LocalTime startingTime;
    private LocalTime endingTime;
    private String appointmentReason;
    //todo:data de inceput data de sfarsit


    public Appointment(int id, int idPacient, int idDoctor, LocalDate date, LocalTime startingTime, LocalTime endingTime, String appointmentReason){
        this.id=id;
        this.idPacient=idPacient;
        this.idDoctor=idDoctor;
        this.date=date;
        this.startingTime=startingTime;
        this.endingTime=endingTime;
        this.appointmentReason=appointmentReason;
    }

    public Appointment(String text){
        text.split(",");
        id=Integer.parseInt(text.split(",")[0]);
        idPacient=Integer.parseInt(text.split(",")[1]);
        idDoctor=Integer.parseInt(text.split(",")[2]);
        date=LocalDate.parse((text.split(",")[3]),DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        startingTime=LocalTime.parse((text.split(",")[4]),DateTimeFormatter.ofPattern("HH:mm"));
        endingTime=LocalTime.parse((text.split(",")[5]),DateTimeFormatter.ofPattern("HH:mm"));
        appointmentReason=text.split(",")[6];
    }

    public Appointment(Builder builder){
        this.id=builder.id;
        this.idDoctor= builder.idDoctor;
        this.idPacient= builder.idPacient;
        this.date= builder.date;
        this.startingTime=builder.startingTime;
        this.endingTime=builder.endingTime;
        this.appointmentReason= builder.appointmentReason;
    }

    public static Doctor.Builder builder(){
        return new Doctor.Builder();
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

    public LocalTime getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(LocalTime startingTime) {
        this.startingTime = startingTime;
    }

    public LocalTime getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(LocalTime endingTime) {
        this.endingTime = endingTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAppointmentReason() {
        return appointmentReason;
    }

    public void setAppointmentReason(String appointmentReason) {
        this.appointmentReason = appointmentReason;
    }

    public String toString(){

        return id+","+idPacient+","+idDoctor+","+date+","+startingTime+","+endingTime+","+","+appointmentReason;
    }


    public String toSaveAppointment(){
        return id+"," + idPacient+"," + idDoctor+","+date+"," + startingTime+","+ endingTime+","+"," +appointmentReason;
    }

    @Override
    public int compareTo(Object o) {
        Appointment appointment=(Appointment) o;
        if (appointment.id>this.id){
            return -1;
        }
        else if (appointment.id< this.id){
            return 1;
        }
        return 0;
    }

    public static class Builder{
            private int id;
            private int idPacient;
            private int idDoctor;
            private LocalDate date;
            private LocalTime startingTime;
            private LocalTime endingTime;
            private String appointmentReason;

        public Appointment.Builder id(int id){
            this.id=id;
            return this;
        }

        public Appointment.Builder idPacient(int idPacient){
            this.idPacient=idPacient;
            return this;
        }

        public Appointment.Builder idDoctor(int idDoctor){
            this.idDoctor=idDoctor;
            return this;
        }

        public Appointment.Builder date(LocalDate date){
            this.date=date;
            return this;
        }

        public Appointment.Builder startingDate(LocalTime startingTime){
            this.startingTime=startingTime;
            return this;
        }

        public Appointment.Builder endingTime(LocalTime endingTime){
            this.endingTime=endingTime;
            return this;
        }

        public Appointment.Builder appointmentReason(String appointmentReason){
            this.appointmentReason=appointmentReason;
            return this;
        }

        public Appointment build(){
            return new Appointment(this);
        }
    }


}
