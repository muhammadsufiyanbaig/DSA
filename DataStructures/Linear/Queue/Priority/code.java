package DataStructures.Linear.Queue.Priority;

public class code {
    // Priority Queue implementation using binary heap
    public static class PriorityQueue {
        // A class representing an element with a priority
        private static class Node {
            int data;
            int priority;
            
            public Node(int data, int priority) {
                this.data = data;
                this.priority = priority;
            }
        }

        private Node[] heap;
        private int size;
        private int capacity;

        public PriorityQueue(int capacity) {
            this.capacity = capacity;
            this.heap = new Node[capacity];
            this.size = 0;
        }
        
        public PriorityQueue() {
            this(10); // Default capacity of 10
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }

        private int parent(int i) {
            return (i - 1) / 2;
        }

        private int leftChild(int i) {
            return 2 * i + 1;
        }

        private int rightChild(int i) {
            return 2 * i + 2;
        }

        private void siftUp(int i) {
            int parent = parent(i);
            if (i > 0 && heap[i].priority > heap[parent].priority) {
                Node temp = heap[i];
                heap[i] = heap[parent];
                heap[parent] = temp;
                siftUp(parent);
            }
        }

        private void siftDown(int i) {
            int maxIndex = i;
            int left = leftChild(i);
            
            if (left < size && heap[left].priority > heap[maxIndex].priority) {
                maxIndex = left;
            }
            
            int right = rightChild(i);
            if (right < size && heap[right].priority > heap[maxIndex].priority) {
                maxIndex = right;
            }
            
            if (i != maxIndex) {
                Node temp = heap[i];
                heap[i] = heap[maxIndex];
                heap[maxIndex] = temp;
                siftDown(maxIndex);
            }
        }

        public void enqueue(int data, int priority) {
            if (isFull()) {
                System.out.println("Priority queue is full");
                return;
            }
            
            Node node = new Node(data, priority);
            heap[size] = node;
            siftUp(size);
            size++;
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Priority queue is empty");
                return -1;
            }
            
            int result = heap[0].data;
            heap[0] = heap[size - 1];
            size--;
            
            if (size > 0) {
                siftDown(0);
            }
            return result;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Priority queue is empty");
                return -1;
            }
            return heap[0].data;
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Priority queue is empty");
                return;
            }
            
            System.out.println("Priority Queue contents:");
            for (int i = 0; i < size; i++) {
                System.out.println("Data: " + heap[i].data + ", Priority: " + heap[i].priority);
            }
        }
        
        public int getSize() {
            return size;
        }
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(5);
        
        pq.enqueue(10, 2);
        pq.enqueue(20, 1);
        pq.enqueue(30, 3);
        pq.enqueue(40, 5);
        pq.enqueue(50, 4);
        
        pq.display();
        
        System.out.println("\nDequeuing elements:");
        while (!pq.isEmpty()) {
            int data = pq.dequeue();
            System.out.println("Dequeued: " + data);
        }
    }
}
