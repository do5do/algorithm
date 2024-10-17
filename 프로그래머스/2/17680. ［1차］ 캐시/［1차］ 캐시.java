import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Deque<String> deque = new ArrayDeque<>();
        Set<String> set = new HashSet<>();
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            
            if (deque.isEmpty()) {
                deque.offerLast(city);
                set.add(city);
                answer += 5;
            } else {            
                if (set.contains(city)) { // hit
                    answer += 1;
                    deque.remove(city);
                    deque.offerLast(city);
                    continue;
                }
                
                // miss
                answer += 5;
                
                if (set.size() == cacheSize) {
                    set.remove(deque.pollFirst());
                }
                
                deque.offerLast(city);
                set.add(city);
            }
        }
        return answer;
    }
}