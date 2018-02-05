public class SolveWordSearchPuzzle {
  public List<String> wordSearch(char[][] board, String[] words) {
    List<String> result = new ArrayList<>();
    if (board.length == 0) return result;
    for (String word : words)
      if (isFound(board, word)) result.add(word);
    return result;
  }

  private boolean isFound(char[][] board, String word) {
    int rows = board.length, columns = board[0].length;
    for (int row = 0; row < rows; row++)
      for (int col = 0; col < columns; col++)
        if (dfs(board, words, row, col, 0)) return true;
    return false;
  }

  private boolean dfs(char[][] board, String word, int row, int col, int index) {
    if (row < 0 || row >= board.length() || col < 0 || col >= board[0].length) return false;
    if (board[row][col] == word.charAt(index)) {
      char temp = board[row][col];
      board[row][col] = '#';
      if (index == word.length() - 1
        || dfs(board, word, row - 1, col - 1, index + 1) || dfs(board, word, row - 1, col, index + 1)
        || dfs(board, word, row - 1, col + 1, index + 1) || dfs(board, word, row, col - 1, index + 1)
        || dfs(board, word, row, col + 1, index + 1) || dfs(board, word, row + 1, col - 1, index + 1)
        || dfs(board, word, row + 1, col, index + 1) || dfs(board, word, row + 1, col + 1, index + 1)) return true;
      board[row][col] = temp;
    }
    return false;
  }
}
