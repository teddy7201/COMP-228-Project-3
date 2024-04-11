package adts;
import interfaces.ListInterface;
import iterators.DDLIterator;
import nodes.DLLNode;;

public class SortedList<E> implements ListInterface<E>, Iterable<E> {
	protected DLLNode<E> head= null;
    protected DLLNode<E> tail;
    protected int counter=0; //counts size of the list
    protected SortedList<E> list;

    protected boolean found;  // true if element found, otherwise false
    protected DLLNode<E> location;   // indicates location of element when found is true
    protected int option = 0;
        
    @Override
    public void add(E element) {
    		
            DLLNode<E> newNode = new DLLNode<E>(element);
            if(head==null) {
                head = newNode;
                tail = newNode;
            }//Inserting when list is empty
            
            else if(((Comparable<E>)element).compareTo(head.getData()) <= 0) {
            	newNode.setNext(head);
                head.setPrev(newNode);
                head = newNode;
            }//Inserting at the beginning
            
            else if (((Comparable<E>)element).compareTo(tail.getData()) >= 0) {
            	newNode.setPrev(tail);
            	tail.setNext(newNode);
            	tail = newNode;
            }//Inserting at the end
            
            else {
            	newNode.setPrev(location.getPrev());
                newNode.setNext(location);
                location.getPrev().setNext(newNode);
                location.setPrev(newNode);
            }//Inserting before location
            
    		counter++;	//Counting 
    	}
    	
    	public void find(E target) {
    		found = false;
    	    location = head;  

    	    while (location != null) { 
    	        if (location.getData().equals(target)) {
    	        	found = true;
    	        	return;
    	        }
    	        else {
    	        	location.getNext();
    	        }
    	    }
    	}
    	
    	
		@Override
		public boolean remove(E element) {
			find(element);
			if (found) {
				location.getPrev().setNext(location.getNext());
				location.getNext().setPrev(location.getPrev());
				counter--;
				}
			return found;
		}

		@Override
		public int size() {
			return counter;
		}
		@Override
		public boolean isEmpty() {
			return counter == 0;
		}
		@Override
		public boolean contains(E element) {
			find(element);
			return found;
		}
		@Override
		public E get(E element) {
		// return the first item on the list such that item.equals(element) is true
		// if no such item exists, return null
		
		DLLNode<E> current = head;
		
		while (current != null) {
			if (current.getData().equals(element)) {
				return current.getData();
			}
			current = current.getNext();
		}
		return null;
		
	}
		@Override
		public E get(int index) {
		// return the item at the specified position on the list;
		// the first item is at index equal to zero
		// if the index value is out of bounds, return null
			
			if (index < 0 || index > counter) { //out of bounds 
		        return null;
		    }
		    DLLNode<E> current = head;
		    for (int i = 0; i < index; i++) {
		        current = current.getNext();
		    }
		    return current.getData();
		}
		
		public DDLIterator<E> iterator(){
	    	return new DDLIterator<E>(list, counter, option);
	    }
		
		@Override
		public String toString() {
			StringBuilder str = new StringBuilder();
			DLLNode<E> ptr = head;
			while (ptr != null) {
				str.append(ptr.getData() + "\n");
				ptr.getNext();
			 }
			return str.toString();
		}
}