/*
 * Author: Christopher Forte
 * Date: January 28, 2022
 * Title: Doubly Linked List
 * Description: Personal take on the Doubly Linked List data structure.
 */

import Interfaces.Position;
import java.util.Iterator;

/*
 * This Doubly Linked List program utilizes a Position interface. The
 * interface enables values to be extracted from specified indexes.
 */

public class DoublyLinkedList<E> {

    //Declaration of instance variables.
    Node<E> front;
    Node<E> back;
    int size;

    //Nested Node class that implements the Position interface.
    public static class Node<E> implements Position<E> {

        /*
         * @param value - the value stored at a given node.
         * @param next - subsequent node in the list.
         * @param prior - previous node in the list.
         */

        Node<E> prior;
        Node<E> next;
        E value;

        //Constructs a given node in the doubly linked list.
        public Node(E v, Node<E> prior, Node<E> next) {
            this.prior = prior;
            this.next = next;
            value = v;
        }

        //Returns value stored at a given index in the doubly linked list.
        @Override
        public E getElement() throws IllegalStateException {
            return value;
        }
    }

    /*
     * Implements element iterator that is necessary to evaluate individual
     * values in doubly linked list.
     */
    private class Element_Iterator implements Iterator<E> {
        Node<E> k = front.next;

        //Returns "True" if the iteration has more values.
        @Override
        public boolean hasNext() {
            return k != back;
        }

        //Returns the next value in the iteration.
        @Override
        public E next() {
            E v = k.value;
            k = k.next;
            return v;
        }
    }

    /*
     * Implements position iterator that is necessary to evaluate individual
     * indexes in doubly linked list.
     */
    private class Position_Iterator implements Iterator<Position<E>> {
        Node<E> k = front.next;

        //Returns "True" if the iteration has more indexes.
        @Override
        public boolean hasNext() {
            return k != back;
        }

        //Returns the next index in the iteration.
        @Override
        public Position<E> next() {
            Position<E> current = k;
            k = k.next;
            return current;
        }
    }

    //Returns new position iterator to be used in doubly linked list.
    private class Position_Iterable implements Iterable<Position<E>> {

        @Override
        public Iterator<Position<E>> iterator() {
            return new Position_Iterator();
        }
    }

    //Validates a specified node's index (k) and returns the node.
    private Node<E> validate(Position<E> k) throws IllegalArgumentException {
        if (k instanceof Node) {
            return (Node<E>) k;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    //Constructs an empty list.
    public DoublyLinkedList() {
        front = new Node<E>(null, null, null);
        back = new Node<E>(null, null, null);
        front.next = back;
        size = 0;
    }

    //Returns the number of values in the list.
    public int size() {
        return size;
    }

    //Returns "True" if the list contains no values.
    public boolean isEmpty() {
        return size == 0;
    }

    /*
     * Replaces value stored at a particular index (k), returns
     * the previously stored value (v).
     */
    public E set(Position<E> k, E v) throws IllegalArgumentException {
        Node<E> node = validate(k);
        E prior = node.value;
        node.value = v;
        return prior;
    }

    //Removes value stored at a particular index (k), returns removed value.
    public E remove(Position<E> k) throws IllegalArgumentException {
        Node<E> node = validate(k);
        E former = node.value;

        Node<E>node1 = node.prior;
        Node<E>node2 = node.next;
        node1.next = node2;
        node2.prior = node1;

        size--;

        return former;
    }

    /*
     * Returns the index that precedes a specified index (k) in the doubly
     * linked list.
     */
    public Position<E> before(Position<E> k) throws IllegalArgumentException {
        Node<E> node = validate(k);
        if (node.prior == front) {
            return null;
        }
        return node.prior;
    }

    /*
     * Returns the index that follows a specified index (k) in the doubly
     * linked list.
     */
    public Position<E> after(Position<E> k) throws IllegalArgumentException {
        Node<E> node = validate(k);
        if (node.next == back) {
            return null;
        }
        return node.next;
    }

    /*
     * Adds a specified value (v) to the doubly linked list between two specified
     * indexes (k1, k2), creating a new node altogether. Returns the new node.
     */
    public Node<E> addBetween(Position<E> k1, Position<E> k2, E v) {
        Node<E>node1 = validate(k1);
        Node<E>node2 = validate(k2);

        Node<E> node = new Node<>(v, node1, node2);
        node1.next = node;
        node2.prior = node;

        size++;

        return node;
    }

    //Returns the first index of doubly linked list.
    public Position<E> first() {
        if (front.next == back) {
            return null;
        }
        return front.next;
    }

    //Returns the last index of doubly linked list.
    public Position<E> last() {
        if (back.prior == front) {
            return null;
        }
        return back.prior;
    }

    /*
     * Inserts a specified value (v) at the front, or first index, of the
     * doubly linked list.
     */
    public Position<E> addFirst(E v) {
        Node<E> n_first = addBetween(front, front.next, v);
        return n_first;
    }

    /*
     * Inserts a specified value (v) at the back, or last index, of the
     * doubly linked list.
     */
    public Position<E> addLast(E v) {
        Node<E> n_last = addBetween(back.prior, back, v);
        return n_last;
    }

    //Removes the value stored in the first index of the doubly linked list.
    public E removeFirst() throws IllegalArgumentException {
        E r_first = remove(first());
        return r_first;
    }

    //Removes the value stored in the last index of the doubly linked list.
    public E removeLast() throws IllegalArgumentException {
        E r_last = remove(last());
        return r_last;
    }

    public static void main(String[] args) {
        System.out.println("This is my DoublyLinkedList Program! Feel free to " +
                "check out my test cases!");
    }
}
