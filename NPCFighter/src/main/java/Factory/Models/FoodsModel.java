package Factory.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FoodsModel{
    @JsonProperty("Food")
    public String food;
    @JsonProperty("Heals")
    public int heals;
    @JsonProperty("IsMember")
    public boolean isMember;
    @JsonProperty("GPperHeal")
    public String gPperHeal;
}
