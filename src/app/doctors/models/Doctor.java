package app.doctors.models;

public class Doctor {
    private int id;
    private String name;
    private String specializare;
    private String program;

    public Doctor(int id, String name, String specializare, String program){
        this.id=id;
        this.name=name;
        this.specializare=specializare;
        this.program=program;
    }

    public Doctor(String text){
        text.split(",");
        id= Integer.parseInt(text.split(",")[0]);
        name= text.split(",")[1];
        specializare = text.split(",")[2];
        program = text.split(",")[3];
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

    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String descriere(){
        String text="";
        text+="id:"+this.id+"\n";
        text+="name:"+this.name+"\n";
        text+="specializare:"+this.specializare+"\n";
        text+="program:"+this.program+"\n";
        return text;
    }

    public String toSaveDoctor(){
        return id+ ","+ name+ ","+ specializare+ ","+ program;
    }
}
