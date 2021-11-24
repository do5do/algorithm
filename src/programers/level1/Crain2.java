package programers.level1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Crain2 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> result = new Stack<>();

        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][move - 1] != 0) {
                    if (result.isEmpty()) {
                        result.add(board[i][move - 1]);
                    } else {
                        if (board[i][move - 1] == result.peek()) {
                            result.pop();
                            answer += 2;
                        } else {
                            result.add(board[i][move - 1]);
                        }
                    }
                    board[i][move - 1] = 0;
                    break;
                }
            }
        }

        System.out.println(result);
        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
//        int[][] board = {{0, 0, 0, 0, 0},
//        {0, 0, 1, 0, 3},
//        {0, 2, 5, 0, 1},
//        {4, 2, 4, 4, 2},
//        {3, 5, 1, 3, 1}};
//        int[] moves = {1, 5, 3, 5, 1, 2, 2, 1, 4};

        Crain2 c = new Crain2();
        System.out.println(c.solution(board, moves));
    }
}
