package Moduls;

import Factory.Factory;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Json {
    private Factory _factory;
    public Json(Factory factory) {
        _factory = factory;
    }

    public String getJson(String JsonPath){
        BufferedReader reader = null;
        String line = null;

        reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader()
                .getResourceAsStream(JsonPath)));
        StringBuilder content = new StringBuilder();


        while (true) {
            try {
                if (!((line = reader.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            content.append(line);
            content.append(System.lineSeparator());
        }

        return content.toString();

    }

    public Gson GetNewGson(){
        return new Gson();
    }
}
