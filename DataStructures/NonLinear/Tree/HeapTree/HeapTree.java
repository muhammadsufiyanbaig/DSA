package DataStructures.NonLinear.Tree.HeapTree;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Complete Binary Heap implementation supporting both Min Heap and Max Heap
 * Uses array-based representation for efficient storage and operations
 */
public class HeapTree {
    private int[] heap;
    private int size;
    private boolean isMinHeap;
    private static final int DEFAULT_CAPACITY = 16;

    // Constructors
    public HeapTree() {
        this(DEFAULT_CAPACITY, true);
    }

    public HeapTree(boolean isMinHeap) {
        this(DEFAULT_CAPACITY, isMinHeap);
    }

    public HeapTree(int capacity) {
        this(capacity, true);
    }

    public HeapTree(int capacity, boolean isMinHeap) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.heap = new int[capacity];
        this.size = 0;
        this.isMinHeap = isMinHeap;
    }

    // Build heap from array
    public HeapTree(int[] array, boolean isMinHeap) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        this.isMinHeap = isMinHeap;
        this.size = array.length;
        this.heap = new int[Math.max(array.length, DEFAULT_CAPACITY)];
        System.arraycopy(array, 0, this.heap, 0, array.length);
        buildHeap();
    }

    /**
     * Insert an element into the heap
     * Time Complexity: O(log n)
     */
    public void insert(int value) {
        if (size >= heap.length) {
            resizeHeap();
        }
        heap[size] = value;
        siftUp(size);
        size++;
    }

    /**
     * Remove and return the root element (min for min-heap, max for max-heap)
     * Time Complexity: O(log n)
     */
    public int extract() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        if (size > 0) {
            siftDown(0);
        }
        return root;
    }

    /**
     * Get the root element without removing it
     * Time Complexity: O(1)
     */
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        return heap[0];
    }

    /**
     * Remove a specific element from the heap
     * Time Complexity: O(n) for finding + O(log n) for removal
     */
    public boolean remove(int value) {
        int index = findIndex(value);
        if (index == -1) {
            return false;
        }
        
        if (index == size - 1) {
            size--;
            return true;
        }
        
        heap[index] = heap[size - 1];
        size--;
        
        // Restore heap property
        int parent = getParentIndex(index);
        if (index > 0 && compare(heap[index], heap[parent])) {
            siftUp(index);
        } else {
            siftDown(index);
        }
        
        return true;
    }

    /**
     * Change the value at a specific index
     * Time Complexity: O(log n)
     */
    public void changeKey(int oldValue, int newValue) {
        int index = findIndex(oldValue);
        if (index == -1) {
            throw new NoSuchElementException("Value not found in heap");
        }
        
        int oldVal = heap[index];
        heap[index] = newValue;
        
        if (compare(newValue, oldVal)) {
            siftUp(index);
        } else {
            siftDown(index);
        }
    }

    /**
     * Merge two heaps (must be of same type)
     * Time Complexity: O(n + m)
     */
    public void merge(HeapTree other) {
        if (other == null || other.isEmpty()) {
            return;
        }
        if (this.isMinHeap != other.isMinHeap) {
            throw new IllegalArgumentException("Cannot merge heaps of different types");
        }
        
        // Ensure capacity
        while (this.size + other.size >= this.heap.length) {
            resizeHeap();
        }
        
        // Copy elements
        for (int i = 0; i < other.size; i++) {
            this.heap[this.size + i] = other.heap[i];
        }
        this.size += other.size;
        
        // Rebuild heap property
        buildHeap();
    }

    // Utility methods
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean isMinHeap() {
        return isMinHeap;
    }

    public boolean isMaxHeap() {
        return !isMinHeap;
    }

    /**
     * Check if the heap property is maintained
     * Time Complexity: O(n)
     */
    public boolean isValidHeap() {
        for (int i = 0; i < size; i++) {
            int left = getLeftChildIndex(i);
            int right = getRightChildIndex(i);
            
            if (left < size && !compare(heap[i], heap[left])) {
                return false;
            }
            if (right < size && !compare(heap[i], heap[right])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Get all elements in level order
     * Time Complexity: O(n)
     */
    public int[] toArray() {
        return Arrays.copyOf(heap, size);
    }

    /**
     * Get sorted array (ascending for min-heap, descending for max-heap)
     * Time Complexity: O(n log n)
     */
    public int[] heapSort() {
        int[] result = new int[size];
        HeapTree tempHeap = new HeapTree(Arrays.copyOf(heap, size), isMinHeap);
        
        for (int i = 0; i < size; i++) {
            result[i] = tempHeap.extract();
        }
        
        return result;
    }

    public void clear() {
        size = 0;
    }

    /**
     * Print heap in tree format (level by level)
     */
    public void printHeap() {
        if (isEmpty()) {
            System.out.println("Heap is empty");
            return;
        }
        
        System.out.println((isMinHeap ? "Min" : "Max") + " Heap:");
        printLevel(0, 0);
    }

    /**
     * Get kth smallest/largest element without removing it
     * Time Complexity: O(k log k)
     */
    public int getKthElement(int k) {
        if (k <= 0 || k > size) {
            throw new IllegalArgumentException("Invalid k value");
        }
        
        // For finding kth element, we use a temporary heap
        HeapTree tempHeap = new HeapTree(!isMinHeap);
        tempHeap.insert(heap[0]);
        
        for (int i = 0; i < k - 1; i++) {
            int index = tempHeap.findIndexInOriginal(tempHeap.peek());
            tempHeap.extract();
            
            int left = getLeftChildIndex(index);
            int right = getRightChildIndex(index);
            
            if (left < size) tempHeap.insert(heap[left]);
            if (right < size) tempHeap.insert(heap[right]);
        }
        
        return tempHeap.peek();
    }

    // Private helper methods
    private void siftUp(int index) {
        if (index <= 0) return;
        
        int parentIndex = getParentIndex(index);
        if (compare(heap[index], heap[parentIndex])) {
            swap(index, parentIndex);
            siftUp(parentIndex);
        }
    }

    private void siftDown(int index) {
        int targetIndex = index;
        int leftChild = getLeftChildIndex(index);
        int rightChild = getRightChildIndex(index);
        
        if (leftChild < size && compare(heap[leftChild], heap[targetIndex])) {
            targetIndex = leftChild;
        }
        
        if (rightChild < size && compare(heap[rightChild], heap[targetIndex])) {
            targetIndex = rightChild;
        }
        
        if (targetIndex != index) {
            swap(index, targetIndex);
            siftDown(targetIndex);
        }
    }

    private boolean compare(int child, int parent) {
        return isMinHeap ? child < parent : child > parent;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void resizeHeap() {
        int[] newHeap = new int[heap.length * 2];
        System.arraycopy(heap, 0, newHeap, 0, heap.length);
        heap = newHeap;
    }

    private void buildHeap() {
        for (int i = (size / 2) - 1; i >= 0; i--) {
            siftDown(i);
        }
    }

    private int findIndex(int value) {
        for (int i = 0; i < size; i++) {
            if (heap[i] == value) {
                return i;
            }
        }
        return -1;
    }

    private int findIndexInOriginal(int value) {
        // This is a helper method for getKthElement
        // In a real implementation, you'd maintain a mapping
        return findIndex(value);
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    private void printLevel(int index, int level) {
        if (index >= size) return;
        
        // Print right subtree first
        printLevel(getRightChildIndex(index), level + 1);
        
        // Print current node with indentation
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(heap[index]);
        
        // Print left subtree
        printLevel(getLeftChildIndex(index), level + 1);
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(heap[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Main method for testing
    public static void main(String[] args) {
        System.out.println("=== Min Heap Demo ===");
        HeapTree minHeap = new HeapTree(true);
        
        // Insert elements
        int[] values = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        for (int val : values) {
            minHeap.insert(val);
            System.out.println("Inserted " + val + ": " + minHeap);
        }
        
        System.out.println("\nMin Heap Structure:");
        minHeap.printHeap();
        
        System.out.println("\nExtracting elements:");
        while (!minHeap.isEmpty()) {
            System.out.println("Extracted: " + minHeap.extract() + ", Remaining: " + minHeap);
        }
        
        System.out.println("\n=== Max Heap Demo ===");
        HeapTree maxHeap = new HeapTree(values, false);
        System.out.println("Built from array: " + maxHeap);
        
        System.out.println("\nMax Heap Structure:");
        maxHeap.printHeap();
        
        System.out.println("\nHeap Sort (descending): " + Arrays.toString(maxHeap.heapSort()));
        
        System.out.println("\n=== Advanced Operations ===");
        HeapTree advancedHeap = new HeapTree(true);
        for (int i = 1; i <= 10; i++) {
            advancedHeap.insert(i);
        }
        
        System.out.println("Original heap: " + advancedHeap);
        System.out.println("3rd smallest element: " + advancedHeap.getKthElement(3));
        System.out.println("Remove element 5: " + advancedHeap.remove(5));
        System.out.println("After removal: " + advancedHeap);
        
        advancedHeap.changeKey(7, 1);
        System.out.println("Changed 7 to 1: " + advancedHeap);
        
        System.out.println("Is valid heap: " + advancedHeap.isValidHeap());
    }
}