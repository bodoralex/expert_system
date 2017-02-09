import java.util.*;

public class RuleRepository {
	
	private QuestionIterator questionIterator;
	
	LinkedHashMap<String, Question> ruleHashMap = new LinkedHashMap<>();

	public RuleRepository() {
		// questionIterator = new QuestionIterator();
		// The rulerepository constructor initializes the QuestionIterator
		// inner class that implements the Iterator interface. With this
		// we can iterate through the questions later.
		this.questionIterator = new QuestionIterator();
		QuestionIterator qi = getIterator();
		while(qi.hasNext()){
			Object element = qi.next();

		}

	}
	

	public Question addQuestion(String id, Question question) {
		ruleHashMap.put(id, question);
		return question;
	}

	public QuestionIterator getIterator() {
		return questionIterator;
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

		public Object next() {
			if (this.hasNext()) {
				return ruleHashMap.get();  //how to iterate between keys i dont know
			}
			return null;
		}
	}
}
