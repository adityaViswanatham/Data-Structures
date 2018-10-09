/**@author: Aditya Viswanatham.
 * 
 */

package arv160730;

import java.util.*;

// Binary Search Tree Class. 
public class MyBinarySearchTree<T extends Comparable<T>> {
	
	// Entry Class for the Binary Search Tree.
	static class Entry<T extends Comparable<T>> { 
		
		// Entry Class Attributes.
		T element;
		Entry<T> left;
		Entry<T> right;
		
		// Class Constructor.
		public Entry(T element) {
			this.element = element;
		}
	}
	
	Entry<T> root;
	int size = 0;
	Stack<Entry<T>> the_stack = new Stack<>();
	
	/**Find Method.
	 * 
	 * @param x
	 * @return Entry<T>
	 */
	public Entry<T> find(T x) {
		the_stack.push(null);
		Entry<T> return_value = find(root, x);
		return return_value;
	}
	// Find Helper.
	public Entry<T> find(Entry<T> node, T x) {
		if(node == null || node.element == x)
			return node;
		while(node != null) {
			if(x.compareTo(node.element) < 0) {
				if(node.left == null)
					break;
				else {
					the_stack.push(node);
					node = node.left;
				}
			}
			else if(x.compareTo(node.element) == 0)
				break;
			else {
				if(node.right == null)
					break;
				else {
					the_stack.push(node);
					node = node.right;
				}
			}
		}
		return node;
	}
	
	/** Contains Method
	 * 
	 * @param x
	 * @return boolean
	 */
	public boolean contains(T x) {
		Entry<T> find_return = find(x);
		if(find_return == null || find_return.element != x)
			return false;
		else
			return true;
	}
	
	/** Add Method
	 * 
	 * @param x
	 * @return boolean
	 */
	public boolean add(T x) {
		if(root == null) {
			root = new Entry<T>(x);
			System.out.println("Added to the root.");
			size++;
			return true;
		}
		Entry<T> the_node = find(x);
		if(the_node.element == x) {
			System.out.println("Found a duplicate.");
			return false;
		}
		else {
			if(x.compareTo(the_node.element) < 0) {
				the_node.left = new Entry<T>(x);
				System.out.println("Added to the left of " + the_node.element);
				size++;
				return true;
			}
			else {
				the_node.right = new Entry<T>(x);
				System.out.println("Added to the right of " + the_node.element);
				size++;
				return true;
			}
		}
	}
	
	/** Remove Method
	 * 
	 * @param x
	 * @return Entry<T>
	 */
	public T remove(T x) {
		Entry<T> ret_node = find(x);
		if(root == null || ret_node.element != x)
			return null;
		T result = ret_node.element;
		if(ret_node.left == null || ret_node.right == null)
			byPass(ret_node);
		else {
			// To use as a parent for byPass method.
			the_stack.push(ret_node);
			Entry<T> min_right = find(ret_node.right, x);
			ret_node.element = min_right.element;
			byPass(min_right);
		}
		size--;
		return result;
	}
	// Bypass Method is a helper to the Remove Method.
	/** Bypass Method
	 * 
	 * @param Entry<T>
	 */
	public void byPass(Entry<T> node) {
		Entry<T> parent = the_stack.peek();
		Entry<T> child;
		if(node.left == null)
			child = node.right;
		else
			child = node.left;
		if(parent.left == node)
			parent.left = child;
		else
			parent.right = child;
	}
	
	/** Max Method.
	 * 
	 * @return T
	 */
	public T max() {
		T max_val = max(root);
		if(max_val == null)
			return null;
		else
			return max_val;
	}
	// Max Method Helper Function.
	public T max(Entry<T> node) {
		Entry<T> curr = node;
		while(curr.right != null)
			curr = curr.right;
		return curr.element;
	}
	
	/** Min Method.
	 * 
	 * @return T
	 */
	public T min() {
		T min_val = min(root);
		if(min_val == null)
			return null;
		else
			return min_val;
	}
	// Min Method Helper Function.
	public T min(Entry<T> node) {
		Entry<T> curr = node;
		while(curr.left != null)
			curr = curr.left;
		return curr.element;
	}
	
	// Main Method.
	public static void main(String [] args) {
		MyBinarySearchTree<Integer> my_tree = new MyBinarySearchTree<>();
		my_tree.add(5);
		my_tree.add(10);
		my_tree.add(2);
		my_tree.add(2);
		my_tree.add(8);
		my_tree.add(8);
		my_tree.add(5);
		my_tree.remove(2);
		System.out.println(my_tree.size);
		System.out.println(my_tree.max());
		System.out.println(my_tree.min());
	}
	

}
