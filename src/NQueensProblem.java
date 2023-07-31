public class NQueensProblem{

    private int boardSize;
    private int[] queensPosition;

    public NQueensProblem(int boardSize) {
        this.boardSize = boardSize;
        queensPosition = new int[boardSize];
    }

    public void solveNQueens() {
        if (placeQueens(0)) {
            printQueens();
        } else {
            System.out.println("No solution exists.");
        }
    }

    private boolean placeQueens(int row) {
        if (row == boardSize) {
            return true; // All queens have been successfully placed
        }

        for (int col = 0; col < boardSize; col++) {
            if (isSafe(row, col)) {
                queensPosition[row] = col; // Place queen in this position
                if (placeQueens(row + 1)) {
                    return true; // Continue placing queens in the next rows
                }
            }
        }

        return false; // Backtrack if no safe position is found for the current row
    }

    private boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queensPosition[i] == col || Math.abs(queensPosition[i] - col) == Math.abs(i - row)) {
                return false; // Check if the current position is safe from other queens
            }
        }
        return true;
    }

    private void printQueens() {
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                if (queensPosition[row] == col) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int boardSize = 8; // Change the board size for different N-Queens problems
        NQueensProblem nQueens = new NQueensProblem(boardSize);
        nQueens.solveNQueens();
    }
}
