public class Answer {

    protected Value value;

    public boolean evaluateAnswerbyInput(String input) throws Exception {
        for (String acceptableTrue : value.getTrueInputPattern()) {
            if (input.equals(acceptableTrue))
                return true;
        }
        for (String acceptableFalse : value.getFalseInputPattern()) {
            if (input.equals(acceptableFalse))
                return false;
        }
        Exception e = new Exception();
        throw e;

    }

    public void addValue(Value value) {
        this.value = value;
    }

}
