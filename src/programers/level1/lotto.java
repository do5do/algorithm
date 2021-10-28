package programers.level1;

import programers.level1.Solution2;

import java.util.Arrays;
import java.util.List;

public class lotto {
    public static void main(String[] args) {
        int[] lottos = {0, 0, 0, 0, 0, 0};
        int[] win_nums = {38, 19, 20, 40, 15, 25};
        Solution2 s = new Solution2();
        s.solution(lottos, win_nums);
    }
}

class Solution2 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        int minMatch = 0;
        int maxMatch = 0;
        Integer[] score = {6, 5, 4, 3, 2}; // Integer라고 해야 indexOf() 사용 가능
        // Integer[] score = {6, 6, 5, 4, 3, 2, 1}; //

        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                maxMatch++;
            }
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[j] != 0 && win_nums[i] == lottos[j]) {
                    minMatch++;
                }
            }
        }
        maxMatch += minMatch;
        System.out.println("min : "+minMatch);
        System.out.println("max : "+maxMatch);

        answer[0] = Arrays.asList(score).indexOf(maxMatch) + 1;
        answer[1] = Arrays.asList(score).indexOf(minMatch) + 1;

        if (maxMatch < 2) {
            answer[0] = 6;
        } else if (minMatch < 2) {
            answer[1] = 6;
        }

        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
