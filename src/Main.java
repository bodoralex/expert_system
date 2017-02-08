
public class Main {
	public static void main(String[] args) throws Exception {
		FactParser factParser = new FactParser(); // merkel
		RuleParser ruleParser = new RuleParser(); //   is

		//ESProvider eSProvider = new ESProvider(factParser, ruleParser);

		//XmlParser xmlParser = new XmlParser();
		
		///////s
		XmlParser.LoadXmlDocument("facts.xml");
		
		/*        Egy Question összerakása xdd
		Value value = new MultipleValue("yes", "no,nono");
		Answer answer = new Answer();
		Question question = new Question("anyád?");
		answer.addValue(value);
		question.setAnswerEvaluator(answer);
		System.out.println(question.getEvaulatedAnswer());*/
		
	}
}
