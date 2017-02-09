
public class Main {
	public static void main(String[] args) throws Exception {
		FactParser factParser = new FactParser(); // merkel
		RuleParser ruleParser = new RuleParser(); //   is

		ESProvider eSProvider = new ESProvider(factParser, ruleParser);
		eSProvider.collectAnswers();
		//System.out.println("the answer is: "+ eSProvider.evaulate());
		
		
	factParser.LoadXmlDocument("facts.xml");
	ruleParser.LoadXmlDocument("rules.xml");
		

		

		/*
		Value value = new MultipleValue("yes", "no,nono");
		Answer answer = new Answer();
		Question question = new Question("anyád?");
		answer.addValue(value);
		question.setAnswerEvaluator(answer);
		System.out.println(question.getEvaulatedAnswer());*/
		
	}
}
