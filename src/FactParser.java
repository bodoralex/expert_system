import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.util.LinkedHashMap;

public class FactParser extends XmlParser {

	FactRepository getFactRepository() {

		NodeList factElements = LoadXmlDocument("facts.xml", "Fact");
		FactRepository factRepo = new FactRepository();
		for (int i = 0; i < factElements.getLength(); i++) {
			Element factElement = (Element) factElements.item(i);
			Element descElement = (Element) factElement.getElementsByTagName("Description").item(0);
			String description = descElement.getTextContent();
			NodeList evalElements = factElement.getElementsByTagName("Eval");
			LinkedHashMap<String, Boolean> dictOfEvalElements = new LinkedHashMap<>();
			for (int j = 0; j < evalElements.getLength(); j++) {
				Element evalElement = (Element) evalElements.item(j);
				dictOfEvalElements.put(evalElement.getAttribute("id"),
						Boolean.parseBoolean(evalElement.getTextContent()));
			}
			Fact fact = new Fact(description, dictOfEvalElements);
			factRepo.addFact(fact);
		}
		return factRepo;
	}
}
