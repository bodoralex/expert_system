import java.util.LinkedHashMap;

public class RuleRepository {

    LinkedHashMap<String, Question> ruleHashMap = new LinkedHashMap<>();
    private QuestionIterator questionIterator;

    public RuleRepository() {
        questionIterator = new QuestionIterator();
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
        public Object next;
        int currIndex = 0;

        public boolean hasNext() {
            return currIndex < ruleHashMap.size();
        }

        public Question next() {
            if (this.hasNext()) {
                return ruleHashMap.values().toArray(new Question[0])[currIndex++];
            }
            return null;
        }
    }
}
