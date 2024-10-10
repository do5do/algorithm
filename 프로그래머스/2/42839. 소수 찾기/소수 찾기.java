import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    boolean[] visited;
    
    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        
        // 순열
        for (int i = 1; i <= numbers.length(); i++) {
            dfs(0, i, "", numbers);
        }
        
        // 소수 찾기
        for (int num : set) {
            if (isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }
    
    public boolean isPrime(int num) {
        if (num == 0 || num == 1) {
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
            set.add(Integer.parseInt(str));
            return;
        }
        
        if (depth == numbers.length()) {
            return;
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, r, str + numbers.charAt(i), numbers);
                visited[i] = false;
            }
        }
    }
}