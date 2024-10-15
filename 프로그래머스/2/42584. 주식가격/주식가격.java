import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            answer[i] = prices.length - i - 1;
        }
        
        Stack<int[]> stack = new Stack<>();
        
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && stack.peek()[0] > prices[i]) { // 주식이 떨어진 시점
                int[] cur = stack.pop();
                answer[cur[1]] = i - cur[1];
            }
            
            stack.push(new int[] {prices[i], i});
        }
        return answer;
    }
}