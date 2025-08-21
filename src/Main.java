import app.doctors.models.Doctor;
import app.pacients.models.Pacient;
import app.views.View;
import app.views.ViewLogin;

public class Main {
    public static void main(String[] args) {

            ViewLogin viewLogin = new ViewLogin();
            viewLogin.play1();

//        Doctor doctor=Doctor.builder()
//                .id(1)
//                .name("Al")
//                .specializare("a")
//                .program("1")
//                .build();
//        System.out.println(doctor);
    }
}