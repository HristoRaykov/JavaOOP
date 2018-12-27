package P02Collection;

import java.util.Iterator;
import java.util.List;

public class ListyIterator<T> implements Iterable<T>{
	
	private List<T> list;
	
	private int cursor;
	
	public ListyIterator(List<T> list) {
		this.list = list;
		cursor=0;
	}
	
	public boolean move(){
		if (cursor<list.size()-1){
			cursor++;
			return true;
		}
		return false;
	}

	public boolean hasNext(){
		if (this.cursor<this.list.size()-1){
			return true;
		}
		return false;
	}
	
	public void print() {
		if (this.list.size()==0){
			throw new IndexOutOfBoundsException("Invalid Operation!");
		}
		
		System.out.println(list.get(cursor));
	}
	
	
	
	public void printAll(){
		if (this.list.size()==0){
			throw new NullPointerException("Invalid Operation");
		}
		for (T t : this) {
			System.out.print(t.toString() + " ");
		}
		System.out.println();
	}
	
	
	@Override
	public Iterator<T> iterator() {
		return new MyIterator();
	}
	
	
	private final class MyIterator implements Iterator<T> {
		
		private int cursor1;
		
		public MyIterator() {
			this.cursor1 = 0;
		}
		
		@Override
		public boolean hasNext() {
			if (cursor1<list.size()){
				return true;
			}
			return false;
		}
		
		@Override
		public T next() {
			if (hasNext()){
				return list.get(cursor1++);
			}
			return null;
		}
		
	}
}
