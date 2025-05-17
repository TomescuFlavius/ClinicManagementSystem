package app.appointments.services;

import app.appointments.models.Appointment;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppointmentService {
    private File file;
    private List<Appointment> appointments;

    public AppointmentService(){
        this.file=new File("C:\\mycode\\oop\\ClinicManagementSystem\\src\\app\\appointments\\files\\appointments.txt");
        this.appointments=new ArrayList<>();
        this.loadAppointments();
    }

    public void loadAppointments(){
        try{
            Scanner scanner=new Scanner(file);
            while(scanner.hasNextLine()){
            String line =scanner.nextLine();
            Appointment appointment =new Appointment(line);
            this.appointments.add(appointment);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setAppointments(){
        try{
            FileWriter fileWriter=new FileWriter(file);
            PrintWriter printWriter=new PrintWriter(fileWriter);
            printWriter.println(toSaveAppointmens());
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String toSaveAppointmens(){
        String output="";
        int i;
        for(i=0;i<=this.appointments.size()-1;i++){
            output+=this.appointments.get(i).toSaveAppointment()+"\n";
        }
        return output+this.appointments.get(i)+toSaveAppointmens();
    }

    public void showAppointments(){
        for (Appointment appointment : appointments){
            System.out.println(appointment.descriere());
        }
    }

    public Appointment getAppointmentById(int id){
        for (Appointment appointment:appointments){
            if(appointment.getId()==id){
                return appointment;
            }
        }
        return null;
    }




}
