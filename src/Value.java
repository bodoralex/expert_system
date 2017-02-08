
//If the value is SingleValue only then we check the input that 
//is needed to be compared to the pattern. If the Value is 
//MultipleValue then we check the input in a range. if the input 
//is not matched we throw an exception.

public abstract class Value {
	protected String trueAnswerPattern;
	protected String falseAnswerPattern;

	protected Value(String trueValue, String falseValue) {
		trueAnswerPattern = trueValue;
		falseAnswerPattern = falseValue;
	}

	public String[] getTrueInputPattern() {
		String[] inputPatterns;
		inputPatterns = trueAnswerPattern.split(",");
		return inputPatterns;
	}

	public String[] getFalseInputPattern() {
		String[] inputPatterns;
		inputPatterns = falseAnswerPattern.split(",");
		return inputPatterns;
	}

	public void setTrueValue(String value) {
		this.trueAnswerPattern = value;
	}

	public void setFalseValue(String value) {
		this.falseAnswerPattern = value;
	}

}
