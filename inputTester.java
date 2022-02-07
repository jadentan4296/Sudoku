import java.lang.reflect.Array;
import java.util.*;

public class inputTester {
    
    public static void main(String[] args) {

        int[][] board = new int[9][9];
        for(int n=0; n<9; n++) {
            createBoard(board, n); 
        }
        System.out.println(Arrays.deepToString(board));
    }

    private static void createBoard(int[][] board, int n) {
        Scanner scn = new Scanner(System.in);

        String stringList[] = scn.nextLine().split(" ");
        for(int i=0 ; i < stringList.length; i++){
            board[n][i] = (Integer.parseInt(stringList[i]));
        }
    }
}