import java.util.Scanner;

public class MathComputation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to compute its factorial: ");
        int number = sc.nextInt();
        factorial(number);
        System.out.print("Enter a number to compute its integer square root: ");
        number = sc.nextInt();
        System.out.println("Integer(floor) square root of " + number + ": " + sqrt(number));
        System.out.print("Enter a number to compute its integer cube root: ");
        number = sc.nextInt();
        System.out.println("Integer cube root of " + number + ": " + cubeRoot(number));
        System.out.print("Enter base and exponent to compute power: ");
        float base = sc.nextFloat();
        int exponent = sc.nextInt();
        System.out.println(base + "^" + exponent + ": " + power(base, exponent));
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

    private static int sqrt(int number) {
        if (number < 0) return -1; // Invalid input indicator
        if (number < 2) return number;
        int low = 1, high = number, ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid <= number / mid) {
                low = mid + 1;
                ans = mid;
            } else
                high = mid - 1;
        }
        return ans;
    }

    private static int cubeRoot(int number) {
        boolean isMinus = false;
        if (number < 0) {
            isMinus = true;
            number *= -1;
        }
        int low = 1, high = number, ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid <= ((number / mid) / mid)) {
                low = mid + 1;
                ans = mid;
            } else
                high = mid - 1;
        }
        return isMinus ? -ans : ans;
    }

    private static double power(float x, int y) {
        if (y == 0)
            return 1;
        double temp = power(x, y / 2);
        if (y % 2 == 0)
            return temp * temp;
        else {
            if (y > 0)
                return x * temp * temp;
            else
                return (temp * temp) / x;
        }
    }
}
