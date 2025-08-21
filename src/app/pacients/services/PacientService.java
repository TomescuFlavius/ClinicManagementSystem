package app.pacients.services;
import app.pacients.models.Pacient;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PacientService {
    private File file;
    private List<Pacient> pacients;

    public PacientService(){
        this.file=new File("C:\\mycode\\oop\\incapsulare\\ClinicManagementSystem\\src\\app\\pacients\\files\\pacients.txt");
        this.pacients=new ArrayList<>();
        this.loadPacientss();
    }

    public void loadPacientss(){
        try{
            Scanner scanner=new Scanner(file);
            while(scanner.hasNextLine()){
                String line =scanner.nextLine();
                Pacient pacient =new Pacient(line);
                this.pacients.add(pacient);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void savePacient(){
        try{
            FileWriter fileWriter=new FileWriter(file);
            PrintWriter printWriter=new PrintWriter(fileWriter);
            printWriter.println(toSavePacients());
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String toSavePacients(){
        String output="";
        int i;
        for(i=0;i<this.pacients.size()-1;i++){
            output+= this.pacients.get(i).toSavePacient()+"\n";
        }
        return output+this.pacients.get(i).toSavePacient();
    }

    public void showPacients(){
        for (Pacient pacient : pacients){
            System.out.println(pacient.toString());
        }
    }

    public Pacient getPacientById(int id){
        for (Pacient pacient:pacients){
            if(pacient.getId()==id){
                return pacient;
            }
        }
        return null;
    }

    public Pacient getPacientByNameAndPassword(String email, String password){
        for(Pacient pacient:pacients){
            if(pacient.getEmail().equals(email) && pacient.getPassword().equals(password)){
                return pacient;
            }
        }
        return null;
    }

    public int generateId() {
        Random random = new Random();
        int randomId = random.nextInt(1000) + 1;
        while (this.getPacientById(randomId) != null) {
            randomId = random.nextInt(1000) + 1;
        }
        return randomId;
    }
}
