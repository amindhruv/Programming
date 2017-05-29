public class DuplicateMissing {
    public static void main(String[] args) {
        int[] withDuplicate = {3, 4, 1, 4, 2};
        System.out.println("Duplicate value: " + duplicate(withDuplicate));
        int[] withMissing = {3, 4, 1, 6, 2};
        System.out.println("Missing value: " + missing(withMissing));
        int[] sortedWithMissing = {1, 2, 3, 4, 6, 7, 8, 9};
//        int[] sortedWithMissing = {11, 12, 13, 15, 16, 17, 18, 19};
        System.out.println("Missing value in sorted array is: " + sortedMissing(sortedWithMissing));
    }

    private static int sortedMissing(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0, high = nums.length;
        if (nums[high - 1] == nums[low] + high - 1) return 0;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[0] + mid)
                high = mid;
            else
                low = mid + 1;
        }
        return nums[low] - 1;
    }

    private static int missing(int[] withMissing) {
        int result = 0;
        for (int i = 1; i <= withMissing.length + 1; i++)
            result ^= i;
        for (int num : withMissing)
            result ^= num;
        return result;
    }

    private static int duplicate(int[] withDuplicate) {
        int result = 0;
        for (int i = 1; i < withDuplicate.length; i++)
            result ^= i;
        for (int num : withDuplicate)
            result ^= num;
        return result;
    }
}