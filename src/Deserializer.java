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
    private String json2string()
    {
        StringBuilder result = new StringBuilder();
        String line;
        BufferedReader connector = new Connector("Zalas", Units.metric).getData();
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
        JSONObject jsonObject = new JSONObject(jsonStr);
        JSONObject o = (JSONObject) jsonObject.get("main");

        this.temp = o.getFloat("temp");
        this.feelsLike = o.getFloat("feels_like");
        this.humidity = o.getInt("humidity");
    }

    public Deserializer()
    {
        updateFields();
    }
}
