public class LongestCommonSubsequence {
  // Using backtracking (recursion), Time Complexity = O(2 ^ (m + n)) where m & n are string lengths.
  public int longestCommonSubsequence(String first, String second) {
    return helper(first, second, 0, 0);
  }

  private int helper(String first, String second, int i, int j) {
    if (i == first.length() || j == second.length()) return 0;
    if (first.charAt(i) == second.charAt(j)) return 1 + helper(first, second, i + 1, j + 1);
    return Math.max(helper(first, second, i, j + 1), helper(first, second, i + 1, j));
  }

  // Using bottom up dynamic programming with extra space O(m * n), Time Complexity = O (m * n) where m & n are string lengths.
  public int longestCommonSubsequenceDP(String first, String second) {
    int m = first.length(), n = second.length();
    int[][] cache = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (first.charAt(i) == second.charAt(j)) cache[i][j] = 1 + cache[i - 1][j - 1];
        else cache[i][j] = Math.max(cache[i][j - 1], cache[i - 1][j]);
      }
    }
    return cache[n1][n2];
  }
}
