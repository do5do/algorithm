import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Deque<String> deque = new ArrayDeque<>();
        Set<String> set = new HashSet<>();
        
        for (String city : cities) {
            String c = city.toLowerCase();
            
            if (cacheSize == 0) {
                answer += 5;
                continue;
            }
            
            if (set.contains(c)) {
                answer += 1;
                // 히트된 캐시의 위치를 가장 뒤로 옮겨준다.
                deque.remove(c);
                deque.offerLast(c);
            } else {
                if (set.size() == cacheSize) {
                    String str = deque.pollFirst(); // 가장 오래된 캐시 삭제
                    set.remove(str);
                }
                set.add(c);
                deque.offerLast(c);
                answer += 5;
            }
        }
        return answer;
    }
}