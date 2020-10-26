package Moduls;

import Factory.Factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class DownloadData {
    private Factory _factory;
    public DownloadData(Factory factory) {
        _factory = factory;
    }

    public String DownloadString(String downloadurl) throws IOException {
        URL url = new URL(downloadurl);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

        String Line = null;
        StringBuilder returnString = new StringBuilder();
        while ((Line = reader.readLine()) != null){
            returnString.append(Line);
        }
        //System.out.println(returnString.toString());
        return returnString.toString();
    }

}
