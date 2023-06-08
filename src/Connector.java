import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Connector
{

    private String location;

    private final String API_KEY = "8e543484d0eacb36acd5b111290b809f";
    private Units unit = Units.standard;

    public Connector(String location, Units unit)
    {
        this.location = location;
        this.unit = unit;
    }


    public BufferedReader getData()
    {
        return getData(this.location, this.unit);
    }
    public BufferedReader getData(String location, Units unit)
    {
        String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + API_KEY + "&units=" + unit.toString() + "&lang=pl";
        URL url = null;
        BufferedReader rd;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        URLConnection conn = null;
        try {
            conn = url.openConnection();
            rd = new BufferedReader((new InputStreamReader((conn.getInputStream()))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return rd;
    }
}
