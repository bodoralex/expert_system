
public abstract class Value {
	private String trueAnswerPattern;
	private String falseAnswerPattern;

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
