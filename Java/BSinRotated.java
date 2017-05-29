public class BSinRotated {
    public static void main(String[] args) {
        int[] nums = {1, 3};
        int key = 3;
        int index = binarySearchInRotatedArray(nums, key);
        if (index != -1)
            System.out.println(key + " found at index " + index);
        else
            System.out.println(key + " not found!");
    }

    private static int binarySearchInRotatedArray(int[] nums, int key) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (key == nums[mid]) return mid;
            if (nums[mid] <= nums[right]) {
                if (key >= nums[mid] && key <= nums[right]) left = mid + 1;
                else right = mid - 1;
            } else {
                if (key >= nums[left] && key <= nums[mid]) right = mid - 1;
                else left = mid + 1;
            }
        }
        return -1;
    }
}