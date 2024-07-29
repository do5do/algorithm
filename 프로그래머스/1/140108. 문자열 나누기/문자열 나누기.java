import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int cnt = 0;
        int x = s.charAt(0);
        
        for (int i = 0; i < s.length(); i++) {
            if (cnt == 0) {
                x = s.charAt(i);
            }
            
            if (x == s.charAt(i)) {
                cnt++;
            } else {
                cnt--;
            }
            
            if (cnt == 0) {
                answer++;
            }
        }
        
        if (cnt > 0) {
            answer++;
        }
        return answer;
    }
}