/*
 * Author: Christopher Forte
 * Date: January 9, 2022
 * Title: ArrayList
 * Description: Personal take on the ArrayList data structure.
 */

import java.util.Iterator;

public class ArrayList<E> {

    /*
     * @param array - generic array used for storage.
     * @param size - current number of values in the array.
     */

    public static final int capacity = 20;
    E[] array;
    int size = 0;

    //Excludes default methods forEachRemaining(Consumer<? super E> action) or remove() methods.
    private class ArrayListIterator implements Iterator<E> {
        int click = 0;

        //Returns "True" if the iteration has more values.
        @Override
        public boolean hasNext() {
            return click < size;
        }

        //Returns the next value in the iteration.
        @Override
        public E next() {
            E mse = array[click];
            click++;
            return mse;
        }
    }

    //Throws "Index Out of Bounds" if sought index is out of value bounds.
    private void index_check1(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i > size - 1) {
            throw new IndexOutOfBoundsException("Index Out of Bounds" + i);
        }
    }

    //Throws "Index Out of Bounds" if sought index is out of key bounds.
    private void index_check2(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException("Index Out of Bounds" + i);
        }
    }

    //ArrayList capacity set at a default of 20.
    public ArrayList() {
        this(capacity);
    }

    //Creates an array with the given default capacity.
    public ArrayList(int cap) {
        array = (E[]) new Object[capacity];
    }

    //Returns the number of values in the array.
    public int size() {
        return size;
    }

    //Returns the array's present capacity.
    public int capacity() {
        return array.length;
    }

    //Returns "True" if the array contains no values.
    public boolean isEmpty() {
        return size == 0;
    }

    //Returns the value at the specified index (i) in the array.
    public E get(int i) throws IndexOutOfBoundsException {
        index_check1(i);
        return array[i];
    }

    /*
     * Replaces the value at the specified index (i) in the array with a specified value (e).
     * Returns former value at specified index(i).
     */
    public E set(int i, E e) throws IndexOutOfBoundsException {
        index_check1(i);
        E former = array[i];
        array[i] = e;
        return former;
    }

    /*
     * Inserts the value (e) at the specified index (i) in the array. Once the value (e) is added,
     * then any original value at the specified index (i) and any additional values in the array
     * are shifted to the right
     */
    public void add(int i, E e) throws IndexOutOfBoundsException {
        index_check2(i);

        //Double the size of the array if the number of values is at capacity.
        if (size == array.length) {
            E[] new_array = (E[]) new Object[array.length * 2];
            for (int j = 0; j < size; j++) {
                new_array[j] = array[j];
            }
            array = new_array;
        }

        //Shift values after index 'i' to the right.
        for (int j = size - 1; j >= i; j--) {
            array[j + 1] = array[j];
        }

        //Insert value (e) at the specified index (i), (increasing the array's size).
        array[i] = e;
        size++;
    }

    /*
     * Removes the value from the specified index (i) in the array. Once the value is removed,
     * any additional values in the array are shifted to the left. Returns the value that was
     * removed from the array.
     */
    public E remove(int i) throws IndexOutOfBoundsException {
        index_check1(i);

        //Remove value at the specified index (i).
        E former = array[i];

        //Shift values after index 'i' to the left.
        for (int j = i + 1; j < size; j++) {
            array[j - 1] = array[j];
        }

        //Decrease the array's size.
        size--;

        return former;
    }

    //Add a specified value (e) to the first index in the array.
    public void addFirst(E e) {
        add(0,e);
    }

    //Add a specified value (e) to the last index in the array.
    public void addLast(E e) {
        add(size,e);
    }

    //Remove the specified value (e) at the first index in the array.
    public E removeFirst() throws IndexOutOfBoundsException {
        return remove(0);
    }

    //Remove the specified value (e) at the last index in the array.
    public E removeLast() throws IndexOutOfBoundsException {
        return remove(size - 1);
    }

    //Installs iterator for array.
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    //Designated main method.
    public static void main(String[] args) {
        System.out.println("This is my ArrayList Program! Feel free to " +
                "check out my test cases!");
    }
}
