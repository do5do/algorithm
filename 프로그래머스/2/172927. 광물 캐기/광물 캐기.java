import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    int[] result;
    int[][] matrix;
    int[] intMineral;
    
    public int solution(int[] picks, String[] minerals) {
        result = new int[Arrays.stream(picks).sum()]; // 곡괭이 번호
        matrix = new int[][] {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        intMineral = new int[minerals.length];
        
        for (int i = 0; i < minerals.length; i++) {
            if (minerals[i].equals("diamond")) {
                intMineral[i] = 0;
            } else if (minerals[i].equals("iron")) {
                intMineral[i] = 1;
            } else {
                intMineral[i] = 2;
            }
        }
        
        dfs(0, picks);
        return answer;
    }
    
    public void dfs(int depth, int[] picks) {
        if (depth == result.length) {
            int idx = 0;
            int tired = 0;
            
            out: for (int i = 0; i < result.length; i++) { // 미네랄 캐기
                for (int j = 0; j < 5; j++) {
                    if (idx >= intMineral.length) {
                        break out;
                    }
                    
                    int mineral = intMineral[idx++];
                    tired += matrix[result[i]][mineral];
                }
            }
            
            answer = Math.min(answer, tired);
            return;
        }
        
        for (int i = 0; i < 3; i++) {
            if (picks[i] > 0) {
                result[depth] = i;
                picks[i]--;
                dfs(depth + 1, picks);
                picks[i]++;
            }
        }
    }
}