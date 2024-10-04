import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    boolean[] visited;
    
    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        
        for (int i = 1; i <= numbers.length(); i++) {
            dfs(0, i, "", numbers);
        }
        
        for (int num : set) {
            if (isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }
    
    public boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    public void dfs(int depth, int r, String str, String numbers) {
        if (depth == r) {
            int num = Integer.parseInt(str);
            
            if (!set.contains(num)) {
                set.add(num);
            }
            return;
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                str += numbers.charAt(i);
                dfs(depth + 1, r, str, numbers);
                
                visited[i] = false;
                str = str.substring(0, str.length() - 1);
            }
        }
    }
}