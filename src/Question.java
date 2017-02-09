class Question {
    private String question;
    private Answer answer;
    private String id;

    Question(String question) {
        this.question = question;
    }

    String getQuestion() {
        return question;
    }

    void setAnswerEvaluator(Answer answer) {
        this.answer = answer;
    }

    boolean getEvaulatedAnswer(String input) throws Exception {
        return answer.evaluateAnswerbyInput(input);
    }

    String getId() {
        return id;
    }

    void setId(String id) {
        this.id = id;
    }

}
