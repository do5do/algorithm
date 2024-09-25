import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for (int i = 0; i < places.length; i++) {
            answer[i] = bfs(places[i]);
        }
        return answer;
    }
    
    public int bfs(String[] place) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (place[i].charAt(j) == 'P') {
                    list.add(new int[] {i, j, 0});
                }
            }
        }
        
        for (int[] p : list) {
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(p);
            boolean[][] visited = new boolean[5][5];
            visited[p[0]][p[1]] = true;
            
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];
                    int next = cur[2] + 1;

                    if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                        if (!visited[nx][ny] && place[nx].charAt(ny) != 'X') {
                            if (place[nx].charAt(ny) == 'P' && next <= 2) {
                                return 0;
                            }
                            
                            visited[nx][ny] = true;
                            queue.offer(new int[] {nx, ny, next}); 
                        }
                    }
                }
            }
        }
        
        return 1;
    }
}