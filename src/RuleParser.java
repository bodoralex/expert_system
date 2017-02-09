import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.File;


public class RuleParser extends XmlParser {
    // The RuleParser adds the wuestions with id to the
    // RuleRepository instance. This is stored in a map
    // inside the RuleRepository.

    /*  public void LoadXmlDocument(String fullPath) {
          elementTagName = "Rule";
  */
        NodeList nodeList;
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

    RuleRepository getRuleRepository()
    {

        LoadXmlDocument("rules.xml");
        RuleRepository repo = new RuleRepository();
        for(int i = 0; i < nodeList.getLength(); i++)
        {
            Node node = nodeList.item(i);

            String id = ((Element)node).getAttribute("id");    // Rule id get!
            String questionMessage = ((Element) node).getElementsByTagName("Question").item(0).getTextContent();
            //Question textcontent GET!
            String v1 = generateValue(node)[0];
            String v2 = generateValue(node)[1];//makes value from current iterated node
            MultipleValue value = new MultipleValue(v1.trim(),v2.trim()); //balra true value jobbra false
            Answer answer = new Answer();
            Question question = new Question(questionMessage);
            answer.addValue(value);
            question.setAnswerEvaluator(answer);
            question.setId(id);

            repo.addQuestion(id, question); //question létrehozva a kiszedett rule id és question contentből
        }

        return repo;
    }
    public static String[] generateValue(Node node){
        Node n = ((Element)node).getElementsByTagName("Answer").item(0); //NODE, NEM NODELIST azért 0
        NodeList nl = ((Element)node).getElementsByTagName("Selection"); // selectionök megvanak, ez LISTA, ezért nem 0
        Node a1=nl.item(0),a2=nl.item(1);
        String trueSelection = a1.getTextContent(),falseSelection = a2.getTextContent(); //a1 true, a2 false válasz
        String[] trueAndFalse = {trueSelection,falseSelection};
        return trueAndFalse;
    }
}