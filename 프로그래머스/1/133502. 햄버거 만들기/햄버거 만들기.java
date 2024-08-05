import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        String target = "1321";
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for (int num : ingredient) {
            stack.push(num);
            
            if (stack.size() >= 4 && stack.peek() == 1) {
                for (int i = stack.size() - 1; i >= stack.size() - 4; i--) {
                    sb.append(stack.get(i));
                }

                if (sb.toString().equals(target)) {
                    answer++;
                    for (int i = 0; i < 4; i++) {
                        stack.pop();
                    }
                }
                sb.setLength(0);
            }
        }
        return answer;
    }
}