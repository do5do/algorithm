import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] count = new int[n + 1];
        Arrays.fill(count, 1);
        
        for (int lo : lost) {
            count[lo]--;
        }
        
        for (int re : reserve) {
            count[re]++;
        }
        
        
        for (int i = 1; i <= n; i++) {
            if (count[i] == 0) { // lost
                if (count[i - 1] > 1) {
                    count[i] = 1;
                    count[i - 1]--;
                    continue;
                }
                
                if (i < n && count[i + 1] > 1) {
                    count[i] = 1;
                    count[i + 1]--;
                }
            }
        }
        
        for (int i = 1; i < count.length; i++) {
            if (count[i] > 0) {
                answer++;
            }
        }
        return answer;
    }
}