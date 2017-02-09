public class Main {
    public static void main(String[] args) throws Exception {
        FactParser factParser = new FactParser();
        RuleParser ruleParser = new RuleParser();

        ESProvider eSProvider = new ESProvider(factParser, ruleParser);
        eSProvider.collectAnswers();
        System.out.println(eSProvider.evaluate());
    }
}
