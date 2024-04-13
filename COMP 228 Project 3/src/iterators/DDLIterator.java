package iterators;

import java.util.Iterator;
import nodes.DLLNode;
import adts.SortedList;
import java.util.ArrayList;

public class DDLIterator<E> implements Iterator<E> {


    protected int current = 0;
    public ArrayList<E> list;
    protected int size;  // the number of elements in the collection
	
	
	public DDLIterator(ArrayList<E> PrintType) {// Robert and Emerson
		this.list = PrintType;
		this.size = PrintType.size();
		
	}

    
    
	@Override
	public boolean hasNext() {// Robert and Emerson

			return current < size;
		
	}
	@Override
	public E next() {// Robert and Emerson
		
		
		E temp = list.get(current);
		current++;
		return temp;
		}

	
	
	


}
