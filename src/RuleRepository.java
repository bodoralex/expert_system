public class RuleRepository {
	
	public Question addQuestion(String id, Question question){
		return question;
	}
	public Iterator getIterator(){
		return null;
	}
	
	
    class QuestionIterator implements Iterator
    {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }
    }
}
