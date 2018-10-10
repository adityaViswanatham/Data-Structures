/** @author Aditya Viswanatham
 */

package arv160730;

import java.util.*;

// Queue Class.
public class MyArrayQueue<T> {
	
	// Class Attributes.
	int front, rear;
	int size;
	int capacity;
	Object arr[];
	
	// Class Constructor.
	public MyArrayQueue(int capacity) {
		this.capacity = capacity;
		arr = new Object[this.capacity];
		front = rear = size = 0;
	}
	
	// isFull returns true if the queue is full.
	public boolean isFull() {
		return(this.size == this.capacity);
	}
	
	// isEmpty return true if queue is empty.
	public boolean isEmpty() {
		return(this.size == 0);
	}
	
	// reSize doubles the size of the queue.
	public void reSize() {
        int newSize = arr.length * 2;
        arr = Arrays.copyOf(arr, newSize);
      }
	
	// pushes an element into the rear of the queue.
	public void enqueue(T item) {
		if(rear == capacity)
			reSize();
		arr[rear] = item;
		System.out.println("Added: " + item);
		rear++;
		size++;
	}
	
	// removes an element from the front of the queue.
	public void dequeue() {
		Object ret_val = todequeue();
		if(ret_val == null)
			System.out.println("The queue is empty");
		else
			System.out.println("Removed: " + ret_val);
	}
	// Helper method for dequeue.
	public Object todequeue() {
		if(rear == 0)
			return null;
		else {
			Object to_return = arr[front];
			front++;
			size--;
			return to_return;
		}
	}
	
	// Main method.
	public static void main(String [] args) {
		MyArrayQueue<Integer> my_Q = new MyArrayQueue<>(10);
		// Testing Enqueue.
		my_Q.enqueue(1);
		my_Q.enqueue(2);
		my_Q.enqueue(3);
		my_Q.enqueue(4);
		my_Q.enqueue(5);
		my_Q.enqueue(6);
		my_Q.enqueue(7);
		my_Q.enqueue(8);
		my_Q.enqueue(9);
		my_Q.enqueue(10);
		my_Q.enqueue(11);
		System.out.println("Before dequeue: " + my_Q.front);
		// Testing Dequeue.
		my_Q.dequeue();
		System.out.println("After dequeue: " + my_Q.front);
		System.out.println("Back is: " + my_Q.rear);
	}
}
