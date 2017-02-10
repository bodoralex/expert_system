import java.util.LinkedHashMap;
import java.util.Set;

public class Fact {

	private LinkedHashMap<String, Boolean> fact = new LinkedHashMap<>();

	private String description;

	Fact(String description, LinkedHashMap<String, Boolean> fact) {
		this.description = description;
		this.fact = fact;
	}

	public void setFactValueByID(String id, boolean value) {
		fact.put(id, value);
	}

	Set<String> getIDSet() {
		return fact.keySet();
	}

	boolean getValueByID(String id) {
		return fact.get(id);
	}

	public String getDescription() {
		return description;
	}
}
