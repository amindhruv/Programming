import java.util.Scanner;
import java.util.Stack;

public class BinaryConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        base2(n);
        base2Recursive(n);
        System.out.println();
        baseMinus2(n);
        System.out.print("Enter binary number: ");
        sc.nextLine();
        String binary = sc.nextLine();
        base10(binary);
        sc.close();
    }

    private static void base2Recursive(int n) {
        if (n != 0) {
            base2Recursive(n / 2);
            System.out.print(n % 2);
        }
    }

    private static void baseMinus2(int n) {
        System.out.print("Base -2: ");
        while (n != 0) {
            int rem = n % -2;
            n /= -2;
            if (rem < 0) {
                rem += 2;
                n++;
            }
            System.out.print(rem);
        }
        System.out.println();
    }

    private static void base2(int n) {
        System.out.print("Base 2: ");
        Stack<Integer> st = new Stack<>();
        while (n != 0) {
            st.push(n % 2);
            n /= 2;
        }
        while (!st.isEmpty())
            System.out.print(st.pop());
        System.out.println();
    }

    private static void base10(String binary) {
        int decimal = 0;
        for (char ch : binary.toCharArray())
            decimal = decimal * 2 + (ch - '0');
        System.out.println(decimal);
    }
}