import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.File;

public class RuleParser extends XmlParser {

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
		Value value = new MultipleValue("yes,y", "no,nono");
		Answer answer = new Answer();
		Question question = new Question("kérdés0?");
		answer.addValue(value);
		question.setAnswerEvaluator(answer);
		question.setId("0");
		rr.addQuestion(question.getId(), question);
		
		
		Value value2 = new MultipleValue("yes,y", "no,nono");
		Answer answer2 = new Answer();
		Question question2 = new Question("kérdés2?");
		answer2.addValue(value2);
		question2.setAnswerEvaluator(answer2);
		question2.setId("2");
		rr.addQuestion(question2.getId(), question2);

		return rr;

	}
	

}