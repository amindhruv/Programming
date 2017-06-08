import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        factorial(num);
    }

    private static void factorial(int num) {
        byte[] result = new byte[50000];
        int size = 1;
        result[0] = 1;
        for (int i = 2; i <= num; i++)
            size = multiply(result, size, i);
        System.out.println("Factorial of " + num + " is:");
        for (int i = size - 1; i >= 0; i--)
            System.out.print(result[i]);
        System.out.println();
    }

    private static int multiply(byte[] result, int size, int num) {
        int carry = 0;
        for (int i = 0; i < size; i++) {
            int product = result[i] * num + carry;
            result[i] = (byte) (product % 10);
            carry = product / 10;
        }
        while (carry > 0) {
            result[size++] = (byte) (carry % 10);
            carry /= 10;
        }
        return size;
    }
}
