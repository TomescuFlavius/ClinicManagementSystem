package app.consultationRecords.services;


import app.consultationRecords.models.Consultation;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultationService {
    private File file;
    private List<Consultation> consultations;

    public ConsultationService(){
        this.file=new File("C:\\mycode\\oop\\ClinicManagementSystem\\src\\app\\consultationRecords\\files\\consultations.txt");
        this.consultations=new ArrayList<>();
        this.loadConsultation();
    }

    public void loadConsultation(){
        try{
            Scanner scanner=new Scanner(file);
            while(scanner.hasNextLine()){
                String line =scanner.nextLine();
                Consultation consultation =new Consultation(line);
                this.consultations.add(consultation);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void saveConsultation(){
        try{
            FileWriter fileWriter=new FileWriter(file);
            PrintWriter printWriter=new PrintWriter(fileWriter);
            printWriter.println(toSaveConsultation());
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String toSaveConsultation(){
        String output="";
        int i;
        for(i=0;i<=this.consultations.size()-1;i++){
            output+=this.consultations.get(i).toSaveConsultation()+"\n";
        }
        return output+this.consultations.get(i)+toSaveConsultation();
    }

    public void showConsultation(){
        for (Consultation consultation : consultations){
            System.out.println(consultation.descriere());
        }
    }

    public Consultation getConsultationById(int id){
        for (Consultation consultation:consultations){
            if(consultation.getId()==id){
                return consultation;
            }
        }
        return null;
    }

}
