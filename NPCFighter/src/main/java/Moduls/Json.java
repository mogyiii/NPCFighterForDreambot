package Moduls;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Json {
    private static ObjectMapper objectMapper = getDefultObjectMapper();
    public static ObjectMapper getDefultObjectMapper(){
        ObjectMapper DefaultObjectMapper = new ObjectMapper();
        return DefaultObjectMapper;
    }
    public JsonNode parse(String data) throws IOException{
        return objectMapper.readTree(data);
    }
}
