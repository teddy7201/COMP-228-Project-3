package iterators;

import java.util.Iterator;

public class ArrayIterator<E> implements Iterator<E> {
	
	private E[] collection;  // i.e., list for ArrayBasedList
	private int size;  // the number of elements in the collection
	private int current = 0;
	
	public ArrayIterator(E[] collection, int size) {
		this.collection = collection;
		this.size = size;
	}

	@Override
	public boolean hasNext() {
		return current < size;
	}

	@Override
	public E next() {
		E temp = collection[current];
		current++;
		return temp;
	}

}
