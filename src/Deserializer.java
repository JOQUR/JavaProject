import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;

public class Deserializer
{
    private float temp;
    private float feelsLike;
    private int windSpeed;
    private String desc;
    private int pressure;
    private int humidity;
    private static String location = "Kraków";


    public void setLocation(String val)
    {
        this.location = val;
    }

    public String getLocation()
    {
        return location;
    }

    public float getTemp()
    {
        return this.temp;
    }
    public float getHumidity()
    {
        return this.humidity;
    }
    public float getFeelsLike()
    {
        return this.feelsLike;
    }
    public String json2string()
    {
        StringBuilder result = new StringBuilder();
        String line;
        BufferedReader connector = new Connector(this.location, Units.metric).getData();
        while(true)
        {
            try {
                if ((line = connector.readLine()) == null) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            result.append(line);
        }
        try {
            connector.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result.toString();
    }

    public void updateFields()
    {
        String jsonStr = json2string();
        try {
            JSONObject jsonObject = new JSONObject(jsonStr);

            JSONObject o = (JSONObject) jsonObject.get("main");

            this.temp = o.getFloat("temp");
            this.feelsLike = o.getFloat("feels_like");
            this.humidity = o.getInt("humidity");
            this.desc = jsonObject.getString("name");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public Deserializer()
    {
        updateFields();
    }
}
