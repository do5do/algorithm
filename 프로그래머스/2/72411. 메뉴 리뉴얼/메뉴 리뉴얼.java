import java.util.*;

class Solution {
    Map<String, Integer> map;
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        for (int i = 0; i < orders.length; i++) {
            char[] chars = orders[i].toCharArray();
            Arrays.sort(chars);
            orders[i] = String.valueOf(chars);
        }
        
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < course.length; i++) {
            map = new HashMap<>();
            
            for (String order : orders) {
                if (course[i] <= order.length()) {
                    StringBuilder sb = new StringBuilder();
                    dfs(0, course[i], order, sb); // 조합을 구한다.
                }
            }
            
            int maxCount = 0;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                maxCount = Math.max(maxCount, entry.getValue());
            }
            
            if (maxCount < 2) {
                continue;
            }
            
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (maxCount == entry.getValue()) {
                    result.add(entry.getKey());
                }
            }
        }
        
        Collections.sort(result);
        answer = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
    
    public void dfs(int start, int r, String order, StringBuilder sb) {
        if (r == 0) {
            String key = sb.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
            return;
        }
        
        for (int i = start; i < order.length(); i++) {
            sb.append(order.charAt(i));
            dfs(i + 1, r - 1, order, sb);
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}