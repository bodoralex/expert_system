import java.util.LinkedHashMap;

class RuleRepository {

    private LinkedHashMap<String, Question> ruleHashMap = new LinkedHashMap<>();

    RuleRepository() {
        QuestionIterator questionIterator = new QuestionIterator();
    }


    Question addQuestion(String id, Question question) {
        ruleHashMap.put(id, question);
        return question;
    }

    QuestionIterator getIterator() {
        return new QuestionIterator();
    }

    class QuestionIterator implements Iterator {
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
