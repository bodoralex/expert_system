import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

class ESProvider {

    private RuleParser ruleParser;
    private HashMap<String, Boolean> questionIDAnswers;
    private FactParser factParser;

    ESProvider(FactParser factParser, RuleParser ruleParser) {

        this.factParser = factParser;
        this.ruleParser = ruleParser;
    }

    void collectAnswers() {
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

    private boolean getAnswerByQuestion(String questionID) {
        return questionIDAnswers.get(questionID);
    }

    String evaulate() {
        Fact w;
        FactRepository factRepository = factParser.getFactRepository();
        Iterator it = factRepository.getIterator();
        while (it.hasNext()) {
            Fact f = (Fact) it.next();
            w = f;
            Set<String> idSet = f.getIDSet();
            boolean ccc = true;
            for (String string : idSet) {
                Boolean factExpectation = f.getValueByID(string);
                Boolean a = getAnswerByQuestion(string);
                if (!factExpectation.equals(a)) {
                    ccc = false;
                }

            }
            if (ccc) return w.description;
        }
        return null;
    }
}
