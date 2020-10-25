/*
 * Name: Evan Benitez
 * CSU ID: 2486032
 * CIS 265: Assignment 10
 * Discription: Creates the MyDoublyLinkedList class
*/

//implementing bonus
public class MyDoublyLinkedList<E> implements MyList<E> {
  private Node<E> head, tail;
  private int size = 0; // Number of elements in the list

  /** Create an empty list */
  public MyDoublyLinkedList() {
  }

  /** Create a list from an array of objects */
  public MyDoublyLinkedList(E[] objects) {
    for (int i = 0; i < objects.length; i++)
      add(objects[i]);
  }

  /** Return the head element in the list */
  public E getFirst() {
    if (size == 0) {
      return null;
    }
    else {
      return head.element;
    }
  }

  /** Return the last element in the list */
  public E getLast() {
    if (size == 0) {
      return null;
    }
    else {
      return tail.element;
    }
  }

  /** Add an element to the beginning of the list */
  public void addFirst(E e) {
    Node<E> newNode = new Node<>(e); // Create a new node
    newNode.next = head; // link the new node with the head
    if(head != null)
      head.prev = newNode; //connect head to the new node
    head = newNode; // head points to the new node
    size++; // Increase list size

    if (tail == null) // the new node is the only node in list
      tail = head;
  }

  /** Add an element to the end of the list */
  public void addLast(E e) {
    Node<E> newNode = new Node<>(e); // Create a new for element e

    if (tail == null) {
      head = tail = newNode; // The new node is the only node in list
    }
    else {
      tail.next = newNode; // Link the new with the last node
      newNode.prev = tail; // link the last node with the new
      tail = newNode; // tail now points to the last node
    }

    size++; // Increase size
  }

  @Override /** Add a new element at the specified index
   * in this list. The index of the head element is 0 */
  public void add(int index, E e) {
    if (index == 0) {
      addFirst(e);
    }
    else if (index >= size) {
      addLast(e);
    }
    else {
      Node<E> current;
      if(size / (index + 1) >= 2){
        current = head; //create a node for element e starting at the head
        for (int i = 1; i < index; i++) {
          current = current.next;
        }
      }
      else{
        current = tail; //create a node for element e starting at the tail
        for (int i = size - 1; i > index; i--) {
          current = current.prev;
        }
      }
      Node<E> temp = current.prev;
      current.prev = new Node<>(e); //link the current node to the new
      current.prev.next = current; //link the new to the current node
      (current.prev).prev = temp; //link the new to the previous node
      temp.next = current.prev; //link the previous node to the new
      size++;
    }
  }

  /** Remove the head node and
   *  return the object that is contained in the removed node. */
  public E removeFirst() {
    if (size == 0) {
      return null;
    }
    else {
      E temp = head.element;
      head = head.next;
      head.prev = null;
      size--;
      if (head == null) {
        tail = null;
      }
      return temp;
    }
  }

  /** Remove the last node and
   * return the object that is contained in the removed node. */
  public E removeLast() {
    if (size == 0) {
      return null;
    }
    else{
      E temp = tail.element;
      tail = tail.prev;
      tail.next = null;
      size--;
      if(tail == null)
        head = null;
      return temp;
    }
  }

  @Override /** Remove the element at the specified position in this
   *  list. Return the element that was removed from the list. */
  public E remove(int index) {
    if (index < 0 || index >= size) {
      return null;
    }
    else if (index == 0) {
      return removeFirst();
    }
    else if (index == size - 1) {
      return removeLast();
    }
    else {
      Node<E> current;
      if( size / (index + 1) >= 2){
        current = head; //start at head
        for (int i = 1; i < index; i++) { //and count up to index
          current = current.next;
        }
      }
      else{
        current = tail;
        for(int i = size - 1; i > index; i--){
          current = current.prev;
        }
      }
      current.prev.next = current.next;
      current.next.prev = current.prev;
      size--;
      return current.element;
    }
  }

  @Override /** Override toString() to return elements in the list */
  public String toString() {
    StringBuilder result = new StringBuilder("[");

    Node<E> current = head;
    for (int i = 0; i < size; i++) {
      result.append(current.element);
      current = current.next;
      if (current != null) {
        result.append(", "); // Separate two elements with a comma
      }
      else {
        result.append("]"); // Insert the closing ] in the string
      }
    }

    return result.toString();
  }

  @Override /** Clear the list */
  public void clear() {
    size = 0;
    head = tail = null;
  }

  @Override /** Return true if this list contains the element e */
  public boolean contains(Object e) {
    Node<E> current = head;
    for(int i = 0; i < size; i++){
      if(current.element.equals(e))
        return true;
      current = current.next;
    }
    return false;
  }

  @Override /** Return the element at the specified index */
  public E get(int index) {
    if(index < 0 || index >= size)
      return null;
    if(index == size - 1)
      return tail.element;
    if(index == 0)
      return head.element;

    Node<E> current = head.next;
    for(int i = 1; i < index; i++){
      current = current.next;
    }
    return current.element;
  }

  @Override /** Return the index of the head matching element in
   *  this list. Return -1 if no match. */
  public int indexOf(Object e) {
    if(size == 0)
      return -1;

    Node<E> current = head;
    int index = 0;
    while(current != null){
      if(current.element.equals(e))
        return index;
      index++;
      current = current.next;
    }
    return -1;
  }

  @Override /** Return the index of the last matching element in
   *  this list. Return -1 if no match. */
  public int lastIndexOf(E e) {
    if(size == 0)
      return -1;
    if(tail.element.equals(e))
      return size - 1;

    int lastIndex = -1;
    Node<E> current = head;
    for(int i = 0; i < size; i++){
      if(current.element.equals(e))
        lastIndex = i;
      current = current.next;
    }
    return lastIndex;
  }

  @Override /** Replace the element at the specified position
   *  in this list with the specified element. */
  public E set(int index, E e) {
    //if position less than 0, don't set
    if(index < 0 || index >= size)
      return null;
    //if index is greater that the last index add to end of list
    if(index == size - 1){
      tail.element = e;
    }
    else{
      Node<E> current = head;
      for(int i = 0; i < index; i++)
        current = current.next;
      current.element = e;
    }
    return null;
  }

  //reverses the order of the elements
  public void reverse(){
    Node<E> first = head; //Node counting up
    Node<E> last = tail; //Node counting down
    for(int i = 0, j = size - 1; i < j; i++, j--){
      E temp = first.element;
      first.element = last.element;
      last.element = temp;
      first = first.next;
      last = last.prev;
    }
  }

  @Override /** Override iterator() defined in Iterable */
  public java.util.Iterator<E> iterator() {
    return new LinkedListIterator();
  }

  private class LinkedListIterator
      implements java.util.Iterator<E> {
    private Node<E> current = head; // Current index
    private boolean removed = true; // Has a link been removed

    @Override
    public boolean hasNext() {
      return (current != null);
    }

    @Override
    public E next() {
      E e = current.element;
      current = current.next;
      removed = false;
      return e;
    }

    @Override
    public void remove() throws IllegalStateException {
      if(removed == true)
        throw new IllegalStateException(); //throw exception if next hasn't been called

      Node<E> prev = head;
      int index = 0;
      while(prev.next != current && index < size){
        prev = prev.next;
        index++;
      }
      removed = true;
      MyDoublyLinkedList.this.remove(index);
    }
  }

  private static class Node<E> {
    E element;
    Node<E> prev, next;

    public Node(E element) {
      this.element = element;
    }
  }

  @Override /** Return the number of elements in this list */
  public int size() {
    return size;
  }
}
