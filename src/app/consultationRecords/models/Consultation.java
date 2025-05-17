package app.consultationRecords.models;

public class Consultation {
    private int id;
    private int idPacient;
    private int idDoctor;
    private String date;
    private String diagnostic;
    private String treatment;

    public Consultation(int id, int idPacient, int idDoctor, String date, String diagnostic, String treatment){
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
        date=text.split(",")[3];
        diagnostic=text.split(",")[4];
        treatment=text.split(",")[5];
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

    public String descriere(){
        String text="";
        text+="id:" + id + "\n";
        text+="id pacient:" + idPacient + "\n";
        text+="id doctor:" + idDoctor + "\n";
        text+="date:" + date + "\n";
        text+="diagnostic:" + diagnostic + "\n";
        text+="treatment:" + treatment + "\n";
        return text;
    }

    public String toSaveConsultation(){
        return id+","+idPacient+","+idDoctor+","+date+","+diagnostic+","+treatment;
    }
}
