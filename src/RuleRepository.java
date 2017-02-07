public class RuleRepository {

	public Question addQuestion(String id, Question question){
		return question;
	}
	public Iterator getIterator(){
		return null;
	}

    class QuestionIterator implements Iterator {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < currentSize && arrayList[currentIndex] != null;
        }

        @Override
        public Object next() {
            return arrayList[currentIndex++];
        }
    }
}
