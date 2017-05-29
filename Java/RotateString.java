import java.util.Scanner;

public class RotateString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int offset = sc.nextInt();
        sc.close();
        rotateString(str.toCharArray(), offset);
    }

    private static void rotateString(char[] chars, int offset) {
        int length = chars.length;
        if (offset > length)
            offset = offset % length;
        int p = length - offset;
        reverse(chars, 0, p - 1);
        reverse(chars, p, length - 1);
        reverse(chars, 0, length - 1);
        System.out.println("Rotated string: " + String.valueOf(chars));
    }

    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }
}