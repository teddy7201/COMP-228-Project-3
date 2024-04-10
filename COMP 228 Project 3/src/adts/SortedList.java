package adts;
import interfaces.ListInterface;
import nodes.DLLNode;;

public class SortedList<E> implements ListInterface<E> {
	protected DLLNode<E> head= null;
    protected DLLNode<E> tail;
    protected int counter=0; //counts size of the list
    protected SortedList<E> list;

    protected boolean found;  // true if element found, otherwise false
    protected DLLNode<E> location;   // indicates location of element when found is true
        
    public SortedList() {
    	list = new SortedList<E>();
    }
    
    	@Override
        public void add(E element) {
            DLLNode<E> newNode = new DLLNode<E>(element);
            if(head==null) {
                head=newNode;
                }
            else if(head.getNext()==null){
                head.setNext(newNode);
            }else if (head.getNext()!=null) {
                newNode.setPrev(newNode);
            }
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
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public E get(int index) {
			// TODO Auto-generated method stub
			return null;
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