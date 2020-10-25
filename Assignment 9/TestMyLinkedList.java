import java.util.Iterator;

public class TestMyLinkedList {
  /** Main method */
  public static void main(String[] args) {
  MyLinkedList<String> list1 = new MyLinkedList<>();

    // Add elements to the list
    list1.add("America"); // Add it to the list
    list1.add("Canada"); // Add it to the list
    list1.add("German"); // Add it to the list
    list1.add("Japan"); // Add it to the list
    list1.add("Canada"); // Add it to the list
    System.out.println("Initial List: " + list1);
    if (list1.contains("Canada"))  // test contains
         System.out.println("List contains Canada!");
    else
         System.out.println("List does not contains Canada!");
    if (list1.contains("China"))  // test contains
         System.out.println("List contains China!");
    else
         System.out.println("List does not contains China!");

    // test get()
    System.out.println("Element at index 2 of List is " + list1.get(2));
    System.out.println("Element at index 5 of List is " + list1.get(5));

    // test indexOf() ans lastIndexOf()
    System.out.println("First Canada in List " + list1.indexOf("Canada"));
    System.out.println("Last Canada in List " + list1.lastIndexOf("Canada"));
    System.out.println("First China in List " + list1.indexOf("China"));
    System.out.println("Last China in List " + list1.indexOf("China"));

    // test set()
    System.out.println("List1 before set India at index 1: " + list1);
    list1.set(1, "India");
    System.out.println("List1 before set China at index 5 " + list1);
    list1.set(5, "China");
    System.out.println("List1 after set China at index 5 " + list1);

    // uncomment the following statements to test remove() in iterator

    System.out.println("List before remove " + list1);
    Iterator iter = list1.iterator();

    try {
      iter.remove();
    }
    catch (IllegalStateException ex) {
          System.out.println("remove() has to be called after next()");
      }

    String str = (String) iter.next();
    System.out.println("Next element in List: " + str);
    iter.remove();
    System.out.println("List after remove " + list1);
     
  }
}
