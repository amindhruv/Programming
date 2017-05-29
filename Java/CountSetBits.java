import java.util.Scanner;

public class CountSetBits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println("Number of set bits in " + n + " is " + countSetBits(n));
    }

    private static int countSetBits(int n) {
        final int MASK1 = 0x55555555;
        final int MASK2 = 0x33333333;
        final int MASK3 = 0x0f0f0f0f;
        final int MASK4 = 0x00ff00ff;
        final int MASK5 = 0x0000ffff;
        n = (n & MASK1) + (n >> 1 & MASK1);
        n = (n & MASK2) + (n >> 2 & MASK2);
        n = (n & MASK3) + (n >> 4 & MASK3);
        n = (n & MASK4) + (n >> 8 & MASK4);
        n = (n & MASK5) + (n >> 16 & MASK5);
        return n;
    }
}