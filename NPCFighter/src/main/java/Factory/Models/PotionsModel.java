package Factory.Models;


import com.fasterxml.jackson.annotation.JsonProperty;

public class PotionsModel{
    @JsonProperty("Name")
    public String name;
    @JsonProperty("Type")
    public String type;
}