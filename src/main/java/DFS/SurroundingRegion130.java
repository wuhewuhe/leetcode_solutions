package DFS;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author mac 130. Surrounded Regions Medium
 * 
 *         2223
 * 
 *         718
 * 
 *         Add to List
 * 
 *         Share Given a 2D board containing 'X' and 'O' (the letter O), capture
 *         all regions surrounded by 'X'.
 * 
 *         A region is captured by flipping all 'O's into 'X's in that
 *         surrounded region.
 * 
 *         Example:
 * 
 *         X X X X X O O X X X O X X O X X After running your function, the
 *         board should be:
 * 
 *         X X X X X X X X X X X X X O X X Explanation:
 * 
 *         Surrounded regions shouldn’t be on the border, which means that any
 *         'O' on the border of the board are not flipped to 'X'. Any 'O' that
 *         is not on the border and it is not connected to an 'O' on the border
 *         will be flipped to 'X'. Two cells are connected if they are adjacent
 *         cells connected horizontally or vertically.
 * 
 * 
 */
public class SurroundingRegion130 {
	public void solve(char[][] board) {
		// corner case
		if (board.length == 0 || board[0].length == 0)
			return;
		if (board.length < 2 || board[0].length < 2)
			return;
		for (int i = 0; i < board.length; i++) {
			if (board[i][0] == 'O')
				dfs(board, i, 0);
			if (board[i][board[0].length - 1] == 'O')
				dfs(board, i, board[0].length - 1);
		}
		for (int i = 0; i < board[0].length; i++) {
			if (board[0][i] == 'O')
				dfs(board, 0, i);
			if (board[board.length - 1][i] == 'O')
				dfs(board, board.length - 1, i);
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'A')
					board[i][j] = 'O';
				else if (board[i][j] == 'O')
					board[i][j] = 'X';
			}
		}
		System.out.println(Arrays.deepToString(board));

	}

	private void dfs(char[][] board, int i, int j) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O')
			return;
		board[i][j] = 'A';
		dfs(board, i + 1, j);
		dfs(board, i - 1, j);
		dfs(board, i, j + 1);
		dfs(board, i, j - 1);
	}

	@Test
	public void test() {
		char[][] board = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };
		solve(board);
	}
}
