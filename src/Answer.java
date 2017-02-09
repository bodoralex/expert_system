//The answer has the responsibility to evaluate the answers by 
//the given user input and the stored pattern in the stored value. 
//If the value is SingleValue only then we check the input that 
//is needed to be compared to the pattern. If the Value is 
//MultipleValue then we check the input in a range. if the input 
//is not matched we throw an exception.

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
