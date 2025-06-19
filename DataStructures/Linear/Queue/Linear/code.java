package DataStructures.Linear.Queue.Linear;

public class code {
    // Queue internal variables
    private int front, rear;
    private int capacity;
    private Object[] array;

    // Constructor
    public code(int capacity) {
        this.capacity = capacity;
        front = 0;
        rear = -1;
        array = new Object[this.capacity];
    }

    // Method to add an element to the queue
    public void enqueue(Object item) {
        if (isFull()) {
            System.out.println("Queue is full, cannot enqueue");
            return;
        }
        array[++rear] = item;
        System.out.println(item + " enqueued to queue");
    }

    // Method to remove an element from the queue
    public Object dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty, cannot dequeue");
            return null;
        }
        Object item = array[front++];
        return item;
    }

    // Method to get the front element without removing it
    public Object peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        return array[front];
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return (front > rear);
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return (rear == capacity - 1);
    }

    // Method to get the size of the queue
    public int size() {
        return rear - front + 1;
    }
}
