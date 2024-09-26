import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int a : tangerine) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        
        List<Integer> cntList = map.values().stream()
            .collect(Collectors.toList());
        
        Collections.sort(cntList, Collections.reverseOrder());
        
        int totalCnt = 0;
        for (int cnt : cntList) {
            totalCnt += cnt;
            answer++;
            
            if (totalCnt >= k) {
                break;
            }
        }
        return answer;
    }
}