// Author: Aditya Viswanatham.

// Circular LinkedList Class.
public class MyCircularLinkedList<T> {

  // Node Class for the linkedlist.
  static class Node<T> {
    T data;
    Node<T> next;

    // Constructor for the Node Class.
    Node(T data) {
      this.data = data;
    }
  }

  // Class Attributes.
  Node<T> head;
  Node<T> tail;
  int size = 0;

  // Constructors.
  MyCircularLinkedList() {
    head = null;
    tail = null;
  }

  // Class Methods.
  // Add Method.
  // Add Node at Head Method.
  public void addatHead(T data) {
    Node<T> new_Node = new Node<T>(data);
    if(size == 0) {
      head = new_Node;
      tail = new_Node;
      new_Node.next = head;
    }
    else {
      Node<T> temp = head;
      new_Node.next = temp;
      head = new_Node;
      tail.next = head;
    }
    size++;
  }

  // Add Node at Tail Method.
  public void addattail(T data) {
    if(size == 0)
      addatHead(data);
    else {
      Node<T> new_Node = new Node<T>(data);
      tail.next = new_Node;
      tail = new_Node;
      tail.next = head;
      size++;
    }
  }

  // Delete Methods.
  // Delete Node at Head Method.
  public void deleteatHead() {
    if(size == 0)
      System.out.println("List is empty.");
    else {
      head = head.next;
      tail.next = head;
      size--;
    }
  }

  // Delete Node at Tail Method.
  public void deleteatTail() {
    Node<T> prev = head;
    while(prev.next != tail) {
      prev = prev.next;
    }
    prev.next = head;
    tail.next = null;
    size--;
  }

  // Print Method.
  public void printList() {
    System.out.println("Size: " + size);
    Node<T> temp = head;
    System.out.println("Head in Print function: " + temp.data);
    if(size == 0)
      System.out.println("List is empty.");
    else {
      // Using a do-while loop to print the list.
      do {
        System.out.println("Node data: " + temp.data);
        temp = temp.next;
      }
      while(temp != head);
    }
  }

  // Size Method.
  public int getSize() {
    return size;
  }

  // Main Method to test the MyCircularLinkedList Functions.
  public static void main(String [] args) {
    MyCircularLinkedList<Integer> my_list = new MyCircularLinkedList<>();
    // Testing add Methods.
    my_list.addattail(1);
    my_list.addattail(2);
    my_list.addattail(3);
    my_list.addattail(4);
    // Testing Print Function.
    my_list.printList();
    System.out.println("///////////////");
    // Testing Delete Functions.
    my_list.deleteatTail();
    my_list.printList();
    System.out.println("///////////////");
    my_list.deleteatHead();
    my_list.printList();
  }
}
