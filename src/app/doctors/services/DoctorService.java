package app.doctors.services;
import app.doctors.models.Doctor;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoctorService {
    private File file;
    private List<Doctor> doctors;

    public DoctorService(){
        this.file=new File("C:\\mycode\\oop\\ClinicManagementSystem\\src\\app\\doctors\\files\\doctors.txt");
        this.doctors=new ArrayList<>();
        this.loadDoctors();
    }

    public void loadDoctors(){
        try{
            Scanner scanner=new Scanner(file);
            while(scanner.hasNextLine()){
                String line =scanner.nextLine();
                Doctor doctor =new Doctor(line);
                this.doctors.add(doctor);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void saveDoctor(){
        try{
            FileWriter fileWriter=new FileWriter(file);
            PrintWriter printWriter=new PrintWriter(fileWriter);
            printWriter.println(toSaveDoctors());
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String toSaveDoctors(){
        String output="";
        int i;
        for(i=0;i<this.doctors.size()-1;i++){
            output+=this.doctors.get(i).toSaveDoctor()+"\n";
        }
        return output+this.doctors.get(i).toSaveDoctor();
    }

    public void showDoctors(){
        for (Doctor doctor : doctors){
            System.out.println(doctor.descriere());
        }
    }

    public Doctor getDoctorById(int id){
        for (Doctor doctor:doctors){
            if(doctor.getId()==id){
                return doctor;
            }
        }
        return null;
    }
}
