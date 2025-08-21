package app.pacients.models;

import app.doctors.models.Doctor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pacient implements Comparable {
    private int id;
    private String name;
    private LocalDate date;
    private String cnp;
    private String email;
    private String phoneNumber;
    private String password;


    public Pacient(int id, String name, LocalDate date, String cnp, String email, String phoneNumber, String password){
        this.id=id;
        this.name=name;
        this.date=date;
        this.cnp=cnp;
        this.email=email;
        this.phoneNumber=phoneNumber;
    }

    public Pacient(String text){
        text.split(",");
        id =Integer.parseInt(text.split(",")[0]);
        name = text.split(",")[1];
        date = LocalDate.parse((text.split(",")[2]), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        cnp = text.split(",")[3];
        email = text.split(",")[4];
        phoneNumber = text.split(",")[5];
        password = text.split(",")[6];
    }

    public Pacient(String name, LocalDate date, String cnp, String email, String phoneNumber, String password){
        this.name=name;
        this.date=date;
        this.cnp= cnp;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.password=password;
    }

    public Pacient(Builder builder){
        this.name=builder.name;
        this.date=builder.date;
        this.cnp=builder.cnp;
        this.email=builder.email;
        this.phoneNumber=builder.phoneNumber;
        this.password= builder.password;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword(){return password;};

    public void setPassword(String password){this.password=password;}



    public String toString(){
        return id + "," + name + "," + date + "," + cnp + "," + email + "," + phoneNumber + "," + password;
    }

    public String toSavePacient(){
        return id + "," + name + "," + date + "," + cnp + "," + email + "," + phoneNumber + "," + password;
    }

    @Override
    public int compareTo(Object o) {
        Pacient pacient= (Pacient) o;
        if(pacient.id>this.id){
            return -1;
        }
        else if (pacient.id<this.id){
            return 1;
        }
        return 0;
    }

    public static class Builder{
        private int id;
        private String name;
        private LocalDate date;
        private String cnp;
        private String email;
        private String phoneNumber;
        private String password;

        public Builder id(int id){
            this.id=id;
            return this;
        }

        public Builder name(String name){
            this.name=name;
            return this;
        }

        public Builder date(LocalDate date){
            this.date=date;
            return this;
        }

        public Builder cnp(String cnp){
            this.cnp=cnp;
            return this;
        }

        public Builder email(String email){
            this.email=email;
            return this;
        }

        public Builder phoneNumber(String phoneNumber){
            this.phoneNumber=phoneNumber;
            return this;
        }

        public Builder password(String password){
            this.password=password;
            return this;
        }
    }
}
