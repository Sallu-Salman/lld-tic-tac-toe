package model;

public class GameBoard {
    Piece[][] board;
    private int n;

    public GameBoard(int n) {
        board = new Piece[n][n];
        this.n = n;
    }

    public boolean assignPiece(Piece piece, int i, int j) {
        if(board[i][j] == null) {
            board[i][j] = piece;
            return true;
        }
        return false;
    }

    public boolean hasSpace() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public void display() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] != null) {
                    System.out.print(board[i][j].getType());
                }
                else {
                    System.out.print(" ");
                }
                System.out.print("|");
            }
            System.out.println();
        }
    }

    public boolean hasWinningPosition(int x, int y) {
        return checkVerticalLine(x, y)
                || checkHorizontalLine(x, y)
                || checkLeftDiagonal(x, y)
                || checkRightDiagonal(x, y);
    }

    private boolean checkHorizontalLine(int x, int y) {
        for(int i = 0; i < n; i++) {
            if(board[x][i] == null || board[x][i].getType() != board[x][y].getType()) {
                return false;
            }
        }
        return true;
    }

    private boolean checkVerticalLine(int x, int y) {
        for(int i = 0; i < n; i++) {
            if(board[i][y] == null || board[i][y].getType() != board[x][y].getType()) {
                return false;
            }
        }
        return true;
    }

    private boolean checkLeftDiagonal(int x, int y) {
        for(int i = 0; i < n; i++) {
            if(board[i][i] == null || board[i][i].getType() != board[x][y].getType()) {
                return false;
            }
        }

        return true;
    }

    private boolean checkRightDiagonal(int x, int y) {
        int k = n - 1;
        for(int i = 0; i < n; i++) {
            if(board[i][k-i] == null || board[i][k-i].getType() != board[x][y].getType()) {
                return false;
            }
        }
        return true;
    }
}











