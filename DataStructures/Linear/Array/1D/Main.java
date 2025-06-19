class FixedArray {
    private int[] array;
    private int size;
    private final int capacity;

    // Constructor with fixed capacity
    public FixedArray(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.size = 0;
    }

    // Add element at the beginning of the array
    public boolean pushFront(int value) {
        // Check if array is full
        if (size >= capacity) {
            return false; // Cannot add more elements
        }

        // Shift elements to make room at the beginning
        for (int i = size; i > 0; i--) {
            array[i] = array[i - 1];
        }

        array[0] = value;
        size++;
        return true;
    }

    // Add element at the end of the array
    public boolean pushBack(int value) {
        // Check if array is full
        if (size >= capacity) {
            return false; // Cannot add more elements
        }

        array[size] = value;
        size++;
        return true;
    }

    // Search for an element in the array
    public int search(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                return i; // Return the index of the element
            }
        }

        return -1; // Element not found
    }

    // Delete an element by value (first occurrence)
    public boolean deleteNode(int value) {
        int index = search(value);

        if (index == -1) {
            return false; // Element not found
        }

        // Shift elements to fill the gap
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        size--;
        return true;
    }

    // Reverse the array
    public void reverse() {
        int left = 0;
        int right = size - 1;

        while (left < right) {
            // Swap elements
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            left++;
            right--;
        }
    }

    // Get element at specific index
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        return array[index];
    }

    // Set element at specific index
    public boolean set(int index, int value) {
        if (index < 0 || index >= size) {
            return false; // Invalid index
        }

        array[index] = value;
        return true;
    }

    // Get the current size of the array
    public int size() {
        return size;
    }

    // Check if array is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if array is full
    public boolean isFull() {
        return size == capacity;
    }

    // Print the array
    public void print() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i]);
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

// Main class to test the FixedArray class
public class Main {
    public static void main(String[] args) {
        FixedArray arr = new FixedArray(10);

        // Add elements
        arr.pushBack(1);
        arr.pushBack(2);
        arr.pushBack(3);
        arr.pushFront(0);

        System.out.println("Original Array:");
        arr.print();

        // Search for elements
        System.out.println("Search for 2: " + arr.search(2));
        System.out.println("Search for 5: " + arr.search(5));

        // Delete an element
        arr.deleteNode(2);
        System.out.println("Array after deleting 2:");
        arr.print();

        // Reverse the array
        arr.reverse();
        System.out.println("Reversed Array:");
        arr.print();
    }
}