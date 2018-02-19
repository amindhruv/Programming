import java.util.Stack;

public class Decompress {
  public static String decompress(String compressed) {
    Stack<Integer> intStack = new Stack<>();
    Stack<StringBuilder> strStack = new Stack<>();
    StringBuilder cur = new StringBuilder();
    int k = 0;
    for (int i = 0; i < compressed.length(); i++) {
        char ch = compressed.charAt(i);
        if (Character.isDigit(ch)) {
            k = k * 10 + ch - '0';
        } else if (ch == '[') {
            intStack.push(k);
            strStack.push(cur);
            cur = new StringBuilder();
            k = 0;
        } else if (ch == ']') {
            StringBuilder tmp = cur;
            cur = strStack.pop();
            for (k = intStack.pop(); k > 0; --k) cur.append(tmp);
        } else cur.append(ch);
    }
    return cur.toString();
  }
  
  public static void main(String[] args) {
    System.out.println(decompress("3[abc]4[ab]c")); // -> abcabcabcababababc
    System.out.println(decompress("10[a]"));        // -> aaaaaaaaaa
    System.out.println(decompress("2[3[a]b]"));     // -> aaabaaab
    System.out.println(decompress("2[c3[a]b]"));    // -> caaabcaaab
  }
}
