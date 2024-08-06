import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        Map<Character, Integer> xMap = new HashMap<>();
        Map<Character, Integer> yMap = new HashMap<>();
        
        for (int i = 0; i < X.length(); i++) {
            char c = X.charAt(i);
            xMap.put(c, xMap.getOrDefault(c, 0) + 1);
        }
        
        for (int i = 0; i < Y.length(); i++) {
            char c = Y.charAt(i);
            yMap.put(c, yMap.getOrDefault(c, 0) + 1);
        }
        
        List<Character> list = new ArrayList<>();
        for (Character key : xMap.keySet()) {
            if (yMap.containsKey(key)) {
                int val = Math.min(xMap.get(key), yMap.get(key));
                for (int i = 0; i < val; i++) {
                    list.add(key);
                }
            }
        }
        
        if (list.isEmpty()) {
            return "-1";
        }
        
        Collections.sort(list, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (char a : list) {
            sb.append(a);
        }
        
        if (sb.toString().startsWith("0")) {
            return "0";
        }
        return sb.toString();
    }
}