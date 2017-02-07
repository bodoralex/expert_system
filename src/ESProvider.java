
public class ESProvider {
    protected FactParser factParser;
    protected RuleRepository ruleRepository;


    public ESProvider(FactParser factParser, RuleRepository ruleRepository) {
        this.factParser = factParser;
        this.ruleRepository = ruleRepository;

    }

}
