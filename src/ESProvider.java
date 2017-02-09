import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

class ESProvider {

    protected RuleParser ruleParser;
    protected HashMap<String, Boolean> questionIDAnswers;
    private FactParser factParser;

    public ESProvider(FactParser factParser, RuleParser ruleParser) {

        this.factParser = factParser;
        this.ruleParser = ruleParser;
    }

    public void collectAnswers() {
        questionIDAnswers = new HashMap<>();
        RuleRepository rR = ruleParser.getRuleRepository();
        Iterator it = rR.getIterator();
        while (it.hasNext()) {
            boolean exceptionRaised = false;
            Question q = (Question) it.next();
            System.out.println(q.getQuestion());
            Scanner scanner = new Scanner(System.in);
            boolean answer;
            while (!exceptionRaised) {
                try {
                    String input = scanner.next();
                    answer = q.getEvaulatedAnswer(input);
                    questionIDAnswers.put(q.getId(), answer);
                    exceptionRaised = true;
                } catch (Exception e) {
                    System.out.println("Wrong input!");
                    exceptionRaised = false;
                }
            }
        }
        System.out.println("I have no more questions.");
    }

    public boolean getAnswerByQuestion(String questionID) {
        System.out.println(questionIDAnswers.get(questionID));
        return questionIDAnswers.get(questionID);
    }

    public String evaulate() {
        FactRepository fp = factParser.getFactRepository();
        Iterator it = fp.getIterator();
        while (it.hasNext()) {
            Fact f = (Fact) it.next();
            Set<String> idSet = f.getIDSet();
            for (String string : idSet) {
                boolean factExpectation = f.getValueByID(string);
                boolean a = getAnswerByQuestion(string);
                if (factExpectation != a) {
                    break;
                }
            }
            return f.getDescription();
        }
        return null;
    }
}
