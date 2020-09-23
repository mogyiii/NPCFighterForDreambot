package Factory.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
public class AttackSpellModel{
    @JsonProperty("Spell")
    public String spell;
    @JsonProperty("MagicLevel")
    public int magicLevel;
    @JsonProperty("Membersonly")
    public String membersonly;
    @JsonProperty("RunesRequired")
    public String runesRequired;
    @JsonProperty("Experience")
    public double experience;
    @JsonProperty("BaseMaxhit")
    public String baseMaxhit;
    @JsonProperty("Castingcost")
    public int castingcost;
    @JsonProperty("Notes")
    public String notes;
}
