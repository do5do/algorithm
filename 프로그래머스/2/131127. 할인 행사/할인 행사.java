import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < 10; i++) {
            if (i > discount.length - 1) {
                break;
            }
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
        }
        
        int start = 0;
        int end = start + 10;
        
        while (true) {
            boolean canBuy = true;
            
            for (int i = 0; i < want.length; i++) {
                if (!map.containsKey(want[i]) || map.get(want[i]) < number[i]) {
                    canBuy = false;
                    break;
                }
            }

            if (canBuy) {
                answer++;
            }

            if (start > discount.length - 1) {
                break;
            }
            
            map.put(discount[start], map.get(discount[start]) - 1);
            start++;
            
            if (end < discount.length) {
                map.put(discount[end], map.getOrDefault(discount[end], 0) + 1);
                end++;
            }
        }
    
        return answer;
    }
}