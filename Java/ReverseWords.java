import java.util.Scanner;

public class ReverseWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        reverseWords(str);
    }

    private static void reverseWords(String str) {
        char[] chars = str.toCharArray();
        int start = 0, n = chars.length;
        for (int i = 0; i < n; i++) {
            if (chars[i] == ' ') {
                reverse(chars, start, i - 1);
                start = i + 1;
            } else if (i == n - 1)
                reverse(chars, start, i);
        }
        reverse(chars, 0, n - 1);
        System.out.println(chars);
    }

    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }
}