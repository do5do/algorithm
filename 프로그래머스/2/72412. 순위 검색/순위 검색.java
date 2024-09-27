import java.util.*;

class Solution {
    Map<String, List<Integer>> map = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        for (int i = 0; i < info.length; i++) {
            String[] split = info[i].split(" ");
            dfs(0, split, "");
        }
        
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }
        
        for (int i = 0; i < query.length; i++) {
            String str = query[i].replaceAll(" and ", "");
            String[] split = str.split(" ");
            int cnt = 0;
            
            if (map.containsKey(split[0])) {
                cnt = binarySearch(split[0], Integer.parseInt(split[1]));
            }
            
            answer[i] = cnt;
        }
        
        return answer;
    }
    
    public int binarySearch(String key, int score) {
        List<Integer> scores = map.get(key);
        int start = 0;
        int end = scores.size() - 1;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            if (scores.get(mid) < score) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return scores.size() - start;
    }
    
    public void dfs(int depth, String[] arr, String key) {
        if (depth == 4) {
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            
            map.get(key).add(Integer.parseInt(arr[4]));
            return;
        }
        
        dfs(depth + 1, arr, key + "-");
        dfs(depth + 1, arr, key + arr[depth]);
    }
}