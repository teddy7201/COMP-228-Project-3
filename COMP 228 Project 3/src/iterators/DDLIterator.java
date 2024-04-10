package iterators;

import java.util.Iterator;
import nodes.DLLNode;
import adts.SortedList;

public class DDLIterator<E> implements Iterator<E> {


    protected int current = 0;
    public SortedList<E> list;
	
    protected int size;  // the number of elements in the collection
	
	
	public DDLIterator(SortedList<E> list,int size) {
		this.list = list;
		this.size = size;
	}

    protected DLLNode<E> head;
    protected DLLNode<E> tail;
    
    
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
/*
	public String InOrder() {
		
		// AHHHHHHHHHH
		String R = "";
		for (DLLNode<E> node : list){
			R= R+ node +"\n";
		}
			return R;
	}
	*/
	public E ReversedOrder() {
		// TODO Auto-generated method stub
		return null;
		}

	public E RanOrder() {
		// TODO Auto-generated method stub
		return null;
		}
	
	public E AltOrder() {
		// TODO Auto-generated method stub
		return null;
		}
	
	
	
	
	
	

}
