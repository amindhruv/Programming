public class MaximumSumSubarray {
    public static void main(String[] args) {
        int[] nums = {1, -3, 2, -5, 7, 6, -1, -4, 11, -23};
        System.out.println(maximumSumSubarray(nums));
    }

    private static int maximumSumSubarray(int[] nums) {
        int answer = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            answer = Math.max(answer, sum);
        }
        return answer;
    }
}