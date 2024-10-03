import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            answer[i] = prices.length - i - 1;
        }
        Stack<Integer> stack = new Stack<>(); // index 입력
        
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                answer[stack.peek()] = i - stack.pop(); // 현재 감소 시점 - 주식 시작 시점
            }
            
            stack.push(i);
        }
        
        return answer;
    }
}