package lambda;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Date;


public class LambdaTest {
    public static void main(String[] args) {
        ActionListener listener = event ->{
            System.out.println(event);
        };

        Timer timer = new Timer(1000, event -> System.out.println("time is "+new Date()));
        Timer timer1 = new Timer(1000,System.out::println);
        timer.start();
        timer1.start();
        JOptionPane.showMessageDialog (null , "Quit program?");
        System.exit(0);
    }
}
