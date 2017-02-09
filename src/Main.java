
public class Main {
	public static void main(String[] args) throws Exception {
		FactParser factParser = new FactParser(); // merkel
		RuleParser ruleParser = new RuleParser(); //   is

		ESProvider eSProvider = new ESProvider(factParser, ruleParser);
		eSProvider.collectAnswers();
		System.out.println(eSProvider.evaulate());
		
		//factParser.LoadXmlDocument("facts.xml");
		//ruleParser.LoadXmlDocument("rules.xml");
		

		


		
	}
}
