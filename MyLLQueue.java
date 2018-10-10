/** @author Aditya Viswanatham
 */

package arv160730;

import java.util.*;

// Queue Class.
public class MyLLQueue<T> {
	
	// Node Class for Queue.
	public class QNode<T> {
		T element;
		QNode<T> next;
		
		// Class Constructor.
		QNode(T element) {
			this.element = element;
			this.next = null;
		}
	}
	
	// Class Attributes.
	QNode<T> front;
	QNode<T> rear;
	
	// Class Constructors.
	public MyLLQueue() {
		front = rear = null;
	}
	
	// Add to the rear of the queue.
	public void enqueue(T item) {
		QNode<T> new_Node = new QNode<T>(item);
		if(rear == null) {
			front = rear = new_Node;
			System.out.println("Head is: " + item);
			return;
		}
		else {
			rear.next = new_Node;
			rear = new_Node;
		}
		System.out.println("Added: " + item);
	}
	
	// Delete at the front of the queue.
	public QNode<T> dequeue() {
		if(front == null)
			return null;
		
		QNode<T> temp = front;
		front = front.next;
		
		if(front == null)
			rear = null;
		System.out.println("Removed: " + temp.element);
		return temp;
	}
	
	// Main Method.
	public static void main(String [] args) {
		MyLLQueue<Integer> my_Q = new MyLLQueue<>();
		// Testing Queue Class functions.
		my_Q.enqueue(1);
		my_Q.enqueue(2);
		my_Q.dequeue();
	}
}
