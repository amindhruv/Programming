public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 6, 8, 10};
        System.out.println(find(nums, 10) ? "Found" : "Not found");
        System.out.println(find(nums, 11) ? "Found" : "Not found");
    }

    private static boolean find(int[] nums, int n) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == n)
                return true;
            else if (nums[mid] < n)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }
}