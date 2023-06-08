// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class Main {


    public static void main(String[] args) {
//        System.out.println(new Deserializer().json2string(new Connector().getData("Zalas", Units.metric)));
        Deserializer des = new Deserializer();
        System.out.println(des.getTemp());
    }
}