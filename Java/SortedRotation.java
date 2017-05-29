public class SortedRotation {
    public static void main(String[] args) {
        int[] nums = {6, 7, 8, 9, 10, 11, 1, 2, 3, 4, 5};
        System.out.println(rotation(nums, nums.length));
    }

    private static int rotation(int[] a, int n) {
        int low = 0, high = n - 1;
        while (low <= high) {
            if (a[low] <= a[high]) return low;
            int mid = (low + high) / 2;
            int next = (mid + 1) % n, prev = (mid - 1 + n) % n;
            if (a[mid] <= a[next] && a[mid] <= a[prev]) return mid;
            else if (a[mid] <= a[high]) high = mid - 1;
            else if (a[mid] >= a[low]) low = mid + 1;
        }
        return -1;
    }
}