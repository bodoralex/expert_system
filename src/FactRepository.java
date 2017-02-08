import java.util.*;

public class FactRepository {
    LinkedHashSet<Fact> factHashSet = new LinkedHashSet<>();

    public FactRepository() {
        FactIterator fi = getIterator();
        while (fi.hasNext()) {
            Object element = fi.next();
        }
    }

    public FactIterator getIterator() {
        return new FactIterator();
    }

    public void addFact(Fact fact) {
        factHashSet.add(fact);
    }

    class FactIterator implements Iterator {
        private int currentIndex = 0;


        public boolean hasNext() {
            if (currentIndex < factHashSet.size()) {
                return true;
            }
            return false;
        }

        public Object next() {
            if (this.hasNext()) {
                return factHashSet.iterator().next();
            }
            return null;
        }
    }
}
