public class Main {
    private int[][] array;
    private int rows;
    private int cols;
    private final int maxRows;
    private final int maxCols;

    // Constructor with fixed dimensions
    public Main(int maxRows, int maxCols) {
        this.maxRows = maxRows;
        this.maxCols = maxCols;
        this.array = new int[maxRows][maxCols];
        this.rows = 0;
        this.cols = 0;
    }

    // Add a new row at the beginning
    public boolean pushFrontRow(int[] rowData) {
        if (rows >= maxRows) {
            return false; // Cannot add more rows
        }

        int newRowLength = Math.min(rowData.length, maxCols);

        // Shift rows down
        for (int i = rows; i > 0; i--) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = array[i - 1][j];
            }
        }

        // Add new row at the beginning
        for (int j = 0; j < newRowLength; j++) {
            array[0][j] = rowData[j];
        }

        rows++;
        cols = Math.max(cols, newRowLength);
        return true;
    }

    // Add a new row at the end
    public boolean pushBackRow(int[] rowData) {
        if (rows >= maxRows) {
            return false; // Cannot add more rows
        }

        int newRowLength = Math.min(rowData.length, maxCols);

        // Add new row at the end
        for (int j = 0; j < newRowLength; j++) {
            array[rows][j] = rowData[j];
        }

        rows++;
        cols = Math.max(cols, newRowLength);
        return true;
    }

    // Add a new column at the beginning
    public boolean pushFrontCol(int[] colData) {
        if (cols >= maxCols) {
            return false; // Cannot add more columns
        }

        int newColLength = Math.min(colData.length, maxRows);

        // Shift columns to the right
        for (int i = 0; i < rows; i++) {
            for (int j = cols; j > 0; j--) {
                array[i][j] = array[i][j - 1];
            }
        }

        // Add new column at the beginning
        for (int i = 0; i < newColLength; i++) {
            array[i][0] = colData[i];
        }

        cols++;
        rows = Math.max(rows, newColLength);
        return true;
    }

    // Add a new column at the end
    public boolean pushBackCol(int[] colData) {
        if (cols >= maxCols) {
            return false; // Cannot add more columns
        }

        int newColLength = Math.min(colData.length, maxRows);

        // Add new column at the end
        for (int i = 0; i < newColLength; i++) {
            array[i][cols] = colData[i];
        }

        cols++;
        rows = Math.max(rows, newColLength);
        return true;
    }

    // Search for an element in the array
    public int[] search(int value) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (array[i][j] == value) {
                    return new int[]{i, j}; // Return the coordinates of the element
                }
            }
        }

        return new int[]{-1, -1}; // Element not found
    }

    // Delete a row by index
    public boolean deleteRow(int rowIndex) {
        if (rowIndex < 0 || rowIndex >= rows) {
            return false; // Invalid index
        }

        // Shift rows up
        for (int i = rowIndex; i < rows - 1; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = array[i + 1][j];
            }
        }

        // Clear the last row
        for (int j = 0; j < cols; j++) {
            array[rows - 1][j] = 0;
        }

        rows--;
        return true;
    }

    // Delete a column by index
    public boolean deleteCol(int colIndex) {
        if (colIndex < 0 || colIndex >= cols) {
            return false; // Invalid index
        }

        // Shift columns to the left
        for (int i = 0; i < rows; i++) {
            for (int j = colIndex; j < cols - 1; j++) {
                array[i][j] = array[i][j + 1];
            }
            // Clear the last column
            array[i][cols - 1] = 0;
        }

        cols--;
        return true;
    }

    // Delete the first occurrence of a value
    public boolean deleteNode(int value) {
        int[] coordinates = search(value);
        int row = coordinates[0];
        int col = coordinates[1];

        if (row == -1 || col == -1) {
            return false; // Element not found
        }

        // Shift elements to the left in the current row
        for (int j = col; j < cols - 1; j++) {
            array[row][j] = array[row][j + 1];
        }

        // Clear the last element
        array[row][cols - 1] = 0;

        return true;
    }

    // Reverse the array horizontally (reverse each row)
    public void reverseHorizontal() {
        for (int i = 0; i < rows; i++) {
            int left = 0;
            int right = cols - 1;

            while (left < right) {
                // Swap elements
                int temp = array[i][left];
                array[i][left] = array[i][right];
                array[i][right] = temp;

                left++;
                right--;
            }
        }
    }

    // Reverse the array vertically (reverse the order of rows)
    public void reverseVertical() {
        for (int j = 0; j < cols; j++) {
            int top = 0;
            int bottom = rows - 1;

            while (top < bottom) {
                // Swap elements
                int temp = array[top][j];
                array[top][j] = array[bottom][j];
                array[bottom][j] = temp;

                top++;
                bottom--;
            }
        }
    }

    // Complete reversal (both horizontal and vertical)
    public void reverse() {
        reverseHorizontal();
        reverseVertical();
    }

    // Get element at specific position
    public int get(int rowIndex, int colIndex) {
        if (rowIndex < 0 || rowIndex >= rows || colIndex < 0 || colIndex >= cols) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        return array[rowIndex][colIndex];
    }

    // Set element at specific position
    public boolean set(int rowIndex, int colIndex, int value) {
        if (rowIndex < 0 || rowIndex >= maxRows || colIndex < 0 || colIndex >= maxCols) {
            return false; // Invalid index
        }

        array[rowIndex][colIndex] = value;

        if (rowIndex >= rows) {
            rows = rowIndex + 1;
        }

        if (colIndex >= cols) {
            cols = colIndex + 1;
        }

        return true;
    }

    // Get number of rows
    public int getRows() {
        return rows;
    }

    // Get number of columns
    public int getCols() {
        return cols;
    }

    // Print the 2D array
    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Main arr = new Main(5, 5);

        // Add elements
        arr.set(0, 0, 1);
        arr.set(0, 1, 2);
        arr.set(0, 2, 3);
        arr.set(1, 0, 4);
        arr.set(1, 1, 5);
        arr.set(1, 2, 6);

        System.out.println("Original 2D Array:");
        arr.print();

        // Search for an element
        int[] pos = arr.search(5);
        System.out.println("Position of 5: [" + pos[0] + ", " + pos[1] + "]");

        // Push a new row at the front
        arr.pushFrontRow(new int[]{10, 11, 12});
        System.out.println("\nAfter pushing a row at the front:");
        arr.print();

        // Push a new column at the back
        arr.pushBackCol(new int[]{13, 14, 15});
        System.out.println("\nAfter pushing a column at the back:");
        arr.print();

        // Delete an element
        arr.deleteNode(5);
        System.out.println("\nAfter deleting element 5:");
        arr.print();

        // Reverse horizontally
        arr.reverseHorizontal();
        System.out.println("\nAfter reversing horizontally:");
        arr.print();

        // Reverse vertically
        arr.reverseVertical();
        System.out.println("\nAfter reversing vertically:");
        arr.print();

        // Complete reverse
        arr.reverse();
        System.out.println("\nAfter complete reversal:");
        arr.print();
    }
}