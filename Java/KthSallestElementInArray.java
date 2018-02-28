import java.util.Scanner;

public class KthSallestElementInArray {
	public static void main(String[] args) {
		KthSallestElementInArray obj = new KthSallestElementInArray();
		Scanner in = new Scanner(System.in);
		System.out.print("Enter number of elements in array: ");
		int n = in.nextInt();
		int[] nums = new int[n];
		System.out.print("Enter " + n + " integers: ");
		for (int i = 0; i < n; i++)
			nums[i] = in.nextInt();
		System.out.print("Enter value of k: ");
		int k = in.nextInt();
		in.close();
		System.out.println(k + "th smallest element in given array: " + obj.kthSmallestElement(nums, k));
	}

	public int kthSmallestElement(int[] nums, int k) {
		int n = nums.length;
		if (k < 1 || k > n) return Integer.MIN_VALUE;	// Invalid data
		return quickSelect(nums, 0, n - 1, k);
	}

	private int quickSelect(int[] nums, int low, int high, int k) {
		if (low > high) return Integer.MIN_VALUE;	// Invalid data
		int pivot = partition(nums, low, high);
		if (pivot == k - 1) return nums[pivot];
		if (pivot < k - 1) return quickSelect(nums, pivot + 1, high, k);
		return quickSelect(nums, low, pivot - 1, k);
	}

	private int partition(int[] nums, int low, int high) {
		int pivot = nums[high], i = low, temp;
		for (int j = low; j < high; j++) {
			if (nums[j] < pivot) {
				temp = nums[i];
				nums[i++] = nums[j];
				nums[j] = temp;
			}
		}
		temp = nums[i];
		nums[i] = nums[high];
		nums[high] = temp;
		return i;
	}
}
