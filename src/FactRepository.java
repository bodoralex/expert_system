
public class FactRepository {
	public Iterator getIterator(){
		return null;
	}
	public void addFact(Fact fact){
		
	}
	
    class FactIterator implements Iterator
    {
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
