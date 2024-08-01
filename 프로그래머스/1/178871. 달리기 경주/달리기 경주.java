import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for (String calling : callings) {
            int curIdx = map.get(calling);
            int prevIdx = curIdx - 1;
            
            map.put(calling, prevIdx);
            map.put(players[prevIdx], curIdx);
            
            String temp = players[curIdx];
            players[curIdx] = players[prevIdx];
            players[prevIdx] = temp;
        }
        
        return players;
    }
}