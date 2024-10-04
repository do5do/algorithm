class Solution {
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return answer;
    }
    
    public void dfs(int depth, int num, int[] numbers, int target) {
        if (depth == numbers.length) {
            if (num == target) {
                answer++;
            }
            return;
        }
        
        // 현재 수를 더한다.
        dfs(depth + 1, num + numbers[depth], numbers, target);
        
        // 뺀다.
        dfs(depth + 1, num - numbers[depth], numbers, target);
    }
}