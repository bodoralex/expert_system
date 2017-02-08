import java.util.HashMap;


public class ESProvider {

	protected FactParser factParser;
	protected RuleParser ruleParser;
	// protected FactRepository factRepository;
	// protected RuleRepository ruleRepository;

	public ESProvider(FactParser factParser, RuleParser ruleParser) {

		this.factParser = factParser;
		this.ruleParser = ruleParser;
		/*
		 * factRepository = factParser.getFactRepository(); ruleRepository =
		 * ruleParser.getRuleRepository();
		 * 
		 * The in the ESProvider constructor we store the FactRepository
		 * instance that returned by calling the getFactRepository method of the
		 * FactParser.
		 * 
		 * In the constructor we call the getRuleRepository method and we store
		 * the returned RuleRepository instance.
		 */ }

	public void collectAnswers() {
		// call the collectAnswers method that initializes a
		// map inside which stores the question identifier and the answer.
		// The collectAnswers method iterate through the questions and ask
		// the user for answering. Repeating the question till the right answer.
		// The possible answer is defined in the xml file. Call the
		// getEvaluateAnswer method with the given user input. If there
		// is no exception store the returning value by question ID.
		HashMap<String, String> mapOfAnswers = new HashMap<>();
		if () {
			mapOfAnswers.put()			//na igen itt elakadtam hogy pontosan hova mit kéne.
		}
	}

	public boolean getAnswersByQuestions(String questionID) {
		return false;
	}

	public String evaulate() {
		/*
		 * If we call the evaluate method of the ESProvider then it iterates
		 * through the Facts and checks the possible matches. If it find the
		 * answer it returns the description of the Fact otherwise null. If the
		 * return value is null the answer could not be expertedd. "A vegso FOR"
		 */ return null;
	}
}
