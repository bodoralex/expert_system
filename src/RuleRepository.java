public class RuleRepository {
	// protected QuestionIterator questionIterator ;

	public RuleRepository() {
		// questionIterator = new QuestionIterator();
		// The rulerepository constructor initializes the QuestionIterator
		// inner class that implements the Iterator interface. With this
		// we can iterate through the questions later.

	}

	public Question addQuestion(String id, Question question) {

		return question;
	}

	public Iterator getIterator() {
		return null;
	}

	class QuestionIterator implements Iterator {
		private int currentIndex = 0;

		@Override
		public boolean hasNext() {
			return false;// currentIndex < currentSize && arrayList[currentIndex] != null;
		}

		@Override
		public Object next() {
			return null;// arrayList[currentIndex++];
		}
	}
}
