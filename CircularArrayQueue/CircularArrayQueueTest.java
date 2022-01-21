/*
 * Author: Christopher Forte
 * Date: January 20, 2022
 * Title: CircularArrayQueue Test Cases
 * Description: Tests created to assess my Circular Array Queue.
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class CircularArrayQueueTest {

    private CircularArrayQueue deck = new CircularArrayQueue(13);

    //Tests the number of values in the queue.
    @org.junit.jupiter.api.Test
    void size() {
        deck.enqueue("Ace");
        deck.enqueue("King");
        deck.enqueue("Queen");
        deck.enqueue("Jack");

        assertEquals(4, deck.size());
    }

    //Tests if the array contains no values.
    @org.junit.jupiter.api.Test
    void isEmpty() {
        deck.enqueue("Eight");
        deck.dequeue();

        assertTrue(deck.isEmpty());
    }

    /*
     * First test to determine if the specified value is in the first
     * index of the queue.
     */
    @org.junit.jupiter.api.Test
    void first1() {
        deck.enqueue("Three");
        deck.enqueue("Jack");

        assertEquals("Three", deck.first());
    }

    /*
     * Second test to determine if the specified value is in the first
     * index of the queue.
     */
    @org.junit.jupiter.api.Test
    void first2() {
        deck.enqueue("Four");
        deck.enqueue("Five");
        deck.enqueue("Ace");
        deck.enqueue("Two");

        deck.dequeue();
        deck.dequeue();
        deck.dequeue();

        assertEquals("Four", deck.first());
    }

    //Tests if the specified values (e) have been inserted into the queue.
    @org.junit.jupiter.api.Test
    void enqueue() {
        deck.enqueue("Queen");
        deck.enqueue("Nine");
        deck.enqueue("Three");

        assertEquals(3, deck.size());
    }

    //Tests if the first value of the queue is removed.
    @org.junit.jupiter.api.Test
    void dequeue() {
        deck.enqueue("King");
        deck.enqueue("One");
        deck.enqueue("Nine");

        assertEquals("King", deck.dequeue());
    }
}