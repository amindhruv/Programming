import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Romans {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of names: ");
        int n = sc.nextInt();
        System.out.println("Enter the names:");
        String[] names = new String[n];
        for (int i = 0; i < n; i++)
            names[i] = sc.nextLine();
        getSortedList(names);
        System.out.println("Sorted list:");
        for (String name : names)
            System.out.println(name);
        System.out.print("Enter arabic number you want to convert to roman: ");
        int arabic = sc.nextInt();
        System.out.println(arabic + " in Roman: " + intToRoman(arabic));
        sc.close();
    }

    private static void getSortedList(String[] names) {
        Arrays.sort(names, (o1, o2) -> {
            String[] s1 = o1.split(" ");
            String[] s2 = o2.split(" ");
            int res = s1[0].compareTo(s2[0]);
            if (res != 0)
                return res;
            return romanToInt(s1[1]) > romanToInt(s2[1]) ? 1 : -1;
        });
    }

    private static int romanToInt(String roman) {
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);
        int result = 0;
        for (int i = 0; i < roman.length(); i++) {
            char ch = roman.charAt(i);
            if (i < (roman.length() - 1) && hm.get(ch) < hm.get(roman.charAt(i + 1)))
                result -= hm.get(ch);
            else
                result += hm.get(ch);
        }
        return result;
    }

    private static String intToRoman(int arabic) {
        String[] M = {"", "M", "MM", "MMM"};
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[arabic / 1000] + C[(arabic % 1000) / 100] + X[(arabic % 100) / 10] + I[arabic % 10];
    }
}