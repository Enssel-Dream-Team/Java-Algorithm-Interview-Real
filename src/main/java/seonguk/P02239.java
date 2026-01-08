package seonguk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P02239 {

	static boolean flag = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] board = new int[9][9];
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			char[] arr = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				board[i][j] = arr[j] - '0';
				if (board[i][j] == 0) {
					list.add(new int[] { i, j });
				}
			}
		}

		Sudoku sudoku = new Sudoku(board);
		solve(sudoku, list, 0);
		br.close();
	}

	static void solve(Sudoku sudoku, List<int[]> list, int idx) {
		if (flag) {
			return;
		}

		if (idx == list.size()) {
			System.out.println(sudoku);
			flag = true;
			return;
		}

		int[] arr = list.get(idx);
		for (int i = 1; i < 10; i++) {
			if (sudoku.checkSquare(i, arr[0], arr[1])) {
				sudoku.setVal(i, arr[0], arr[1]);
				solve(sudoku, list, idx + 1);
				sudoku.reset(arr[0], arr[1]);
			}
		}
	}

	static class Sudoku {
		int[][] board;

		Sudoku(int[][] board) {
			this.board = board;
		}

		public void setVal(int val, int row, int col) {
			board[row][col] = val;
		}

		public void reset(int row, int col) {
			board[row][col] = 0;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(board[i][j]);
				}
				sb.append("\n");
			}
			return sb.toString();
		}

		private boolean checkSquare(int val, int row, int col) {
			return checkCol(val, col) && checkRow(val, row) && checkMiniBox(val, row, col);
		}

		private boolean checkCol(int val, int idx) {
			for (int i = 0; i < 9; i++) {
				if (board[i][idx] == val) {
					return false;
				}
			}
			return true;
		}

		private boolean checkRow(int val, int idx) {
			for (int i = 0; i < 9; i++) {
				if (board[idx][i] == val) {
					return false;
				}
			}
			return true;
		}

		private boolean checkMiniBox(int val, int row, int col) {
			int[] point = getCheckPoint(row, col);
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					int num = board[point[0] + i][point[1] + j];
					if (num == val) {
						return false;
					}
				}
			}
			return true;
		}

		private int[] getCheckPoint(int row, int col) {
			return new int[] {row / 3 * 3, col / 3 * 3};
		}
	}
}
