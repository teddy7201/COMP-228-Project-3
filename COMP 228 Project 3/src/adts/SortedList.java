package adts;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.*;

import interfaces.ListInterface;

import nodes.DLLNode;
import iterators.DDLIterator;

public class SortedList<E> implements ListInterface<E>, Iterable<E> {
	protected DLLNode<E> head= null;
    protected DLLNode<E> tail;
    protected int counter=0; //counts size of the list
    protected SortedList<E> list;

    protected boolean found;  // true if element found, otherwise false
    protected DLLNode<E> location;   // indicates location of element when found is true
    protected int option;
    protected ArrayList PrintType;
    
    	@Override
        public void add(E element) {
    		
    		//Jonathan's set of Code
    		DLLNode<E> newNode = new DLLNode<E>(element);
            if(head==null) {
                head = newNode;
                tail = newNode;
                counter++;
                return;
            }//Inserting when the list is empty

            DLLNode<E> ptr = head;
            while(ptr != null) {
                if(((Comparable<E>)element).compareTo(ptr.getData()) > 0) {    //When this is true it means that element is greater than the data in ptr
                    ptr = ptr.getNext();        //moves to the next Node to compare further
                }//end if

                else {            //Executes if the element is less than or equal to the ptr data

                    if(ptr.getPrev() == null) {
                        newNode.setNext(ptr);
                        ptr.setPrev(newNode);
                        head = newNode;
                    }//end if

                    else {
                        newNode.setPrev(ptr.getPrev());
                        newNode.setNext(ptr);
                        ptr.getPrev().setNext(newNode);
                        ptr.setPrev(newNode);
                    }//end else
                    counter++;
                    return;

                }//end else
            }//end while
            tail.setNext(newNode); // create reference for newNode/element next from tail
            newNode.setPrev(tail); // set newNode previous to tail
            tail = newNode;            // newNode becomes tail
            counter++;                // keep count
    		
    		/* Code I tried making - Henry
                DLLNode<E> newNode = new DLLNode<E>(element);
                DLLNode<E> ptr = head;
                
                if(head==null) {//Inserting when list is empty
                    head = newNode;
                    tail = newNode;
                }
                else if(head.getNext() == null) {//Inserts newNode when there's only one node in list
                	if(((Comparable)(newNode.getData())).compareTo(head.getData()) > 0) {//if newNode greater than head,
                		newNode.setPrev(tail);
                		tail.setNext(newNode);
                		tail = newNode;
                	}
                	else {
                		newNode.setNext(head);
                		head.setPrev(newNode);
                		head = newNode;
                	}
                }
                else {
                	while (ptr != null) {
                		if(((Comparable)(ptr.getData())).compareTo(ptr.getNext().getData()) > 0) {
                        	newNode.setPrev(ptr.getPrev());
                            newNode.setNext(ptr);
                            ptr.getPrev().setNext(newNode);
                            ptr.setPrev(newNode);
                        }
                		else {
                			ptr = ptr.getNext();
                		}
                    }
                }
                */       
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
		

		public Iterator<E> iterator(){
			
			PrintType = new ArrayList<>(size());
			switch (option) {
			case 0:
				InOrder();
				break;
			case 1:
				ReversedOrder();
				break;
			case 2:
				RanOrder();
				break;
			case 3:
				AltOrder();
				break;
			}
			
			
			
			
			
			return new DDLIterator<E>(PrintType); 
			
	    	
	    }
		
		public int setPrintType(int option) {
		return this.option=option;
		}
		

	
		
		public void InOrder() {
			 DLLNode<E> ptr = head;
			while (ptr != null) {
				PrintType.add(ptr.getData());
				ptr=ptr.getNext();
			}
		
		}
		
		
		public void ReversedOrder() {
			DLLNode<E> ptr = tail;
			while (ptr != null) {
				PrintType.add(ptr.getData());
					
					ptr=ptr.getPrev();
				}
			
				
			
			}

		public void RanOrder() {
			ArrayList<E> temp1 = new ArrayList<E>();
			 DLLNode<E> ptr = head;
				while (ptr != null) {
					temp1.add(ptr.getData());
					ptr=ptr.getNext();
				}
				Collections.shuffle(temp1);
				PrintType.addAll(temp1);
			
			
			
	
			}
		
		public void AltOrder() {
			DLLNode<E> Front = head;
			DLLNode<E> End = tail;
			int count=0;
			if(size()%2== 0) {
			while (count != size()/2) {
				PrintType.add(Front.getData());
				PrintType.add(End.getData());
			
				Front=Front.getNext();
				End=End.getPrev();
				
				count++;
			}
			}else{
				
				while (count != size()/2) {
					PrintType.add(Front.getData());
					PrintType.add(End.getData());
				
					Front=Front.getNext();
					count++;
					End=End.getPrev();
					
					
				}
				
				PrintType.add(End.getData());
			}
		}
		
		
		@Override
		public String toString() {
			StringBuilder str = new StringBuilder();
			DLLNode<E> ptr = head;
			while (ptr != null) {
				str.append(ptr.getData() + "\n");
				ptr = ptr.getNext();
			 }
			return str.toString();
		}

	
}