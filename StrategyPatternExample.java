// Define the SortingStrategy interface
interface SortingStrategy {
    void sort();
}

// Implement concrete sorting strategies
class BubbleSort implements SortingStrategy {
    private Sorter context;

    public BubbleSort(Sorter context) {
        this.context = context;
    }

    public void sort() {
        int[] array = context.getData();
        System.out.println("Sorting using Bubble Sort");
        // Implementation of Bubble Sort using context.getData()
        // ...
    }
}

class QuickSort implements SortingStrategy {
    private Sorter context;

    public QuickSort(Sorter context) {
        this.context = context;
    }

    public void sort() {
        int[] array = context.getData();
        System.out.println("Sorting using Quick Sort");
        // Implementation of Quick Sort using context.getData()
        // ...
    }
}

class InsertionSort implements SortingStrategy {
    private Sorter context;

    public InsertionSort(Sorter context) {
        this.context = context;
    }

    public void sort() {
        int[] array = context.getData();
        System.out.println("Sorting using Insertion Sort");
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        System.out.print("Sorted array: ");
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}




// Context class that retains data and passes itself to the selected sorting strategy
class Sorter {
    private SortingStrategy strategy;
    private int[] data;

    public Sorter(int[] data) {
        this.data = data;
    }

    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public int[] getData() {
        return data;
    }

    public void performSort() {
        strategy.sort();
    }
}

public class StrategyPatternExample {
    public static void main(String[] args) {
        int[] numbers = {5, 1, 4, 2, 8};

        // Create a sorter with the BubbleSort strategy
        Sorter sorter = new Sorter(numbers);
        SortingStrategy bubbleSort = new BubbleSort(sorter);
        sorter.setStrategy(bubbleSort);

        // Perform a sort using the BubbleSort strategy
        sorter.performSort();

        // Switch to the QuickSort strategy and perform another sort
        SortingStrategy quickSort = new QuickSort(sorter);
        sorter.setStrategy(quickSort);
        sorter.performSort();

        // Switch to the InsertionSort strategy and perform another sort
        SortingStrategy insertionSort = new InsertionSort(sorter);  // New InsertionSort strategy
        sorter.setStrategy(insertionSort);
        sorter.performSort();  // Testing InsertionSort
    }
}
