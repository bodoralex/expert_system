import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class Fact {


    public LinkedHashMap<String, Boolean> fact = new LinkedHashMap<>();
    protected String description;


    public Fact(String description, LinkedHashMap<String, Boolean> fact) {
        this.description = description;
        this.fact = fact;
    }

    public void setFactValueByID(String id, boolean value) {
        fact.put(id, value);
    }

    public Set<String> getIDSet() {
        return fact.keySet();
    }

    public boolean getValueByID(String id) {
        return fact.get(id);
    }

    public String getDescription() {
        return description;
    }
}
