import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import javax.sound.midi.Soundbank;

public class ESProvider {

	protected FactParser factParser;
	protected RuleParser ruleParser;
	// protected FactRepository factRepository;
	// protected RuleRepository ruleRepository;
	protected HashMap<String, Boolean> questionIDAnswers;

	public ESProvider(FactParser factParser, RuleParser ruleParser) {

		this.factParser = factParser;
		this.ruleParser = ruleParser;
		questionIDAnswers = new HashMap();
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
		RuleRepository pp = ruleParser.getRuleRepository();
		Iterator it = pp.getIterator();
		boolean exceptionRaised = false;
		while (it.hasNext()) {
			Question q = (Question) it.next();
			System.out.println(q.getQuestion());
			Scanner scanner = new Scanner(System.in);
			String input = scanner.next();
			boolean answer;
			while (!exceptionRaised) {
				try {
					answer = q.getEvaulatedAnswer(input);
					questionIDAnswers.put(q.getId(), answer);
					exceptionRaised = true;
				} catch (Exception e) {
					exceptionRaised = true;
					System.out.println("Wrong input!");
				}

			}

		}
	}

	public boolean getAnswersByQuestions(String questionID) {
		return questionIDAnswers.get(questionID);
	}

	public String evaulate() {
		FactRepository fp = factParser.getFactRepository();
		Iterator it = fp.getIterator();
		while (it.hasNext()) {
			Fact f = (Fact) it.next();
			//boolean end = false;
			//while(end){
				Set <String> s = f.getIDSet();
				for (String string : s) {
					boolean factExpextation = f.getValueByID(string);
					boolean a = getAnswersByQuestions(string);
					if(factExpextation != a){
						break;
					}
				}
				return f.getDescription();
			//}
		}
		return null;
	}
}
