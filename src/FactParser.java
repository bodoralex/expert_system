import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.LinkedHashMap;

public class FactParser extends XmlParser {
    // The parsed Facts added to the FactRepository by the FactParser.
    // The Fact stores the id and values that is parsed. It can get back
    // the ID set and the fixed value by an id.

    NodeList factElements;

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
            String factId = factElement.getAttribute("id");    // final return id get!
            String description = descElement.getTextContent();
            NodeList evalElements = factElement.getElementsByTagName("Eval");
            LinkedHashMap<String[],Boolean> dictOfEvalElements = new LinkedHashMap<>();
            for (int j = 0; j < evalElements.getLength(); j++) {
                Element evalElement = (Element) evalElements.item(j);
                String[] evalElementFirst = new String[evalElements.getLength()];
                evalElementFirst[j] = evalElement.getAttribute("id");
                dictOfEvalElements.put(evalElementFirst,Boolean.parseBoolean(evalElement.getTextContent()));
            }

        }
        return repo;
    }
}

