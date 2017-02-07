
public class Main {
	public static void main(String[] args) {
		FactParser factParser = new FactParser(); // merkel
		RuleParser ruleParser = new RuleParser(); // is

		ESProvider eSProvider = new ESProvider(factParser, ruleParser);

		XmlParser xmlParser = new XmlParser();
	}
}
