package Moduls;

import com.google.gson.Gson;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Json {

    public String getJson(String JsonPath){
        File JsonFile;
        String JsonString = null;
        try {

            JsonFile = new File(Toolkit.getDefaultToolkit().getClass().getResource(JsonPath).toURI());
            Scanner myReader = new Scanner(JsonFile);
            while (myReader.hasNextLine()) {
                JsonString += myReader.nextLine();
            }
            myReader.close();
        } catch (URISyntaxException | FileNotFoundException e) {
            e.printStackTrace();
        }
        /*StringBuilder JsonString = new StringBuilder();
        for(int i = 0; i < JsonLine.size() -1; i++ ){
            JsonString.append(JsonLine.get(i));
        }*/
        System.out.println(JsonString);
        return JsonString;

    }
    public Gson GetNewGson(){
        return new Gson();
    }
}
