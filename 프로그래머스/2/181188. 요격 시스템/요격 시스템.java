import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (x, y) -> x[1] - y[1]);
        int now = 0;
        
        for (int[] target : targets) {
            if (target[0] >= now) {
                answer++;
                now = target[1];
            }
        }
        return answer;
    }
}