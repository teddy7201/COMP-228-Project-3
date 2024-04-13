package apps;


import adts.*;

public class PlayWithLists {

	public static void main(String[] args) {
		
	
		SortedList<String> list1 = new SortedList<>();
		  System.out.println(7%2);
		  System.out.println(6%2);
	    list1.add("Dykstra");
		list1.add("Wirth");
	    list1.add("Dahl");
	    list1.add("Nygaard");
	    list1.add("Liskov");
	    list1.add("DePasquale");
	    list1.add("Tom");
	    
	    System.out.println("\nComputer Scientists:\n" + list1);
	    
	    list1.setPrintType(2);
    for (String s : list1) {
    	System.out.println(s);
    	}

    System.out.println("\nComputer Scientists:\n" + list1);
    
    System.out.println("get Dahl: " + list1.get("Dahl"));
   System.out.println("get 3rd item: " + list1.get(2));
    
	    

   SortedList<Integer> list2 = new SortedList<Integer>();
    
	for (int i = 0; i < 10; i++) {
		list2.add(i);
		}
    System.out.println("\nDecimal Digits:\n" + list2);
	    
    /**/
	    System.out.print("\nDecimal Digits using for loop: ");
    for (int j : list2) {
	    	System.out.print(j + " ");
    }
    System.out.println("\n");
	    /**/
    
	    System.out.println(list2.remove(0) ? "0 removed" : "0 not found on the list");
	    System.out.println(list2.remove(2) ? "2 removed" : "2 not found on the list");
    System.out.println(list2.remove(4) ? "4 removed" : "4 not found on the list");
   System.out.println(list2.remove(6) ? "6 removed" : "6 not found on the list");
System.out.println(list2.remove(8) ? "8 removed" : "8 not found on the list");
    System.out.println(list2.remove(0) ? "0 removed" : "0 not found on the list");
	    System.out.println(list2.remove(4) ? "4 removed" : "4 not found on the list");

  System.out.println("\nDecimal Digits after removing evens:\n" + list2);
	

	while (!list2.isEmpty()) {
		list2.remove(list2.get(0));
	}
	    System.out.println("\nWhere have all the digits gone?\n" + list2);
	}
}
