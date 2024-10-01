class Solution {
    char[][] matrix;
    boolean[][] check;
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        matrix = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = board[i].charAt(j);
            }
        }

        while (true) {
            step(m, n);
            int cnt = count(m, n);
            if (cnt == 0) {
                break;
            }
            answer += cnt;
            
            // 보드판 정리
            for (int i = m - 1; i >= 1; i--) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '-') {
                        // 최상단까지 탐색
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

        return answer;
    }

    public int count(int m, int n) {
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (check[i][j]) {
                    cnt++;
                    matrix[i][j] = '-';
                }
            }
        }
        return cnt;
    }

    public void step(int m, int n) {
        check = new boolean[m][n];

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (matrix[i][j] == '-') {
                    continue;
                }
                
                if (matrix[i][j] == matrix[i + 1][j]
                        && matrix[i + 1][j] == matrix[i][j + 1]
                        && matrix[i][j + 1] == matrix[i + 1][j + 1]) {
                    check[i + 1][j] = true;
                    check[i][j + 1] = true;
                    check[i + 1][j + 1] = true;
                    check[i][j] = true;
                }
            }
        }
    }
}