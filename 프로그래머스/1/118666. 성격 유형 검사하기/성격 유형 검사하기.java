import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        List<Map<Character, Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            matrix.add(new LinkedHashMap<>());
        }
        
        matrix.get(0).put('R', 0);
        matrix.get(0).put('T', 0);
        
        matrix.get(1).put('C', 0);
        matrix.get(1).put('F', 0);
        
        matrix.get(2).put('J', 0);
        matrix.get(2).put('M', 0);
        
        matrix.get(3).put('A', 0);
        matrix.get(3).put('N', 0);
        
        for (int i = 0; i < choices.length; i++) {
            int choice = choices[i];
            char c = ' ';
            int point = 0;
            
            if (choice > 4) {
                c = survey[i].charAt(1); // 동의
                
                if (choice == 5) {
                    point = 1;
                } else if (choice == 6) {
                    point = 2;
                } else {
                    point = 3;
                }
            } else if (choice < 4) {
                c = survey[i].charAt(0); // 비동의
                
                if (choice == 3) {
                    point = 1;
                } else if (choice == 2) {
                    point = 2;
                } else {
                    point = 3;
                }
            } else {
                continue;
            }
            
            for (Map<Character, Integer> map : matrix) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + point);
                    break;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (Map<Character, Integer> map : matrix) {
            char result = ' ';
            int max = -1;
            
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (max < entry.getValue()) {
                    max = entry.getValue();
                    result = entry.getKey();
                }
            }
            
            sb.append(result);
        }
        return sb.toString();
    }
}