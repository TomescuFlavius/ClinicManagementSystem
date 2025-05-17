package app.pacients.models;

public class Pacient {
    private int id;
    private String name;
    private String date;
    private String cnp;
    private String email;
    private String phoneNumber;


    public Pacient(int id, String name, String date, String cnp, String email, String phoneNumber){
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
        date = text.split(",")[2];
        cnp = text.split(",")[3];
        email = text.split(",")[4];
        phoneNumber = text.split(",")[5];
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public String descriere(){
        String text="";
        text+="id" + this.id + "\n";
        text+="name" + this.name + "\n";
        text+="date" + this.date + "\n";
        text+="cnp" + this.cnp + "\n";
        text+="email" + this.email + "\n";
        text+="phone number" + this.phoneNumber + "\n";
        return text;
    }

    public String toSavePacient(){
        return id + "," + name + "," + date + "," + cnp + "," + email
                + "," + phoneNumber;
    }
}
