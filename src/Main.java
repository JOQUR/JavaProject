// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Deserializer des = new Deserializer();
        new App();
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
            System.out.println("Location: " + des.getLocation());
            Thread.sleep(10000);
        }
    }
}