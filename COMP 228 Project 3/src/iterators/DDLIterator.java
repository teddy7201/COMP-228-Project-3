package iterators;

import java.util.Iterator;
import nodes.DLLNode;
import adts.SortedList;
import java.util.ArrayList;

public class DDLIterator<E> implements Iterator<E> {


    protected int current = 0;
    public ArrayList<E> list;
    protected int size;  // the number of elements in the collection
	
	
	public DDLIterator(ArrayList<E> PrintType) {
		this.list = PrintType;
		this.size = PrintType.size();
		
		
	}

    
    
	@Override
	public boolean hasNext() {

			return current < size;
		
	}
	@Override
	public E next() {
		
		
		E temp = list.get(current);
		current++;
		return temp;
		}

	
	
	


}
