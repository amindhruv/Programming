import java.util.Scanner;
import java.util.Stack;

public class LongestValidParentheses {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter string to validate: ");
		String inp = in.nextLine();
		in.close();
		System.out.println("Longest valid parentheses length: " + longestValidParentheses(inp));
	}

	private static int longestValidParentheses(String str) {
		int ans = 0;
		Stack<Integer> st = new Stack<>();
		st.push(-1);
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') st.push(i);
			else {
				st.pop();
				if (!st.isEmpty()) ans = Math.max(ans, i - st.peek());
				else st.push(i);
			}
		}
		return ans;
	}
}
