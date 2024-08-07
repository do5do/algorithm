import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> countMap = new HashMap<>();
        Map<String, Set<String>> callMap = new HashMap<>();
        
        for (int i = 0; i < id_list.length; i++) {
            callMap.put(id_list[i], new HashSet<>());
        }
        
        for (String re : report) {
            String[] arr = re.split(" ");
            String name = arr[0];
            String call = arr[1];
            
            if (!callMap.get(name).contains(call)) {
                countMap.put(call, countMap.getOrDefault(call, 0) + 1);
            }
            callMap.get(name).add(call);
        }
        
        for (int i = 0; i < id_list.length; i++) {
            String name = id_list[i];
            int cnt = 0;
            
            for (String call : callMap.get(name)) {
                if (countMap.get(call) >= k) {
                    cnt++;
                }
            }
            
            answer[i] = cnt;
        }
        
        return answer;
    }
}