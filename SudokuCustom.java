//Easy Puzzle 1,257,120,825
//Medium Puzzle 7,789,014,161

import java.util.*;

public class SudokuCustom {
    public static void main(String[] args) {

        int[][] board = new int[9][9];

        for(int n=0; n<9; n++) {
            createBoard(board, n); 
        }

        if (result(board)) {
            System.out.println("Solved");
        } else {
            System.out.println("Unsolved");
        }

        printBoard(board);
    }

    private static void createBoard(int[][] board, int n) {
        Scanner scn = new Scanner(System.in);

        String stringList[] = scn.nextLine().split(" ");
        for(int i=0 ; i < stringList.length; i++){
            board[n][i] = (Integer.parseInt(stringList[i]));
        }
    }

    private static void printBoard(int[][] board) {
        for(int i=0; i<9; i++) {
            if(i%3==0){
                System.out.println("-----------");
            }
            for(int j=0; j<9; j++) {
                if(j%3==0 && j!=0){
                    System.out.print("|");
                }
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println("-----------");
    }

    private static boolean inRow(int[][] board, int number, int row){
        for(int i=0; i<9; i++){
            if(board[row][i]==number) {
                return true;
            }
        }
        return false;
    }

    private static boolean inColumn(int[][] board, int number, int column){
        for(int i=0; i<9; i++){
            if(board[i][column]==number) {
                return true;
            }
        }
        return false;
    }

    private static boolean inSquare(int[][] board, int number, int row, int column){
        int boxRowMin = row - row%3;
        int boxColumnMin = column - column%3;
        for(int i=boxRowMin; i<boxRowMin+3; i++) {
            for(int j=boxColumnMin; j<boxColumnMin+3; j++) {
                if(board[i][j]==number) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean canPlace(int[][] board, int number, int row, int column) {
        return !inRow(board, number, row) && 
                !inColumn(board, number, column) && 
                !inSquare(board, number, row, column);
    }

    private static boolean result(int[][] board) {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j]==0) {
                    for(int k=1; k<10; k++) {
                        if(canPlace(board, k, i, j)) {
                            board[i][j]=k;
                            if(result(board)) {
                                return true;
                            }
                            board[i][j]=0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}