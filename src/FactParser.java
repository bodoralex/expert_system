
public class FactParser extends XmlParser {
	// The parsed Facts added to the FactRepository by the FactParser.
	// The Fact stores the id and values that is parsed. It can get back
	// the ID set and the fixed value forby an id.
    @Override
    public void LoadXmlDocument(String fullPath) {
        elementTagName = "Fact";

   /* public RuleRepository getRuleRepository() {
        NodeList nodes = doc.getElementsByTagName("");
    */
    }
}
