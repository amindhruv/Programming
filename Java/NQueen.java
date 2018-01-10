public class NQueen {
	public List<List<String>> solveNQueens(int n) {
		char[][] board = new char[n][n];
		for (int row = 0; row < n; row++)
			for (int column = 0; column < board[row].length; column++)
				board[row][column] = '.';
		List<List<String>> results = new ArrayList<>();
		helper(board, 0, results);
		return results;
	}

	private void helper(char[][] board, int row, List<List<String>> results) {
		if (row == board.length) {
			results.add(construct(board));
			return;
		}
		for (int column = 0; column < board[row].length; column++) {
			if (validate(board, row, column)) {
				board[row][column] = 'Q';
				helper(board, row + 1, results);
				board[row][column] = '.';
			}
		}
	}

	private boolean validate(char[][] board, int r, int c) {
		for (int row = 0; row < r; row++)
			for (int column = 0; column < board[row].length; column++)
				if (board[row][column] == 'Q' && (column == c || row - column == r - c || row + column == r + c)) return false;
		return true;
	}

	private List<String> construct(char[][] board) {
		List<String> result = new ArrayList<>();
		for (int row = 0; row < board.length; row++)
			result.add(new String(board[row]));
		return result;
	}

	public static void main(String[] args) {
		NQueen nQueen = new NQueen();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter length of board: ");
		int n = sc.nextInt();
		System.out.println("Results: " + nQueen.solveNQueens(n));
		sc.close();
	}
}
