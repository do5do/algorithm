class Solution {
    char[] member = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    boolean[] visited = new boolean[8];
    int answer;
    
    public int solution(int n, String[] data) {
        dfs(0, new char[8], data);
        return answer;
    }
    
    public void dfs(int depth, char[] result, String[] data) {
        if (depth == member.length) {
            for (String d : data) {
                char a = d.charAt(0);
                char b = d.charAt(2);
                char mark = d.charAt(3);
                int num = d.charAt(4) - '0';
                int aIdx = 0;
                int bIdx = 0;
                
                for (int i = 0; i < result.length; i++) {
                    if (result[i] == a) {
                        aIdx = i;
                    } else if (result[i] == b) {
                        bIdx = i;
                    }
                }
                
                int diff = Math.abs(aIdx - bIdx) - 1;
                if (mark == '=') {
                    if (diff != num) {
                        return;
                    }
                } else if (mark == '>') {
                    if (diff <= num) {
                        return;
                    }
                } else {
                    if (diff >= num) {
                        return;
                    }
                }
            }
            answer++;
            return;
        }
        
        for (int i = 0; i < member.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = member[i];
                dfs(depth + 1, result, data);
                visited[i] = false;
            }
        }
    }
}