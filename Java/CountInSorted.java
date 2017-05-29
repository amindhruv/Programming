public class CountInSorted {
    public static void main(String[] args) {
        int[] nums = {1, 1, 3, 3, 5, 5, 5, 5, 5, 9, 9, 11};
        int value = 5, first = binarySearch(nums, value, true), last = binarySearch(nums, value, false);
        System.out.println(first + " " + last);
        if (first == -1)
            System.out.println(0);
        else
            System.out.println(last - first + 1);
    }

    private static int binarySearch(int[] nums, int value, boolean first) {
        int low = 0, high = nums.length - 1, result = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (value == nums[mid]) {
                result = mid;
                if (first)
                    high = mid - 1;
                else
                    low = mid + 1;
            } else if (value < nums[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return result;
    }
}