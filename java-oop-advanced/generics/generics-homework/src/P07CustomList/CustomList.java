package P07CustomList;

import java.util.ArrayList;
import java.util.List;

public class CustomList<T extends Comparable<T>>  {

	private List<T> list;
	
	public CustomList() {
		list=new ArrayList<>();
	}
	
	void add(T element){
		list.add(element);
	}
	
	T remove(int index){
		return list.remove(index);
	}
	
	boolean contains(T element){
		return list.contains(element);
	}
	
	void swap(int index1,int index2){
		T tempElement = list.get(index1);
		list.set(index1,list.get(index2));
		list.set(index2,tempElement);
	}
	
	int countGreaterThan(T other){
		int counter = 0;
		for (T element : list) {
			if (element.compareTo(other)>0){
				counter++;
			}
		}
		return counter;
	}
	
	T getMax(){
		T maxElement = list.get(0);
		for (T element : list) {
			if (element.compareTo(maxElement)>0){
				maxElement=element;
			}
		}
		return maxElement;
	}
	
	T getMin(){
		T minElement = list.get(0);
		for (T element : list) {
			if (element.compareTo(minElement)<0){
				minElement=element;
			}
		}
		return minElement;
	}
	
	int size(){
		return list.size();
	}
	
	T get(int index){
		return list.get(index);
	}
	
}
