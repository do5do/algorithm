import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> map = new HashMap<>();
        
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                
                if (map.containsKey(c)) {
                    map.put(c, Math.min(map.get(c), i + 1));
                } else {
                    map.put(c, i + 1);
                }
            }
        }
        
        out: for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int cnt = 0;
            
            for (int j = 0; j < target.length(); j++) {
                char c = target.charAt(j);
                
                if (map.containsKey(c)) {
                    cnt += map.get(c);
                } else {
                    answer[i] = -1;
                    continue out;
                }
            }
            
            answer[i] = cnt;
        }
        return answer;
    }
}