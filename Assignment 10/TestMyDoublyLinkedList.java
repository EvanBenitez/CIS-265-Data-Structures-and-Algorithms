import java.util.Iterator;

public class TestMyDoublyLinkedList {
  /** Main method */
  public static void main(String[] args) {
  MyDoublyLinkedList<String> list = new MyDoublyLinkedList<>();

     // Test add and removce methods
    list.addFirst("America"); // Add it to the list
    System.out.println("(1) " + list);

    list.add(0, "Canada"); // Add it to the beginning of the list
    System.out.println("(2) " + list);

    list.addLast("Russia"); // Add it to the end of the list
    System.out.println("(3) " + list);

    list.addFirst("France"); // Add it to the beginning of the list
    System.out.println("(4) " + list);

    list.add(2, "Germany"); // Add it to the list at index 2
    System.out.println("(5) " + list);

    list.add(5, "Norway"); // Add it to the list at index 5
    System.out.println("(6) " + list);

    list.remove(0); // Same as list.remove("Poland") in this case
    System.out.println("(7) " + list);

    list.removeFirst(); // Remove the element at index 2
    System.out.println("(8) " + list);

    list.removeFirst(); // Remove the element at index 2
    System.out.println("(9) " + list);

    list.remove(2); // Remove the element at index 2
    System.out.println("(10) " + list);

    list.removeLast(); // Remove the last element
    System.out.println("(11) " + list);

    list.addLast("Russia"); // Add it to the end of the list
    System.out.println("(12) " + list);

    list.addFirst("China"); // Add it to the list
    System.out.println("(13) " + list);

    list.add(0, "Canada"); // Add it to the beginning of the list
    System.out.println("(14) " + list);

    list.addLast("India"); // Add it to the end of the list
    System.out.println("(15) " + list);

    list.removeLast(); // Remove the last element
    System.out.println("(16) " + list);

    /* test reverse */
    list.reverse();
    System.out.println("reversed list: " + list);

   }
}
