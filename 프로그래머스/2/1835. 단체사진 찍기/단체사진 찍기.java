class Solution {
    char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    boolean[] visited = new boolean[8];
    int answer;
    
    public int solution(int n, String[] data) {
        // 순열
        dfs(0, "", data);
        return answer;
    }
    
    public void dfs(int depth, String str, String[] data) {
        if (depth == friends.length) {            
            for (String d : data) {
                char a = d.charAt(0);
                char b = d.charAt(2);
                char op = d.charAt(3);
                int diff = d.charAt(4) - '0';
                
                int aIdx = str.indexOf(a);
                int bIdx = str.indexOf(b);
                int diffIdx = Math.abs(aIdx - bIdx) - 1;
                
                if (op == '=') {
                    if (diff != diffIdx) {
                        return;
                    }
                } else if (op == '>') {
                    if (diff >= diffIdx)  {
                        return;
                    }
                } else if (op == '<') {
                    if (diff <= diffIdx) {
                        return;
                    }
                }
            }
            
            answer++;
            return;
        }
        
        for (int i = 0; i < friends.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, str + friends[i], data);
                visited[i] = false;
            }
        }
    }
}