package DataStructures.Linear.Queue.Circular;

public class code {
    private int[] array;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public code(int capacity) {
        this.capacity = capacity;
        this.front = this.size = 0;
        this.rear = -1;
        this.array = new int[this.capacity];
    }

    // Check if the queue is full
    public boolean isFull() {
        return (this.size == this.capacity);
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return (this.size == 0);
    }

    // Add an item to the queue
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        this.rear = (this.rear + 1) % this.capacity;
        this.array[this.rear] = item;
        this.size++;
        System.out.println(item + " enqueued to queue");
    }

    // Remove an item from queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        int item = this.array[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size--;
        return item;
    }

    // Get the front of the queue
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return Integer.MIN_VALUE;
        }
        return this.array[this.front];
    }
    
    // Display the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        
        System.out.print("Elements: ");
        int count = 0;
        int i = front;
        
        while (count < size) {
            System.out.print(array[i] + " ");
            i = (i + 1) % capacity;
            count++;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        code queue = new code(5);
        
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        
        queue.display();
        
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
        
        queue.display();
        
        queue.enqueue(6);
        queue.enqueue(7);
        
        queue.display();
    }
}
