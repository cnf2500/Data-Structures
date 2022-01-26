/*
 * Author: Christopher Forte
 * Date: January 9, 2022
 * Title: ArrayList Test Cases
 * Description: Tests created to assess my ArrayList.
 */

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

class ArrayListTest {

    private ArrayList olympus = new ArrayList();

    //Tests the number of values in the array.
    @Test
    void size() {
        olympus.add(0,"Apollo");
        olympus.add(1,"Hera");
        olympus.add(2,"Athena");

        assertEquals(3, olympus.size());
    }

    //Tests if the array contains no values.
    @Test
    void isEmpty() {
        olympus.add(0,"Zeus");
        olympus.remove(0);

        assertTrue(olympus.isEmpty());
    }

    //Tests the array's present capacity.
    @Test
    void capacity() {
        olympus.add(0,"Athena");
        olympus.add(1,"Hera");
        olympus.add(2,"Hestia");

        assertEquals(20, olympus.capacity());
    }

    /*
     * Tests whether the 'get' value is the same value that is currently stored at the specified
     * index (i) in the array.
     */
    @Test
    void get() {
        olympus.add(0,"Zeus");
        olympus.add(1,"Hades");
        olympus.add(2,"Poseidon");

        assertEquals("Zeus", olympus.get(0));
    }

    /*
     * Tests if the former value at the specified index (i) in the array is properly replaced by the
     * new specified value (e).
     */
    @Test
    void set() {
        olympus.add(0,"Zeus");
        olympus.add(1,"Hades");
        olympus.add(2,"Poseidon");

        assertEquals("Poseidon", olympus.set(2, "Hera"));
    }

    //Tests if the specified value (e) is properly inserted at the specified index (i) in the array.
    @Test
    void add() {
        olympus.add(0, "Zeus");
        olympus.add(1, "Hades");
        olympus.add(2, "Poseidon");

        assertEquals("Zeus", olympus.get(0));
        assertEquals("Hades", olympus.get(1));
        assertEquals("Poseidon", olympus.get(2));

        olympus.add(1,"Hermes");
        olympus.add(2,"Athena");

        assertEquals("Zeus", olympus.get(0));
        assertEquals("Hermes", olympus.get(1));
        assertEquals("Athena", olympus.get(2));
        assertEquals("Hades", olympus.get(3));
        assertEquals("Poseidon", olympus.get(4));
    }

    //Tests if the value at the specified index (i) is properly removed.
    @Test
    void remove() {
        olympus.add(0, "Zeus");
        olympus.add(1, "Hades");
        olympus.add(2, "Poseidon");

        assertEquals("Hades", olympus.remove(1));
    }

    //Tests if the specified value (e) is added to the first index in the array.
    @Test
    void addFirst() {
        olympus.add(0, "Hades");
        olympus.add(1, "Artemis");
        olympus.add(2, "Hermes");

        olympus.addFirst("Apollo");

        assertEquals("Apollo", olympus.get(0));
    }

    //Tests if the specified value (e) is added to the last index in the array.
    @Test
    void addLast() {
        olympus.add(0, "Athena");
        olympus.add(1, "Hestia");
        olympus.add(2, "Poseidon");

        olympus.addLast("Artemis");

        assertEquals("Artemis", olympus.get(3));
    }

    //Tests if the specified value (e) is removed from the first index in the array.
    @Test
    void removeFirst() {
        olympus.add(0, "Zeus");
        olympus.add(1, "Hades");
        olympus.add(2, "Poseidon");

        assertEquals("Zeus", olympus.removeFirst());
    }

    //Tests if the specified value (e) is removed from the last index in the array.
    @Test
    void removeLast() {
        olympus.add(0, "Apollo");
        olympus.add(1, "Artemis");
        olympus.add(2, "Ares");

        assertEquals("Ares", olympus.removeLast());
    }
}
