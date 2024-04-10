package iterators;

import java.util.Iterator;
import nodes.DLLNode;

public class DDLIterator<E> implements Iterator<E> {
    protected DLLNode<E> top= new DLLNode<>();
    protected DLLNode<E> next= new DLLNode<>();
    
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E next() {
		// TODO Auto-generated method stub
		return null;
	}

}
