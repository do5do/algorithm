import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int i = 0;
        int lastIdx = 0;
        
        while (i < s.length()) {
            char x = s.charAt(i);
            int xCnt = 0;
            int oCnt = 0;
            
            for (; i < s.length(); i++) {
                if (x == s.charAt(i)) {
                    xCnt++;
                } else {
                    oCnt++;
                }
                
                if (xCnt == oCnt) {
                    answer++;
                    lastIdx = ++i;
                    break;
                }
            }
        }
        
        if (lastIdx < s.length()) {
            answer++;
        }
        return answer;
    }
}