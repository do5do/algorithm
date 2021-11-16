package programers.level1;

import java.util.*;

public class Crain {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<LinkedList<Integer>> list = new ArrayList<>();
        LinkedList<Integer> result = new LinkedList<>();

        for (int i = 0; i < board.length; i++) { // list 생성
            LinkedList<Integer> ll = new LinkedList<>();
            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i] != 0) {
                    ll.add(board[j][i]);
                }
            }
            list.add(ll);
        }

//        for (LinkedList<Integer> li : list) { // 확인
//            System.out.println(li);
//        }

        for (int i = 0; i < moves.length; i++) {
            if (!list.get(moves[i] - 1).isEmpty()) {
                int num = list.get(moves[i] - 1).get(0);
                list.get(moves[i] - 1).remove();

                if (!result.isEmpty() && num == result.get(result.size() - 1)) {
                    result.remove(result.size() - 1);
                    answer += 2;
                } else {
                    result.add(num);
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

        Crain c = new Crain();
        System.out.println(c.solution(board, moves));
    }
}
