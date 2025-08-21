package app.consultationRecords.models;


import app.consultationRecords.services.ConsultationService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Consultation implements Comparable{
    private int id;
    private int idPacient;
    private int idDoctor;
    private LocalDate date;
    private String diagnostic;
    private String treatment;

    public Consultation(int id, int idPacient, int idDoctor, LocalDate date, String diagnostic, String treatment){
        this.id=id;
        this.idPacient=idPacient;
        this.idDoctor=idDoctor;
        this.date=date;
        this.diagnostic=diagnostic;
        this.treatment=treatment;
    }

    public Consultation(String text){
        text.split(",");
        id=Integer.parseInt(text.split(",")[0]);
        idPacient=Integer.parseInt(text.split(",")[1]);
        idDoctor=Integer.parseInt(text.split(",")[2]);
        date=LocalDate.parse(text.split(",")[3], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        diagnostic=text.split(",")[4];
        treatment=text.split(",")[5];
    }

    public Consultation (Builder builder){
        this.id=builder.id;
        this.idDoctor= builder.idDoctor;
        this.idPacient= builder.idPacient;
        this.date= builder.date;
        this.diagnostic=builder.diagnostic;
        this.treatment=builder.treatment;
    }

    public static Consultation.Builder builder(){
        return new Consultation.Builder();
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }


    public String toString(){
        return id+","+idPacient+","+idDoctor+","+date+","+diagnostic+","+treatment;
    }

    public String toSaveConsultation(){
        return id+","+idPacient+","+idDoctor+","+date+","+diagnostic+","+treatment;
    }

    @Override
    public int compareTo(Object o) {
        Consultation consultation= (Consultation) o;
        if (consultation.id>this.id){
            return -1;
        }
        else if (consultation.id< this.id){
            return 1;
        }
        return 0;
    }


    public static class Builder{
        private int id;
        private int idPacient;
        private int idDoctor;
        private LocalDate date;
        private String diagnostic;
        private String treatment;

        public Builder id(int id){
            this.id=id;
            return this;
        }

        public Builder idPacient(int idPacient){
            this.idPacient=idPacient;
            return this;
        }

        public Builder idDoctor(int idDoctor){
            this.idDoctor=idDoctor;
            return this;
        }

        public Builder date(LocalDate date){
            this.date=date;
            return this;
        }

        public Builder diagnostic(String diagnostic){
            this.diagnostic=diagnostic;
            return this;
        }

        public Builder treatment(String treatment){
            this.treatment=treatment;
            return this;
        }

        public Consultation build(){
            return new Consultation(this);
        }

    }



}
