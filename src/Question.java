
//Every question has an Answer and every Answer can have more than one Value.
public class Question {
	String question;
	Answer answer;

	public Question(String question) {
		this.question = question;
	}

	public String getQuestion() {
		return question;
	}

	public void setAnswerEvaluator(Answer answer) {
		this.answer = answer;
	}

	public boolean getEvaulatedAnswer() throws Exception {
		return answer.evaluateAnswerbyInput();
	}

}
//repóban legyenek a questionok 