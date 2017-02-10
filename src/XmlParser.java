import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XmlParser {
	
	public NodeList LoadXmlDocument(String fullPath, String rootElement) {
		NodeList nodeList = null;
		try {
			File file = new File(fullPath);
			DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuild = dBF.newDocumentBuilder();
			Document doc = dBuild.parse(file);
			doc.getDocumentElement().normalize();
			nodeList = doc.getElementsByTagName(rootElement);
		} catch (Exception e) {
			System.out.println("Generic exception message in RuleParser");
			e.printStackTrace();
		}
		return nodeList;
	}
}
