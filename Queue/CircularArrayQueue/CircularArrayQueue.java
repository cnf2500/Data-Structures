/*
 * Author: Christopher Forte
 * Date: January 20, 2022
 * Title: CircularArrayQueue
 * Description: Personal take on the Circular Array Queue data structure.
 */

public class CircularArrayQueue<E> {

    /*
     * @param q_array - generic array used for storage.
     * @param front - front index in the array.
     * @param back - back index in the array.
     * @param size - current number of values in the array.
     */

    E[] q_array;
    int front = 0;
    int back = 0;
    int size = 0;

    //Constructs a queue with a given size.
    public CircularArrayQueue(int q_size) {
        q_array = (E[]) new Object[q_size];
    }

    //Returns the number of values in the queue.
    public int size() {
        return size;
    }

    //Returns "True" if the queue contains no values.
    public boolean isEmpty() {
        return size == 0;
    }

    //Returns the first value of the queue.
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return q_array[0];
    }

    //Inserts a value (e) at the back of the queue.
    public void enqueue(E e) throws IllegalStateException {
        if (size == q_array.length) {
            throw new IllegalStateException();
        }
        //Assign a value (e) to the back of the queue.
        q_array[back] = e;

        //Sets the proper location for the value (e) in the queue.
        back = (back + 1) % q_array.length;

        //Inserts the specified value (e) to the back of the queue.
        size++;
    }

    //Removes and returns the first value of the queue.
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        //Initialize return variable with the value stored at the front of the queue.
        E cap = q_array[front];

        //The first value of the queue is stored in the return variable.
        front = (front + 1) % q_array.length;

        //Removes the first value of the queue.
        size--;

        return cap;
    }

    //Designated main method.
    public static void main(String[] args) {
        System.out.println("This is my CircularArrayQueue Program! Feel free to " +
                "check out my test cases!");
    }
}
