class Answer {

    private Value value;

    boolean evaluateAnswerbyInput(String input) throws Exception {
        for (String acceptableTrue : value.getTrueInputPattern()) {
            if (input.equals(acceptableTrue))
                return true;
        }
        for (String acceptableFalse : value.getFalseInputPattern()) {
            if (input.equals(acceptableFalse))
                return false;
        }
        throw new Exception();

    }

    void addValue(Value value) {
        this.value = value;
    }

}
