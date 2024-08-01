class Solution {
    int[] answer = new int[2];
    
    public int[] solution(String[] park, String[] routes) {
        int n = park.length;
        int m = park[0].length();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = park[i].charAt(j);
                
                if (c == 'S') {
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
        }
        
        for (String route : routes) {
            String[] r = route.split(" ");
            String direct = r[0];
            int step = Integer.parseInt(r[1]);
            
            move(direct, step, n, m, park);
        }
        return answer;
    }
    
    public boolean move(String direct, int step, int n, int m, String[] park) {
        int nx = answer[0];
        int ny = answer[1];
        
        while (step > 0) {
            step--;
            
            if (direct.equals("E")) {
                ny += 1;
            } else if (direct.equals("S")) {
                nx += 1;
            } else if (direct.equals("W")) {
                ny -= 1;
            } else {
                nx -= 1;
            }

            if (nx < 0 || nx > n - 1 || ny < 0 || ny > m - 1) {
                return false;
            }
            
            if (park[nx].charAt(ny) == 'X') {
                return false;
            }
        }
        
        answer[0] = nx;
        answer[1] = ny;
        return true;
    }
}