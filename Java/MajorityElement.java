import java.util.Scanner;

public class MajorityElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements you want to enter: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println("Majority element: " + majorityElement(nums));
    }

    private static int majorityElement(int[] nums) {
        int count = 0, result = 0;
        for (int num : nums) {
            if (count == 0) {
                result = num;
                count = 1;
            } else if (num == result)
                count++;
            else
                count--;
        }
        return result;
    }
}