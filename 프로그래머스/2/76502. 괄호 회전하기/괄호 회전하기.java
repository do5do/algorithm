import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        
        while (len > 0) {
            len--;
            boolean flag = true;
            
            for (int i = 0; i < sb.length(); i++) {
                char c = sb.charAt(i);
                
                if (c == '{' || c == '[' || c == '(') {
                    stack.push(c);
                } else {
                    if (!stack.isEmpty()) {
                        if (c == '}') {
                            if (stack.peek() == '{') {
                                stack.pop();
                            }
                        } else if (c == ']') {
                            if (stack.peek() == '[') {
                                stack.pop();
                            }
                        } else {
                            if (stack.peek() == '(') {
                                stack.pop();
                            }
                        }
                    } else {
                        flag = false;
                        break;
                    } 
                }             
            }
            
            if (stack.isEmpty() && flag) {
                answer++;
            }
            
            // 회전
            char first = sb.charAt(0);
            String str = sb.substring(1);
            sb.setLength(0);
            sb.append(str).append(first);

            stack.clear();
        }
        return answer;
    }
}