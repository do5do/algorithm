class Solution {
    int answer = 0;
    char[] names = new char[] {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    boolean[] visited = new boolean[8];
    
    public int solution(int n, String[] data) {
        dfs(8, 0, new char[8], data);
        return answer;
    }
    
    public void dfs(int n, int depth, char[] result, String[] data) {
        if (depth == n) {
            for (String d : data) {
                char a = d.charAt(0);
                char b = d.charAt(2);
                char mark = d.charAt(3);
                int val = d.charAt(4) - '0';
                
                int aIdx = -1;
                int bIdx = -1;
                for (int i = 0; i < n; i++) {
                    if (result[i] == a) {
                        aIdx = i;
                    }
                    
                    if (result[i] == b) {
                        bIdx = i;
                    }
                    
                    if (aIdx != -1 && bIdx != -1) {
                        break;
                    }
                }
                
                int diff = Math.abs(aIdx - bIdx) - 1;
                
                if (mark == '=') {
                    if (diff != val) {
                        return;
                    }
                } else if (mark == '<') {
                    if (diff >= val) {
                        return;
                    }
                } else {
                    if (diff <= val) {
                        return;
                    }
                }
            }
            answer++;
            return;
        }
        
        for (int i = 0; i < names.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = names[i];
                dfs(n, depth + 1, result, data);
                visited[i] = false;
            }
        }
    }
}