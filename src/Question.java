public class Question {
	String question;
	Answer answer;
	private String id;

	public Question(String question) {
		this.question = question;
	}

	public String getQuestion() {
		return question;
	}

	public void setAnswerEvaluator(Answer answer) {
		this.answer = answer;
	}

	public boolean getEvaulatedAnswer(String input) throws Exception {
		return answer.evaluateAnswerbyInput(input);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
// repóban legyenek a questionok