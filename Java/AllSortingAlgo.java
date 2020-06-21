import java.util.Arrays;
import java.util.Scanner;

public class AllSortingAlgo {
    public static void main(String[] args) {
        System.out.print("Enter number of integers: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter integers:");
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        sc.close();
        int[] sNum = nums.clone(), bNum = nums.clone(), iNum = nums.clone(), mNum = nums.clone(), qNum = nums.clone(), hNum = nums.clone(), cNum = nums.clone();
        selectionSort(sNum);
        bubbleSort(bNum);
        insertionSort(iNum);
        mergeSort(mNum, 0, n - 1);
        quickSort(qNum, 0, n - 1);
        heapSort(hNum);
        countingSort(cNum, Arrays.stream(nums).summaryStatistics().getMax());
    }

    /*  Java & Python uses Tim Sort for sorting which is combination of Insertion & Merge Sort,
        while C++ STL uses Intro Sort which is combination of Quick & Heap Sort.
        Tim Sort -> Best: O(n), Average & Worst case: O(n*ln n) but takes extra space: O(n) <- Stable (good to sort reference data types)
        Intro Sort -> for all cases take O(n*ln n) <- Unstable (good to sort primitive data types)
    */
    // Comparison based : Selection, Bubble, Insertion, Merge, Quick, Heap Sort <- Optimal time limit O(n*ln n)
    // Selection Sort => Time complexity -> for all cases: O(n^2); Space complexity -> O(1)
    private static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++)
                if (nums[j] < nums[minIndex])
                    minIndex = j;
            swap(nums, minIndex, i);
        }
    }

    // Bubble Sort => Time complexity -> Best case: O(n), Average & Worst case: O(n^2); Space complexity -> O(1)
    private static void bubbleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            boolean flag = false;
            for (int j = 0; j < nums.length - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    flag = true;
                    swap(nums, j, j + 1);
                }
            }
            if (!flag) break;
        }
    }

    // Insertion Sort => Time complexity -> Best case: O(n), Average & Worst case: O(n^2); Space complexity -> O(1)
    private static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int pivot = nums[i], j = i - 1;
            while (j >= 0 && nums[j] > pivot)
                nums[j + 1] = nums[j--];
            nums[j + 1] = pivot;
        }
    }

    //Merge Sort => Time complexity -> for all cases: O(n*ln n); Space complexity -> O(n)
    private static void mergeSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    private static void merge(int[] nums, int low, int mid, int high) {    //O(n)
        int[] temp = new int[nums.length];
        System.arraycopy(nums, 0, temp, 0, nums.length);    //Extra space : O(n)
        int i = low, j = mid + 1, k = low;
        while (i <= mid && j <= high) {
            if (temp[i] <= temp[j])
                nums[k++] = temp[i++];
            else
                nums[k++] = temp[j++];
        }
        while (i <= mid)
            nums[k++] = temp[i++];
    }

    //Quick Sort => Time complexity -> Best & Average case: O(n*ln n), Worst case: O(n^2); Space complexity -> O(1)
    private static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pivot = partition(nums, low, high);
            quickSort(nums, low, pivot - 1);
            quickSort(nums, pivot + 1, high);
        }
    }

    private static int partition(int[] nums, int low, int high) {    //O(n)
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (nums[j] < nums[high]) {
                i++;
                if (i != j) swap(nums, i, j);
            }
        }
        i++;
        swap(nums, i, high);
        return i;
    }

    // Heap Sort => Time complexity -> for all cases: O(n*ln n); Space complexity -> O(1)
    private static void heapSort(int[] nums) {
        int n = nums.length;
        // Build heap (rearrange array) -> O(n)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(nums, n, i);
        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            swap(nums, 0, i);
            // call max heapify on the reduced heap
            heapify(nums, i, 0);
        }
    }

    private static void heapify(int[] nums, int size, int i) {
        int largest = i, left = 2 * i + 1, right = 2 * i + 2;
        if (left < size && nums[left] > nums[largest])    // If left child is larger than root
            largest = left;
        if (right < size && nums[right] > nums[largest])    // If right child is larger than largest so far
            largest = right;
        if (largest != i) {    // If largest is not root
            swap(nums, i, largest);
            heapify(nums, size, largest);    // Recursively heapify the affected sub-tree
        }
    }

    // Linear(or Distribution) sorting : Counting {In [0, k] range}, Radix {d digits with b base}, Bucket {In [0, 1) range} Sort <- No comparison used
    // Counting Sort => Time complexity -> for all cases: O(n + maxValue); Space complexity -> O(n + maxValue)
    private static void countingSort(int[] nums, int maxValue) {    //
        int[] output = new int[nums.length], count = new int[maxValue + 1];
        for (int num : nums)    //O(n)
            count[num]++;
        for (int i = 0; i < maxValue; i++)    //O(maxValue)
            count[i + 1] += count[i];
        for (int num : nums)    //O(n)
            output[--count[num]] = num;
        System.arraycopy(output, 0, nums, 0, nums.length);
    }
    
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
