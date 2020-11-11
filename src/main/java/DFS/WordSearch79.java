package DFS;

import org.junit.Test;

/**
 * @author mac Given a 2D board and a word, find if the word exists in the grid.
 * 
 *         The word can be constructed from letters of sequentially adjacent
 *         cells, where 'adjacent' cells are horizontally or vertically
 *         neighboring. The same letter cell may not be used more than once.
 * 
 * 
 *         Input: board =
 *         [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word =
 *         'ABCCED' Output: true
 * 
 *         Input: board =
 *         [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 'SEE'
 *         Output: true
 * 
 *         Input: board =
 *         [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word =
 *         'ABCB' Output: false
 */
public class WordSearch79 {
	public boolean exist(char[][] board, String word) {
		if (word == null || board == null)
			return false;
		boolean[][] used = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (dfsHelper(board, used, i, j, word.toCharArray(), 0))
					return true;
			}
		}
		return false;
	}

	private boolean dfsHelper(char[][] board, boolean[][] used, int row, int col, char[] word, int index) {
		// find word
		if (index == word.length)
			return true;
		// out of bond
		if (row < 0 || row >= board.length || col < 0 || col >= board[0].length)
			return false;
		// avoid back ward
		if (used[row][col])
			return false;
		// can not find correct letter; a c b : a c e
		if (board[row][col] != word[index])
			return false;
		used[row][col] = true;
		if (dfsHelper(board, used, row, col + 1, word, index + 1))
			return true;
		if (dfsHelper(board, used, row, col - 1, word, index + 1))
			return true;
		if (dfsHelper(board, used, row + 1, col, word, index + 1))
			return true;
		if (dfsHelper(board, used, row - 1, col, word, index + 1))
			return true;

		// this point can not be start
		used[row][col] = false;
		return false;
	}

	private boolean dfsHelper1(char[][] board, boolean[][] used, int row, int col, char[] word, int index) {
		// find word
		if (index == word.length)
			return true;
		// out of bond
		if (row < 0 || row >= board.length || col < 0 || col >= board[0].length)
			return false;
		// avoid back ward
		if (used[row][col])
			return false;
		// can not find correct letter; a c b : a c e
		if (board[row][col] != word[index])
			return false;
		used[row][col] = true;
		if (dfsHelper(board, used, row, col + 1, word, index + 1)
				|| dfsHelper(board, used, row, col - 1, word, index + 1)
				|| dfsHelper(board, used, row + 1, col, word, index + 1)
				|| dfsHelper(board, used, row - 1, col, word, index + 1))
			return true;

		// this point can not be start
		used[row][col] = false;
		return false;
	}

	@Test
	public void test() {
		char[][] board = { { 'C', 'A', 'A' }, { 'A', 'A', 'A'}, { 'B', 'C', 'D' } };
		String word = "AAB";
		System.out.println(exist(board, word));
	}
}
