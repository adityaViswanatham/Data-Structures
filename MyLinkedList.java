// Author: Aditya Viswanatham

// LinkedList Class.
class MyLinkedList<T> {

  // Node Class for the LinkedList.
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
   int size = 0;

   // Constructors.
   public MyLinkedList() {}

   // Constructor to create a linkedlist with an initial value to the head.
   public MyLinkedList(T data) {
     head = new Node<T>(data);
   }

   // Class Methods.

   // Add Methods.
   // Add at tail.
   public void addtoTail(T data) {
     Node<T> temp = head;
     while(temp.next != null) {
       temp = temp.next;
     }
     temp.next = new Node<T>(data);
     size++;
   }

   // Add to head.
   public void addtoHead(T data) {
     Node<T> temp = head;
     head = new Node<T>(data);
     head.next = temp;
     size++;
   }

   // Add at Index.
   public void addatIndex(int index, T data) {
     Node<T> temp = head;
     Node<T> after;
     for(int i = 0; i < index - 1 && temp.next != null; i++) {
       temp = temp.next;
     }
     after = temp.next;
     temp.next = new Node<T>(data);
     temp.next.next = after;
     size++;
   }

   // Delete Methods.
   // Delete at Index.
   public void deleteatIndex(int index) {
     Node<T> temp = head;
     for(int i = 0; i < index - 1 && temp.next != null; i++) {
       temp = temp.next;
     }
     if(temp == null || temp.next == null)
      return;
      temp.next = temp.next.next;
      size--;
   }

   // Delete at the head.
   public void deleteatHead() {
     Node<T> temp = head;
     head = temp.next;
     temp.next = null;
     size--;
   }

   // Delete at the tail.
   public void deleteatTail() {
     Node<T> prev = head;
     Node<T> temp = prev.next;
     while(temp.next != null) {
       prev = prev.next;
       temp = temp.next;
     }
     prev.next = null;
     size--;
   }

   // Print Method.
   public void printList() {
     Node<T> temp = head;
     while(temp != null) {
       System.out.println(temp.data);
       temp = temp.next;
     }
   }

   // Size Method.
   public int getSize() {
     return size;
   }

   // Main function.
   public static void main(String [] args) {
     MyLinkedList<Integer> my_list = new MyLinkedList<>();
     // Testing Add Methods.
     my_list.addtoHead(1);
     my_list.addtoTail(2);
     my_list.addtoTail(4);
     my_list.addatIndex(2, 3);
     // Testing Print Method.
     my_list.printList();
     // Testing Delete methods.
     my_list.deleteatIndex(3);
     my_list.deleteatHead();
     my_list.deleteatTail();
     System.out.println("/////////////////");
     my_list.printList();
   }

}
