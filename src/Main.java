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

        try
        {
            StringBuilder result = new StringBuilder();
            String line;
            BufferedReader connector = new Connector("Zalas", Units.metric).getData();
            while((line = connector.readLine()) != null)
            {
                result.append(line);
            }
            connector.close();
            System.out.println(result);

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}