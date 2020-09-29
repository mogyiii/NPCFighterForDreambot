package Factory.Methods;

import Factory.Factory;
import org.dreambot.api.wrappers.widgets.message.Message;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class ChatBot {
    private Factory _factory;
    public ChatBot(Factory factory) {
        _factory = factory;
    }
    public void Answer(Message message){
        if(_factory.getMain().get_CombatVariables().get_WindowVariables().isUseChatBot()){
            if(PlayerIsExist(message.getUsername()) && !(message.getUsername().equals(_factory.getMain().getLocalPlayer().getName()))){
                _factory.getMain().getKeyboard().type(ResponseCutter(SendPostMessage(message.getMessage())));
            }
        }
    }
    private boolean PlayerIsExist(String message){
        for(int i = 0; i < _factory.getMain().getPlayers().all().size(); i++){
            if(message.contains(_factory.getMain().getPlayers().all().get(i).getName())){
                return true;
            }
        }
        return false;
    }
    private String SendPostMessage(String msg){
        String rawData = "ENTRY=" + msg + "";
        String type = "application/x-www-form-urlencoded";
        String Response = "";
        try {
            String encodedData = URLEncoder.encode( rawData, "UTF-8" );
            URL u = new URL("http://elbot-e.artificial-solutions.com/cgi-bin/elbot.cgi");
            HttpURLConnection conn = (HttpURLConnection) u.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty( "Content-Type", type );
            conn.setRequestProperty( "Content-Length", String.valueOf(encodedData.length()));
            OutputStream os = conn.getOutputStream();
            os.write(encodedData.getBytes());
            BufferedReader br = null;
            if (conn.getResponseCode() == 200) {
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String strCurrentLine;
                while ((strCurrentLine = br.readLine()) != null) {
                    Response += strCurrentLine;
                }
            }
            return Response;
        } catch (java.io.IOException e) {
            _factory.getMain().log("" + e.toString());
        }
        return Response;
    }
    private String ResponseCutter(String response){
        response = response.replaceAll("<!-- Country:   -->", "");
        String Message = "";
        for(int i = response.indexOf("<!-- Begin Response !-->"); i < response.indexOf("<!-- End Response !-->"); i++){
            Message += response.charAt(i);
        }
        return Message.replace('"', ' ').replace("<!-- Begin Response !-->", "");
    }
}
