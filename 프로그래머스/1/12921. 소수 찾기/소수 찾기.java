class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] prime = new int[1000001];
        prime[0] = prime[1] = -1;
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (prime[i] == -1) {
                continue;
            }
            
            for (int j = i + i; j <= n; j += i) {
                prime[j] = -1;
            }
        }
        
        for (int i = 2; i <= n; i++) {
            if (prime[i] != -1) {
                answer++;
            }
        }
        return answer;
    }
}