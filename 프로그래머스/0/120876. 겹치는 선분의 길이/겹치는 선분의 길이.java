import java.util.*;

class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] line : lines) {
            for (int i = line[0]; i < line[1]; i++) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        
        for (int val : map.values()) {
            if (val >= 2) {
                answer++;
            }
        }
        return answer;
    }
}