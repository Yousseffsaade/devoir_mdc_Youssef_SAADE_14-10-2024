// Define the SortingStrategy interface
interface SortingStrategy {
    void sort(int[] array);
}

// Implement concrete sorting strategies
class BubbleSort implements SortingStrategy {
    public void sort(int[] array) {
        System.out.println("Sorting using Bubble Sort");
        // Implementation of Bubble Sort
        // ...
    }
}

class QuickSort implements SortingStrategy {
    public void sort(int[] array) {
        System.out.println("Sorting using Quick Sort");
        // Implementation of Quick Sort
        // ...
    }
}

class InsertionSort implements SortingStrategy {
    public void sort(int[] array) {
        System.out.println("Sorting using Insertion Sort");
        // Implementation of Insertion Sort
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            // Move elements of array[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        // Print the sorted array
        System.out.print("Sorted array: ");
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}



// Context class that passes data to the selected sorting strategy
class Sorter {
    private SortingStrategy strategy;

    public Sorter(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void performSort(int[] array) {
        strategy.sort(array);
    }
}

public class StrategyPatternExample {
    public static void main(String[] args) {
        int[] numbers = {5, 1, 4, 2, 8};

        // Create sorting strategies
        SortingStrategy bubbleSort = new BubbleSort();
        SortingStrategy quickSort = new QuickSort();
        SortingStrategy insertionSort = new InsertionSort(); // New Insertion Sort strategy

        // Create a sorter with the BubbleSort strategy
        Sorter sorter = new Sorter(bubbleSort);

        // Perform a sort using the BubbleSort strategy
        sorter.performSort(numbers);

        // Switch to the QuickSort strategy and perform another sort
        sorter.setStrategy(quickSort);
        sorter.performSort(numbers);

        // Switch to the InsertionSort strategy and perform another sort
        sorter.setStrategy(insertionSort);
        sorter.performSort(numbers);  // Testing InsertionSort
    }
}

