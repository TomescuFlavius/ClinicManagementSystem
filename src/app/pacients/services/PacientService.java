package app.pacients.services;
import app.pacients.models.Pacient;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PacientService {
    private File file;
    private List<Pacient> pacients;

    public PacientService(){
        this.file=new File("C:\\mycode\\oop\\ClinicManagementSystem\\src\\app\\pacients\\files\\pacients.txt");
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

    public void saveDoctor(){
        try{
            FileWriter fileWriter=new FileWriter(file);
            PrintWriter printWriter=new PrintWriter(fileWriter);
            printWriter.println(toSavePacient());
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String toSavePacient(){
        String output="";
        int i;
        for(i=0;i<=this.pacients.size()-1;i++){
            output+=this.pacients.get(i).toSavePacient()+"\n";
        }
        return output+this.pacients.get(i)+toSavePacient();
    }

    public void showPacients(){
        for (Pacient pacient : pacients){
            System.out.println(pacient.descriere());
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
}
