package app.views;

import app.appointments.models.Appointment;
import app.appointments.services.AppointmentService;
import app.consultationRecords.models.Consultation;
import app.consultationRecords.services.ConsultationService;
import app.doctors.services.DoctorService;
import app.pacients.models.Pacient;
import app.pacients.services.PacientService;

import java.util.List;
import java.util.Scanner;

public class View {
    private Scanner scanner;
    private PacientService pacientService;
    private DoctorService doctorService;
    private ConsultationService consultationService;
    private AppointmentService appointmentService;
    private Pacient pacient;

    public View(Pacient pacient1){
        scanner= new Scanner(System.in);
        pacientService= new PacientService();
        doctorService= new DoctorService();
        consultationService= new ConsultationService();
        appointmentService= new AppointmentService();
        pacient=pacient1;
        this.play();
    }

    private void meniu(){
        System.out.println("1.Doctorii, specializarea si programul lor");
        System.out.println("2.Programarile dvs.");
        System.out.println("3.Istoricul vizitelor dvs.");

    }

    public void play(){
        boolean run = true;
        while (run){
        meniu();
        int option= Integer.parseInt(scanner.nextLine());
        switch (option) {
            case 1:
                this.showDoctors();
                break;
            case 2:
                this.showMyAppointments();
                break;
            case 3:
                this.showMyConsultationRecord();
                break;
            default:
                System.out.println("Invalid choice");
            }
        }
    }

    public void showDoctors(){
        this.doctorService.showDoctors();
    }

    public void showMyAppointments(){
        List<Appointment> apointments= appointmentService.getAppointmentByPacientId(pacient.getId());

        for(Appointment appointment : apointments){
            System.out.println("Numele pacientului: " + pacient.getName()
                        +"\n" + "Data programarii: "  +appointment.getDate()
                        + "\n" + "Ora programarii: " + appointment.getStartingTime()
                        + "\n" + "Ora finalizarii programarii: "+appointment.getEndingTime()
                        + "\n" + "Motivul programarii:" + appointment.getAppointmentReason()+"\n");
        }
    }

    public void showMyConsultationRecord(){
        List<Consultation> consultations = consultationService.getConsultationsByPacientId(pacient.getId());

        for (Consultation consultation :consultations){
            System.out.println("Numele pacientului:" + pacient.getName() + "\n" + "Data:" + consultation.getDate() + "\n"
                                + "Diagnosticul:" + consultation.getDiagnostic() +"\n" + "Tratament:"
                                + consultation.getTreatment() + "\n");
        }
    }

    



}


