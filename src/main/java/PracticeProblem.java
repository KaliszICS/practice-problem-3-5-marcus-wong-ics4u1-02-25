public class PracticeProblem {

	public static void main(String args[]) {

	}
	public static int searchMazeMoves(String[][] arr) {
		int curRow = arr.length - 1;
		int curCol = 0;
		return dfsMoves(arr, curRow, curCol, 0);
	}
	public static int dfsMoves(String[][] arr, int row, int col, int moves) {
		if (row < 0 || col >= arr[0].length) {
			return -1;
		}
		if (arr[row][col].equals("F")) {
			return moves;
		}
		int right = dfsMoves(arr, row, col + 1, moves + 1);
		int up = dfsMoves(arr, row - 1, col, moves + 1);
		if (right == -1 && up == -1) {
			return -1;
		}
		if (right == -1) return up;
		if (up == -1) return right;
		return Math.min(right, up);
	}
	public static int noOfPaths(String[][] arr) {
		int startRow = arr.length - 1;
		int startCol = 0;
		return dfsPaths(arr, startRow, startCol);
	}
	public static int dfsPaths(String[][] arr, int row, int col) {
		if (row < 0 || col >= arr[0].length) {
			return 0;
		}
		if (arr[row][col].equals("F")) {
			return 1;
		}
		int right = dfsPaths(arr, row, col + 1);
		int up = dfsPaths(arr, row - 1, col);

		return right + up;
	}

	

}
