// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Timer;
import java.util.TimerTask;


public class Main {


    private JPanel panelMain;
    private JButton button1;

    public static void main(String[] args) throws InterruptedException {
//        System.out.println(new Deserializer().json2string(new Connector().getData("Zalas", Units.metric)));
        Deserializer des = new Deserializer();
        JFrame frame = new JFrame("Main");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                des.updateFields();
            }
        };
        Timer timer = new Timer("Timer");
        long delay = 1000;
        timer.scheduleAtFixedRate(task, delay, delay);

        while (true)
        {
            System.out.println("Temperature: " + des.getTemp());
            System.out.println("Real Feel: " + des.getFeelsLike());
            System.out.println("Humidity: " + des.getHumidity() + "%");
            Thread.sleep(10000);
        }
    }
}