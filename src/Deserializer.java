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
    private String json2string()
    {
        StringBuilder result = new StringBuilder();
        String line;
        BufferedReader connector = new Connector("Zalas", Units.metric).getData();
        while(true)
        {
            try {
                if (!((line = connector.readLine()) != null)) break;
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

    private void updateFields()
    {
        String jsonStr = json2string();
        JSONObject jsonObject = new JSONObject(jsonStr);
        JSONObject o = (JSONObject) jsonObject.get("main");

        this.temp = o.getFloat("temp");
    }

    public Deserializer()
    {
        updateFields();
    }
}
