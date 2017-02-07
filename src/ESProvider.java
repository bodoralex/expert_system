public class ESProvider {

	protected FactParser factParser;
	protected RuleParser ruleParser;

	public ESProvider(FactParser factParser, RuleParser ruleParser) {

		this.factParser = factParser;
		this.ruleParser = ruleParser;
	}

	public void collectAnswers() {

	}

	public boolean getAnswersByQuestions(String questionID) {
		return false;
	}

	public String evaulate() {
		return null;
	}
}
