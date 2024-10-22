class Solution {
    char[][] matrix;
    int m, n;
    boolean[][] check;
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        matrix = new char[m][n];
        this.m = m;
        this.n = n;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = board[i].charAt(j);
            }
        }
        
        while (true) {
            check = new boolean[m][n];
            
            checkBlock(); // 블록 확인
            int cnt = count(); // 지운 블록 개수
            if (cnt == 0) {
                break;
            }
            answer += cnt;
            
            move(); // 재배치
        }
        
        return answer;
    }
    
    public void move() {
        for (int i = m - 1; i > 0; i--) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '-') { // 맨 위까지 확인
                    for (int k = i - 1; k >= 0; k--) {
                        if (matrix[k][j] != '-') {
                            matrix[i][j] = matrix[k][j];
                            matrix[k][j] = '-';
                            break;
                        }
                    }
                }
            }
        }
    }
    
    public void checkBlock() {
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                int cur = matrix[i][j];
                if (cur == '-') {
                    continue;
                }
                
                int cnt = 1;
                
                if (matrix[i][j + 1] == cur) {
                    cnt++;
                }
                
                if (matrix[i + 1][j] == cur) {
                    cnt++;
                }
                
                if (matrix[i + 1][j + 1] == cur) {
                    cnt++;
                }
                
                if (cnt == 4) {
                    check[i][j] = true;
                    check[i][j + 1] = true;
                    check[i + 1][j] = true;
                    check[i + 1][j + 1] = true;
                }
            }
        }
    }
    
    public int count() {
        int cnt = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (check[i][j]) {
                    cnt++;
                    matrix[i][j] = '-'; // 지우기
                }
            }
        }
        
        return cnt;
    }
}