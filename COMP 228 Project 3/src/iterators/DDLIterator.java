package iterators;

import java.util.Iterator;
import nodes.DLLNode;
import adts.SortedList;

public class DDLIterator<E> implements Iterator<E> {


    protected int current = 0;
    public SortedList<E> list;
    protected int option;
    
	
    protected int size;  // the number of elements in the collection
	
	
	public DDLIterator(SortedList<E> list,int size, int option) {
		this.list = list;
		this.size = size;
		this.option = option;
		if (option == 0) {
			current = 0;
		}
		else {
			current = size-1;
		}
	}

    protected DLLNode<E> head;
    protected DLLNode<E> tail;
    
    
	@Override
	public boolean hasNext() {
		if(option == 0) {
			return current < size;
		}
		else {
			return current >= 0;
		}
	}
	@Override
	public E next() {
		E temp = list.get(current);
		if (option == 0) {
			current++;
		}
		else {
			current--;
		}
		return temp;
		}
/*
	public String InOrder() {
		
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
