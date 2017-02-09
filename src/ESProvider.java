import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class ESProvider {

	protected FactParser factParser;
	protected RuleParser ruleParser;
	// protected FactRepository factRepository;
	// protected RuleRepository ruleRepository;
	protected HashMap<String, Boolean> questionIDAnswers;

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
		questionIDAnswers = new HashMap<>();
		RuleRepository rR = ruleParser.getRuleRepository();
		Iterator it = rR.getIterator();
		while (it.hasNext()) {
			boolean exceptionRaised = false;
			Question q = (Question) it.next();
			System.out.println(q.getQuestion());
			Scanner scanner = new Scanner(System.in);
			boolean answer;
			while (!exceptionRaised) {
				try {
					String input = scanner.next();
					answer = q.getEvaulatedAnswer(input);
					questionIDAnswers.put(q.getId(), answer);
					exceptionRaised = true;
				} catch (Exception e) {
					System.out.println("Wrong input!");
					exceptionRaised = false;
				}
			}
		}
		System.out.println("I have no more questions.");
	}

	public boolean getAnswerByQuestion(String questionID) {
		//System.out.println(questionID);
		//System.out.println(questionIDAnswers.get(questionID));
		//System.out.println(Arrays.asList(questionIDAnswers));
		System.out.println(questionIDAnswers.get(questionID));
		return questionIDAnswers.get(questionID);
	}

	public String evaulate() {
		FactRepository fp = factParser.getFactRepository();
		Iterator it = fp.getIterator();
		while (it.hasNext()) {
			Fact f = (Fact) it.next();
			//boolean end = false;
			//while(end){
				Set <String> idSet = f.getIDSet();
				for (String string : idSet) {
					boolean factExpextation = f.getValueByID(string);
					boolean a = getAnswerByQuestion(string);
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
