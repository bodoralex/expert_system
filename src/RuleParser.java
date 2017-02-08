import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;

public class RuleParser extends XmlParser {
    // The RuleParser adds the wuestions with id to the
    // RuleRepository instance. This is stored in a map
    // inside the RuleRepository.

    public void LoadXmlDocument(String fullPath) {
        elementTagName = "Rule";

   /* public RuleRepository getRuleRepository() {
        NodeList nodes = doc.getElementsByTagName("");
    */
    }
}