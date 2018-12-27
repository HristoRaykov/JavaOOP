package P01ListyIterator;

import java.util.List;

public class ListyIterator<T>{
	
	private List<T> list;
	
	private int cursor;
	
	public ListyIterator(List<T> list) {
		this.list = list;
		cursor=0;
	}
	
	public boolean Move(){
		if (hasNext()){
			this.cursor++;
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
}
