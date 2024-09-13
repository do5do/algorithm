import java.util.*;

class Solution {
    int[] result;
    boolean[] visited;
    int[] answer;
    int maxDiff = 0;
    
    public int[] solution(int n, int[] info) {
        answer = new int[info.length];
        visited = new boolean[info.length];
        result = new int[info.length];
        
        dfs(0, n, info);
        
        if (maxDiff == 0) {
            return new int[] {-1};
        }
        return answer;
    }
    
    public void dfs(int depth, int n, int[] info) {
        if (depth == info.length || n == 0) {
            int lion = 0;
            int apeach = 0;
            
            for (int i = 0; i < info.length; i++) {
                if (info[i] < result[i]) {
                    lion += (10 - i);
                } else {
                    if (info[i] != 0) {
                        apeach += (10 - i);    
                    }
                }
            }
            
            if (lion > apeach) {
                int diff = lion - apeach;
                
                if (maxDiff < diff) {
                    maxDiff = diff;
                    answer = Arrays.copyOf(result, result.length);
                } else if (maxDiff == diff) {
                    for (int i = answer.length - 1; i >= 0; i--) {
                        if (answer[i] < result[i]) {
                            maxDiff = diff;
                            answer = Arrays.copyOf(result, result.length);
                            break;
                        } else if (answer[i] > result[i]) {
                            break;
                        }
                    }
                }
            }
            return;
        }
        
        for (int i = n; i >= 0; i--) {
            if (!visited[depth]) {
                visited[depth] = true;
                result[depth] = i;
                dfs(depth + 1, n - i, info);
                visited[depth] = false;
            }
        }
    }
}