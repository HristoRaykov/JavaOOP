package P08AndP09CustomListSorter;

import java.util.Collections;

public class Sorter  {
	
	public static <T extends Comparable<T>> void sort(CustomList<T> list){
		
		Collections.sort(list.getElements());
		
	}
	
}
