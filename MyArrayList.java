// Author: Aditya Viswanatham.

import java.util.Arrays;

class MyArrayList<E> {

      // Class Attributes.
      int size = 0;
      Object [] element_array;
      // Final Comes ahead of the data type.
      int CAPACITY = 10;

      // Constructors.
      // Constructs an ArrayList with default capacity.
      public MyArrayList() {
        element_array = new Object[CAPACITY];
      }

      // Constructs an empty ArrayList with the specified initial capacity.
      public MyArrayList(int init_cap) {
        CAPACITY = init_cap;
      }

      // Class Methods.
      // Add method that appends to the end of the ArrayList.
      public void add(E e) {
        if(size == element_array.length) {
          reSize();
        }
        element_array[size++] = e;
      }

      // Add method adds an element in a specific position in the ArrayList.
      public void add(int index, E e) {
        if(index < 0 || index >= size)
          throw new IndexOutOfBoundsException();
        else if(e == null)
          throw new NullPointerException();
        else {
          if(size == element_array.length) {
            reSize();
          }
          for(int i = size; i > index; i--) {
            element_array[i] = element_array[i-1];
          }
          element_array[index] = e;
          size++;
        }
      }

      // Remove method that removes the last element from the list.
      public void remove() {
        element_array[size--] = null;
      }

      // Remove method to remove a specific element from the list.
      public void remove(int index) {
        if(index < 0 || index > size)
          throw new IndexOutOfBoundsException();
        else {
          for(int i = index; i < size-1; i++) {
              element_array[i] = element_array[i+1];
          }
          size--;
        }
      }

      // Get method that returns the element based on the index provided.
      @SuppressWarnings("unchecked")
      public E get(int index) {
        if(index < 0 || index >= size)
          throw new IndexOutOfBoundsException();
        return (E) element_array[index];
      }

      // Resizes the length of the array.
      public void reSize() {
        int newSize = element_array.length * 2;
        element_array = Arrays.copyOf(element_array, newSize);
      }

      // Main Function for testing the above methods.
      public static void main(String [] args) {
        MyArrayList<Integer> my_list = new MyArrayList<>();
        // Add method test.
        my_list.add(1);
        my_list.add(2);
        my_list.add(3);
        my_list.add(4);
        my_list.add(5);
        for(int i = 0; i < my_list.size; i++) {
          System.out.println(my_list.get(i));
        }
        System.out.println();
        // Remove Method test.
        my_list.remove();
        my_list.remove();
        for(int i = 0; i < my_list.size; i++) {
          System.out.println(my_list.get(i));
        }
        System.out.println();
        // Get Method test.
        System.out.println(my_list.get(1));
        System.out.println(my_list.get(2));
        System.out.println();
        // Add method at specific position test.
        my_list.add(1, 6);
        for(int i = 0; i < my_list.size; i++) {
          System.out.println(my_list.get(i));
        }
        System.out.println();
        // Remove method test.
        my_list.remove(0);
        for(int i = 0; i < my_list.size; i++) {
          System.out.println(my_list.get(i));
        }

      }

}
