import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class FactParser extends XmlParser {
    // The parsed Facts added to the FactRepository by the FactParser.
    // The Fact stores the id and values that is parsed. It can get back
    // the ID set and the fixed value by an id.
    public FactRepository getFactRepository(){
        return null;
    }


    public void LoadXmlDocument(String fullPath) {
        try {
            File file = new File(fullPath);
            DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuild = dBF.newDocumentBuilder();
            Document doc = dBuild.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodes = doc.getElementsByTagName("Fact");
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                String name = ((Element) node).getAttribute("Eval");
                System.out.println(name);
                //needs to get all EVAL IDs and all Fact IDs somehow
            }
        } catch (Exception e) {
            System.out.println("Generic exception message in FactParser");
        }

    }
   /* public RuleRepository getRuleRepository() {
        NodeList nodes = doc.getElementsByTagName("");
    */
}

