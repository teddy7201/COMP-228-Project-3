package adts;
import interfaces.ListInterface;
import nodes.DLLNode;;

public class SortedList<E> implements ListInterface<E> {
	protected DLLNode<E> front= null;
    protected DLLNode<E> tail;
    protected int counter=0;

    // set by find method
        protected boolean found;  // true if element found, otherwise false
        protected int location;   // indicates location of element when found is true
        
    	@Override
        public void add(E element) {
            DLLNode<E> newNode = new DLLNode<E>(element);
            if(front==null) {
                front=newNode;
                }
            else if(front.getNext()==null){
                front.setNext(newNode);
            }else if (front.getNext()!=null) {
                newNode.setPrev(newNode);
            }
    	}
		@Override
		public boolean remove(E element) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean contains(E element) {
			// TODO Auto-generated method stub
			return false;
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

}