import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.LinkedHashMap;

public class FactParser extends XmlParser {

    private NodeList factElements;

    public void LoadXmlDocument(String fullPath) {
        try {
            File file = new File(fullPath);
            DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuild = dBF.newDocumentBuilder();
            Document doc = dBuild.parse(file);
            doc.getDocumentElement().normalize();
            factElements = doc.getElementsByTagName("Fact");
        } catch (Exception e) {
            System.out.println("Generic exception message in RuleParser");
        }

    }

    FactRepository getFactRepository() {

        LoadXmlDocument("facts.xml");
        FactRepository factRepo = new FactRepository();
        for (int i = 0; i < factElements.getLength(); i++) {
            Element factElement = (Element) factElements.item(i);
            Element descElement = (Element) factElement.getElementsByTagName("Description").item(0);
            String description = descElement.getTextContent();
            NodeList evalElements = factElement.getElementsByTagName("Eval");
            LinkedHashMap<String, Boolean> dictOfEvalElements = new LinkedHashMap<>();
            for (int j = 0; j < evalElements.getLength(); j++) {
                Element evalElement = (Element) evalElements.item(j);
                dictOfEvalElements.put(evalElement.getAttribute("id"), Boolean.parseBoolean(evalElement.getTextContent()));
            }

            Fact fact = new Fact(description, dictOfEvalElements);
            factRepo.addFact(fact);
        }

        return factRepo;
    }
}

