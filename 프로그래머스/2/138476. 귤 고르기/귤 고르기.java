import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        // 개수를 구해야한다. value를 내림차순 정렬한다.
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : tangerine) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        
        List<Integer> cntList = map.values().stream()
            .collect(Collectors.toList());
        
        Collections.sort(cntList, Collections.reverseOrder());
        
        int totalCnt = 0;
        for (Integer cnt : cntList) {
            if (totalCnt + cnt >= k) {
                answer++;
                break;
            }
            
            totalCnt += cnt;
            answer++;
        }
        return answer;
    }
}