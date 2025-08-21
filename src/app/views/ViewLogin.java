package app.views;

import app.pacients.models.Pacient;
import app.pacients.services.PacientService;

import java.time.LocalDate;
import java.util.Scanner;

public class ViewLogin {
    private Scanner scanner;
    private PacientService pacientService;

    public ViewLogin(){
        this.scanner=new Scanner(System.in);
        pacientService = new PacientService();
        this.play1();
    }


    public void meniu(){
        System.out.println("1. Register!");
        System.out.println("2. Login!");
    }

    public void play1(){
        boolean running = true;
        while (running){
            meniu();
            int option=Integer.parseInt(scanner.nextLine());
            switch (option){
                case 1: this.register();
                break;
                case 2: this.login();
                break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public void register(){

        System.out.println("Name:");
        String name= scanner.nextLine();
        System.out.println("Date of birth:");
        LocalDate date = LocalDate.parse(scanner.nextLine());
        System.out.println("CNP:");
        String cnp=scanner.nextLine();
        System.out.println("Email:");
        String email= scanner.nextLine();
        System.out.println("Phone number:");
        String phoneNumber= scanner.nextLine();
        System.out.println("Password:");
        String password = scanner.nextLine();

        Pacient pacient = new Pacient(name,date,cnp,email,phoneNumber,password);
        pacient.setId(pacientService.generateId());
        pacientService.savePacient();
        View view = new View(pacient);
    }

    public void login(){
        System.out.println("Email:");
        String email = scanner.nextLine();
        System.out.println("Password:");
        String password = scanner.nextLine();

        Pacient pacient = this.pacientService.getPacientByNameAndPassword(email,password);
        if(pacient==null){
            System.out.println("Incorect password/email");
        }
        else{
            View view =new View(pacient);
        }
    }





}
