
public class Main {
	public static void main(String[] args) throws Exception {
		FactParser factParser = new FactParser(); // merkel
		RuleParser ruleParser = new RuleParser(); //   is

		ESProvider eSProvider = new ESProvider(factParser, ruleParser);
		eSProvider.collectAnswers();
		//System.out.println("the answer is: "+ eSProvider.evaulate());
		
		
		//XmlParser xmlParser = new XmlParser();
		
		
		//RuleParser ruleParser & new RuleParser();
		
		
		//XmlParser.LoadXmlDocument("facts.xml");
		
		/*
		Value value = new MultipleValue("yes", "no,nono");
		Answer answer = new Answer();
		Question question = new Question("anyád?");
		answer.addValue(value);
		question.setAnswerEvaluator(answer);
		System.out.println(question.getEvaulatedAnswer());*/
		
	}
}
