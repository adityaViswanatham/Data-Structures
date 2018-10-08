// Author: Aditya Viswanatham.

// Doubly Linked List Class.
class MyDoublyLinkedList<T> {

  // Node Class for the Doubly Linked List.
  static class Node<T> {
    T data;
    Node<T> next;
    Node<T> prev;

    //Constructor for the Node Class.
    Node(T data) {
      this.data = data;
    }
  }

  // Class Attributes.
  Node<T> head;
  int size = 0;

  // Constructors.
  MyDoublyLinkedList() {
    head = null;
  }

  // Class Methods.
  // Add Methods.
  // Add Node at the Head.
  public void addatHead(T data) {
    Node<T> new_Node = new Node<T>(data);
    new_Node.prev = null;
    new_Node.next = head;
    if(head != null) {
      head.prev = new_Node;
    }
      head = new_Node;
  }

  // Add Node at the Tail.
  public void append(T data) {
    Node<T> new_Node = new Node<T>(data);
    Node<T> last = head;
    new_Node.next = null;
    if(head == null) {
      new_Node.prev = null;
      head = new_Node;
      return;
    }
    while(last.next != null) {
      last = last.next;
    }
    last.next = new_Node;
    new_Node.prev = last;
  }

  // Add Node after a Given Node.
  public void addAfter(Node<T> node, T data) {
    Node<T> new_Node = new Node<T>(data);
    new_Node.prev = node;
    node.next = new_Node;
    new_Node.next = node.next;
    if(new_Node.next != null)
      new_Node.next.prev = new_Node;
  }

  // Delete Methods.
  // Delete at Head.
  public void deleteatHead() {
    if(head == null) {
      System.out.println("The list is empty.");
      return;
    }
    Node<T> temp = head;
    head = temp.next;
    head.prev = null;
    temp.next = null;
  }

  // Delete at Tail.
  public void deleteatTail() {
    if(head == null) {
      System.out.println("The list is empty.");
      return;
    }
    Node<T> temp = head;
    while(temp.next != null)
      temp = temp.next;
    Node<T> prev_Node = temp.prev;
    prev_Node.next = null;
    temp.prev = null;
  }

  // Print Method.
  public void printList() {
    Node<T> temp = head;
    // Right order.
    System.out.println("Printing the list in right order.");
    while(temp.next != null) {
      System.out.println(temp.data);
      temp = temp.next;
      if(temp.next == null)
        System.out.println(temp.data);
    }
    // Reverse Order.
    System.out.println("Printing the list in reverse order.");
    while(temp != null) {
      System.out.println(temp.data);
      temp = temp.prev;
    }
  }

  // Main Function to test the class methods.
  public static void main(String [] args) {
    MyDoublyLinkedList<Integer> my_list = new MyDoublyLinkedList<>();
    // Testing the add methods.
    my_list.addatHead(1);
    my_list.append(2);
    my_list.append(3);
    // Testing the delete methods.
    my_list.deleteatHead();
    my_list.deleteatHead();
    my_list.addatHead(2);
    my_list.addatHead(1);
    my_list.deleteatTail();
    my_list.printList();
  }
}
