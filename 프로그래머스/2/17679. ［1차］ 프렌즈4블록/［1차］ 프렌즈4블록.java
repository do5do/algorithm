class Solution {
    char[][] matrix;
    boolean[][] check;
    int answer = 0;
    
    public int solution(int m, int n, String[] board) {
        matrix = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = board[i].charAt(j);
            }
        }

        step(m, n);
        count(m, n);
        if (answer == 0) {
            return answer;
        }

        while (true) {
            // 보드판 정리
            for (int i = m - 1; i >= 1; i--) {
                for (int j = 0; j < n; j++) {
                    if (check[i][j]) {
                        for (int k = i - 1; k >= 0; k--) { // 최상단까지 탐색
                            if (matrix[k][j] != '-') {
                                matrix[i][j] = matrix[k][j];
                                matrix[k][j] = '-';
                                break;
                            }
                        }
                    }
                }
            }

            boolean isNext = step(m, n);
            count(m, n);
            
            if (!isNext) {
                break;
            }
        }

        return answer;
    }

    public void count(int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (check[i][j]) {
                    answer++;
                    matrix[i][j] = '-';
                }
            }
        }
    }

    public boolean step(int m, int n) {
        check = new boolean[m][n];
        boolean flag = false;

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (matrix[i][j] == '-') {
                    continue;
                }

                if (matrix[i][j] == matrix[i + 1][j]
                        && matrix[i + 1][j] == matrix[i][j + 1]
                        && matrix[i][j + 1] == matrix[i + 1][j + 1]) {
                    flag = true;
                    check[i + 1][j] = true;
                    check[i][j + 1] = true;
                    check[i + 1][j + 1] = true;
                    check[i][j] = true;
                }
            }
        }
        return flag;
    }
}