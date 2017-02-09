import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;


public class RuleParser extends XmlParser {
    private NodeList nodeList;

    private static String[] generateValue(Node node) {
        NodeList nl = ((Element) node).getElementsByTagName("Selection");
        Node a1 = nl.item(0), a2 = nl.item(1);
        String trueSelection = a1.getTextContent(), falseSelection = a2.getTextContent();
        return new String[]{trueSelection, falseSelection};
    }

    public void LoadXmlDocument(String fullPath) {
        try {
            File file = new File(fullPath);
            DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuild = dBF.newDocumentBuilder();
            Document doc = dBuild.parse(file);
            doc.getDocumentElement().normalize();
            nodeList = doc.getElementsByTagName("Rule");
        } catch (Exception e) {
            System.out.println("Generic exception message in RuleParser");
        }

    }

    RuleRepository getRuleRepository() {

        LoadXmlDocument("rules.xml");
        RuleRepository repo = new RuleRepository();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            String id = ((Element) node).getAttribute("id");
            String questionMessage = ((Element) node).getElementsByTagName("Question").item(0).getTextContent();
            String v1 = generateValue(node)[0];
            String v2 = generateValue(node)[1];
            MultipleValue value = new MultipleValue(v1.trim(), v2.trim());
            Answer answer = new Answer();
            Question question = new Question(questionMessage);
            answer.addValue(value);
            question.setAnswerEvaluator(answer);
            question.setId(id);

            repo.addQuestion(id, question);
        }

        return repo;
    }
}