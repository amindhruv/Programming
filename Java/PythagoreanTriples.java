import java.util.Arrays;

public class PythagoreanTriples {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 24, 2, 10, 3, 1, 4, 8, 26, 6, 12, 10, 13};
        pythagorusTriples(nums);
    }

    private static void pythagorusTriples(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i > 1; i--) {
            int j = 0, k = i - 1;
            while (j < k) {
                if ((nums[j] * nums[j] + nums[k] * nums[k]) == nums[i] * nums[i]) {
                    System.out.println(nums[i] + ", " + nums[j] + ", " + nums[k]);
                    break;
                } else if ((nums[j] * nums[j] + nums[k] * nums[k]) < nums[i] * nums[i])
                    j++;
                else
                    k--;
            }
        }
    }
}