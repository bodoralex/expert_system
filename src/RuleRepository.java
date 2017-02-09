import java.util.*;

public class RuleRepository {
	
	private QuestionIterator questionIterator;
	
	HashMap<String, Question> ruleHashMap = new LinkedHashMap<>();

	public RuleRepository() {
		// The rulerepository constructor initializes the QuestionIterator
		// inner class that implements the Iterator interface. With this
		// we can iterate through the questions later.
		
		
		questionIterator = new QuestionIterator();
		/*QuestionIterator qi = getIterator();
		while(qi.hasNext()){
			Object element = qi.next();

		}*/

	}
	

	public Question addQuestion(String id, Question question) {
		ruleHashMap.put(id, question);
		return question;
	}

	public QuestionIterator getIterator() {
		QuestionIterator iterator = new QuestionIterator();
		return iterator;
	}

	class QuestionIterator implements Iterator {
		int currIndex = 0;
		public Object next;

		public boolean hasNext() {
			if (currIndex < ruleHashMap.size()) {
				return true;
			}
			return false;
		}

		public Question next() {
			if (this.hasNext()) {
				return ruleHashMap.values().toArray(new Question[0])[currIndex++];  //how to iterate between keys i dont know
			}
			return null;
		}
	}
}
