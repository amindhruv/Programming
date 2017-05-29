import java.util.Scanner;
import java.util.Stack;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();
        System.out.println(isBalanced(str) ? "Balanced" : "Not balanced");
    }

    private static boolean isBalanced(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '{' || c == '[')
                st.push(c);
            else if (c == ')' || c == '}' || c == ']') {
                if (st.empty() || (c == ')' && st.peek() != '(') || (c == '}' && st.peek() != '{') || (c == ']' && st.peek() != '['))
                    return false;
                else
                    st.pop();
            }
        }
        return st.empty();
    }
}