package programers.level1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Crain2 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> result = new Stack<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i] != 0) {

                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}};
//        int[][] board = {{0, 0, 0, 0, 0},
//        {0, 0, 1, 0, 3},
//        {0, 2, 5, 0, 1},
//        {4, 2, 4, 4, 2},
//        {3, 5, 1, 3, 1}};
        int[] moves = {1,5,3,5,1,2,1,4};
//        int[] moves = {1, 5, 3, 5, 1, 2, 2, 1, 4};

        Crain2 c = new Crain2();
        System.out.println(c.solution(board, moves));
    }
}
