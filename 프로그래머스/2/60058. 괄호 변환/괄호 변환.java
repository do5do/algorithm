import java.util.*;

class Solution {
    public String solution(String p) {
        return dfs(p);
    }
    
    public String dfs(String p) {
        if (p.isEmpty()) {
            return p;
        }
        
        int endIdx = getSplitIdx(p);
        String u = p.substring(0, endIdx);
        String v = p.substring(endIdx);
        
        if (isCorrect(u)) {
            return u + dfs(v);
        }
        
        return "(" + dfs(v) + ")" + reverse(u);
    }
    
    public String reverse(String u) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i < u.length() - 1; i++) {
            char c = u.charAt(i);
            if (c == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }
        
        return sb.toString();
    }
    
    public int getSplitIdx(String p) {
        int open = 0;
        int close = 0;
        int idx = 0;
        
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            
            if (c == '(') {
                open++;
            } else {
                close++;
            }
            
            if (open == close) { // 같아지는 시점에 u, v로 분리
                idx = i + 1;
                break;
            }
        }
        
        return idx;
    }
    
    public boolean isCorrect(String p) {
        Stack<Character> stack = new Stack<>();
        boolean isCorrect = true;
        
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    isCorrect = false;
                    break;
                } else {
                    if (stack.peek() == '(') {
                        stack.pop();
                    }
                }
            }
        }
        
        if (stack.isEmpty() && isCorrect) { // 옳바른 괄호
            return true;
        }
        return false;
    }
}