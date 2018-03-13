import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElements {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Enter number of elements: ");
    int n = in.nextInt();
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = in.nextInt();
    }
    in.close();
    nextGreaterElements(nums);
  }
  
  private static void nextGreaterElements(int[] nums) {
    if (nums == null || nums.length == 0) return;
    Stack<Integer> st = new Stack<>();
    st.push(nums[0]);
    for (int i = 1; i < nums.length; i++) {
      while (!st.isEmpty() && st.peek() < nums[i])
        System.out.println("Next greater element for " + st.pop() + ": " + nums[i]);
      st.push(nums[i]);
    }
    while (!st.isEmpty()) System.out.println("Next greater element for " + st.pop() + ": null");
  }
}
