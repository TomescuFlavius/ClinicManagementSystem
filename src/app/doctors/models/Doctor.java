package app.doctors.models;

public class Doctor implements Comparable {
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


    public Doctor(Builder builder){
        this.id=builder.id;
        this.name= builder.name;
        this.specializare= builder.specializare;
        this.program= builder.program;
    }

    public Doctor(String text){
        text.split(",");
        id= Integer.parseInt(text.split(",")[0]);
        name= text.split(",")[1];
        specializare = text.split(",")[2];
        program = text.split(",")[3];
    }

    public static Builder builder(){
        return new Builder();
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

    @Override
    public String toString(){
        return id+","+name+","+specializare+","+program;
    }

    @Override
    public boolean equals(Object o){
        Doctor doctor = (Doctor) o;
        return this.id==doctor.id;
    }




    public String toSaveDoctor(){
        return id+ ","+ name+ ","+ specializare+ ","+ program;
    }

    @Override
    public int compareTo(Object o) {
        Doctor doctor=(Doctor) o;
        if (doctor.id>this.id){
            return -1;
        }
        else if (doctor.id< this.id){
            return 1;
        }
        return 0;
    }

    public static class Builder{
        private int id;
        private String name;
        private String specializare;
        private String program;

        public Builder id(int id){
            this.id=id;
            return this;
        }

        public Builder name(String name){
            this.name=name;
            return this;
        }

        public Builder specializare(String specializare){
            this.specializare=specializare;
            return this;
        }

        public Builder program(String program){
            this.program=program;
            return this;
        }

        public Doctor build(){
            return new Doctor(this);
        }
    }

}
