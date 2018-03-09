import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BracketCombinations {
    public static void main(String args[]) {
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      in.close();
      allBracketCombinations(n).forEach(System.out::println);
    }
    
    private static List<String> allBracketCombinations(int n) {
    	List<String> ans = new ArrayList<>();
    	helper(n, 0, "", ans);
    	return ans;
    }
    
    private static void helper(int left, int right, String str, List<String> ans) {
    	if (left == 0 && right == 0) ans.add(str);
    	if (left > 0) helper(left - 1, right + 1, str + "(", ans);
    	if (right > 0) helper(left, right - 1, str + ")", ans);
    }
}
