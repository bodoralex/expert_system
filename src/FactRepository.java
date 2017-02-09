import java.util.HashSet;
import java.util.LinkedHashSet;

class FactRepository {
    private HashSet<Fact> factHashSet = new LinkedHashSet<>();

    FactRepository() {
        FactIterator fi = getIterator();
        while (fi.hasNext()) {
            Object element = fi.next();
        }
    }

    FactIterator getIterator() {
        return new FactIterator();
    }

    void addFact(Fact fact) {
        factHashSet.add(fact);
    }

    class FactIterator implements Iterator {
        private int currentIndex = 0;


        public boolean hasNext() {
            return currentIndex < factHashSet.size();
        }

        public Fact next() {
            if (this.hasNext()) return factHashSet.toArray(new Fact[0])[currentIndex++];
            return null;
        }
    }
}
