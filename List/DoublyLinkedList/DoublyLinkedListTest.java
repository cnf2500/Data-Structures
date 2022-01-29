/*
 * Author: Christopher Forte
 * Date: January 28, 2022
 * Title: Doubly Linked List
 * Description: Personal take on the Doubly Linked List data structure.
 */

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

class DoublyLinkedListTest {

    private DoublyLinkedList numbers = new DoublyLinkedList<Integer>();

    //Tests the number of values in the array.
    @Test
    void size() {
        numbers.addFirst(5);
        numbers.addLast(3);

        assertEquals(2, numbers.size());
    }

    //Tests if the array contains no values.
    @Test
    void isEmpty() {
        numbers.addFirst(14);
        numbers.addLast(33);

        numbers.removeFirst();
        numbers.removeLast();

        assertTrue(numbers.isEmpty());
    }

    /*
     * Tests if value stored at a particular index (k) is replaced by returning
     * the previously stored value (v), while also validating the new value at the
     * particular index.
     */
    @Test
    void set() {
        numbers.addFirst(44);
        numbers.addLast(25);

        assertEquals(25, numbers.set(numbers.last(), 11));
        assertEquals(11, numbers.last().getElement());
    }

    //Tests if the value at the specified index (k) is properly removed.
    @Test
    void remove() {
        numbers.addFirst(83);
        numbers.addLast(20);

        assertEquals(20, numbers.remove(numbers.last()));
    }

    /*
     * Tests if the index that precedes a specified index (k) in the doubly
     * linked list can be acquired.
     */
    @Test
    void before() {
        numbers.addFirst(34);
        numbers.addFirst(11);
        numbers.addLast(24);

        assertEquals(34, numbers.before(numbers.last()).getElement());
    }

    /*
     * Tests if the index that succeeds a specified index (k) in the doubly
     * linked list can be accessed.
     */
    @Test
    void after() {
        numbers.addFirst(10);
        numbers.addLast(87);

        numbers.addBetween(numbers.first(), numbers.last(), 14);

        assertEquals(14, numbers.after(numbers.first()).getElement());
    }

    /*
     * Tests if a specified value (v) has been added to the doubly linked list
     * between two specified indexes (k1, k2).
     */
    @Test
    void addBetween() {
        numbers.addFirst(56);
        numbers.addLast(91);

        numbers.addBetween(numbers.first(), numbers.last(), 63);

        assertEquals(63, numbers.before(numbers.last()).getElement());
    }

    /*
     * Tests if the first index of doubly linked list can be accessed.
     */
    @Test
    void first() {
        numbers.addFirst(55);
        numbers.addFirst(66);
        numbers.addFirst(77);
        numbers.addFirst(88);

        numbers.removeFirst();
        numbers.removeLast();

        assertEquals(77, numbers.first().getElement());
    }

    /*
     * Tests if the first index of doubly linked list can be accessed.
     */
    @Test
    void last() {
        numbers.addFirst(47);
        numbers.addFirst(62);
        numbers.addLast(39);
        numbers.addLast(84);

        assertEquals(84, numbers.last().getElement());
    }

    /*
     * Tests if a specified value (v) has been inserted at the front, or
     * first index, of the doubly linked list.
     */
    @Test
    void addFirst() {
        numbers.addFirst(68);
        numbers.addLast(81);
        numbers.addLast(95);
        numbers.addLast(74);

        assertEquals(68, numbers.first().getElement());
    }

    /*
     * Tests if a specified value (v) has been inserted at the back, or
     * last index, of the doubly linked list.
     */
    @Test
    void addLast() {
        numbers.addFirst(14);
        numbers.addFirst(18);
        numbers.addBetween(numbers.first(), numbers.after(numbers.first()), 21);
        numbers.addLast(91);

        assertEquals(91, numbers.last().getElement());
    }

    /*
     * Tests if a specified value (v) has been removed from the front, or
     * first index, of the doubly linked list.
     */
    @Test
    void removeFirst() {
        numbers.addFirst(45);
        numbers.addLast(42);
        numbers.addBetween(numbers.first(), numbers.last(), 51);

        assertEquals(45, numbers.removeFirst());
    }

    /*
     * Tests if a specified value (v) has been removed from the back, or
     * last index, of the doubly linked list.
     */
    @Test
    void removeLast() {
        numbers.addFirst(75);
        numbers.addLast(69);
        numbers.addLast(54);
        numbers.addBetween(numbers.first(), numbers.last(), 96);

        assertEquals(54, numbers.removeLast());
    }
}