package P04Froggy;

import java.util.Iterator;

public class Lake<T> implements Iterable<T> {
	
	private T[] ints;
	
	public Lake(T... ints) {
		this.ints = ints;
	}
	
	private final class Frog implements Iterator<T>{
		
		private int cursor;
		
		public Frog() {
			this.cursor=0;
		}
		
		@Override
		public boolean hasNext() {
			if (cursor>=ints.length && cursor%2!=0){
				return false;
			}
			
			if (cursor>=ints.length && cursor%2==0){
				if (ints.length==1){
					return false;
				}
				cursor=1;
				return true;
			}
			
			
			return true;
		}
		
		@Override
		public T next() {
			T element = ints[cursor];
			cursor+=2;
			
			return element;
		}
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Frog();
	}
}
