public class RuleRepository {
    class QuestionIterator implements Iterator {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < currentSize && arrayList[currentIndex] != null;
        }

        @Override
        public Object next() {
            return arrayList[currentIndex++];
        }
    }
}
