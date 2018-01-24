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
        double base = sc.nextDouble();
        int exponent = sc.nextInt();
        System.out.println(base + "^" + exponent + ": " + power(base, exponent));
        System.out.println("Using iterative approach -> " + base + "^" + exponent + ": " + power(base, exponent));
        System.out.print("Enter a number to reverse: ");
        number = sc.nextInt();
        System.out.println("Reversed number: " + reverse(number));
        System.out.print("Enter a number to to check if it's palindrome or not: ");
        number = sc.nextInt();
        System.out.println("Entered number is " + (isPalindrome(number) ? "" : "not ") + "palindrome.");
        sc.close();
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
    
    private static int reverse(int num) {
        long rev = 0;
        while (num != 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
            if (rev < Integer.MIN_VALUE || rev > Integer.MAX_VALUE) return 0;
        }
        return (int)rev;
    }

    private static boolean isPalindrome(int num) {
        if (num < 0 || (num != 0 && num % 10 == 0)) return false;
        int rev = 0;
        while (num > rev) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return num == rev || num == rev / 10;
    }

    private static double power(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n < 0) return 1 / power(x, -n);
        double temp = power(x, n / 2);
        return n % 2 == 0 ? temp * temp : temp * temp * x;
    }

    private static double powerIterative(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double result = 1;
        while (n != 0) {
            if ((n & 1) == 1) result *= x;
            x *= x;
            n >>= 1;
        }
        return result;
    }
}
