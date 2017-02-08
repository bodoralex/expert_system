import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public abstract class XmlParser {
    String elementTagName="";
    String attribute ="";
    public static void LoadXmlDocument(String fullPath) {
        try {
            File file = new File(fullPath);
            DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuild = dBF.newDocumentBuilder();
            Document doc = dBuild.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodes = doc.getElementsByTagName("Fact");
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                String name = ((Element) node).getAttribute("id");
                System.out.println(name);
                //Product product = createProduct(" ", name, price, 0);
                //products.add(product);
            }
        } catch (Exception e) {
            System.out.println("Generic exception message in loadProducts");
        }

    }
}
