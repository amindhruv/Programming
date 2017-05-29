import java.util.Scanner;

public class EvenDivisors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any integer:");
        int n = sc.nextInt();
        sc.close();
        if (n % 2 != 0)
            System.out.println(0);
        else {
            int count = 0;
            for (int i = 1; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    if (i % 2 == 0)
                        count++;
                    int j = n / i;
                    if (j != i && j % 2 == 0)
                        count++;
                }
            }
            System.out.println(count);
        }
    }
}