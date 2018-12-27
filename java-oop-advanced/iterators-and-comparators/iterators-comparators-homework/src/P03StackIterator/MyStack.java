package P03StackIterator;

import java.util.Arrays;
import java.util.Iterator;

public class MyStack<T> implements Iterable<T> {
	
	private int capacity;
	
	private T[] stack;
	
	private int currentIndex;
	
	public MyStack() {
		capacity = 4;
		currentIndex = 0;
		this.stack = (T[]) new Object[capacity];
	}
	
	public void push(T element) {
		if (currentIndex == stack.length) {
			grow();
		}
		stack[currentIndex] = element;
		currentIndex++;
	}
	
	private void grow() {
		stack = Arrays.copyOf(stack, capacity * 2);
	}
	
	public T pop() throws IndexOutOfBoundsException {
		try {
			T element = stack[--currentIndex];
			stack[currentIndex]=null;
			return element;
		} catch (IndexOutOfBoundsException e) {
			throw new IndexOutOfBoundsException("No elements");
		}
	}
	
	
	@Override
	public Iterator<T> iterator() {
		return new StackIterator();
	}
	
	public final class StackIterator implements Iterator<T> {
		
		private int cursor;
		
		public StackIterator() {
			cursor = currentIndex - 1;
		}
		
		@Override
		public boolean hasNext() {
			return cursor >= 0;
		}
		
		@Override
		public T next() {
			return stack[cursor--];
		}
	}
	
}
