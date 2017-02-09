import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.File;

public class RuleParser extends XmlParser {
	// The RuleParser adds the wuestions with id to the
	// RuleRepository instance. This is stored in a map
	// inside the RuleRepository.

	/*
	 * public void LoadXmlDocument(String fullPath) { elementTagName = "Rule";
	 */
	public void LoadXmlDocument(String fullPath) {
		try {
			File file = new File(fullPath);
			DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuild = dBF.newDocumentBuilder();
			Document doc = dBuild.parse(file);
			doc.getDocumentElement().normalize();
			NodeList nodes = doc.getElementsByTagName("Rule");
			
			RuleRepository rr = new RuleRepository();
			
			for (int i = 0; i < nodes.getLength(); i++) {
				Node node = nodes.item(i);
				String name = ((Element) node).getAttribute("id");
				System.out.println(name);// itt majd fel kell tölteni egy
											// hashMapet
			}
		} catch (Exception e) {
			System.out.println("Generic exception message in RuleParser");
		}

	}

	public RuleRepository getRuleRepository() {
		RuleRepository rr = new RuleRepository();
		Value value = new MultipleValue("yes", "no,nono");
		Answer answer = new Answer();
		Question question = new Question("kérdés?");
		answer.addValue(value);
		question.setAnswerEvaluator(answer);
		rr.addQuestion("0", question);
		rr.addQuestion("1", question);

		return rr;

	}
	

}