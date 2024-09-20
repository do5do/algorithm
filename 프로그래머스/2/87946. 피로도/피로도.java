class Solution {
    boolean[] visited;
    int maxCnt;
    int tired;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        tired = k;
        dfs(0, new int[dungeons.length], dungeons);
        return maxCnt;
    }
    
    public void dfs(int depth, int[] result, int[][] dungeons) {
        if (depth == dungeons.length) {
            int cnt = 0;
            int tired = this.tired;
            
            for (int re : result) {
                int requiredTired = dungeons[re][0];
                int useTired = dungeons[re][1];
                
                if (tired >= requiredTired) {
                    tired -= useTired;
                    cnt++;
                }
            }
            
            maxCnt = Math.max(maxCnt, cnt);
            return;
        }
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[i] = depth;
                dfs(depth + 1, result, dungeons);
                visited[i] = false;
            }
        }
    } 
}