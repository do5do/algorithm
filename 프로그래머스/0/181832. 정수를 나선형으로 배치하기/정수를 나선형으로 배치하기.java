class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int row = 0;
        int col = 0;
        int num = 1;
        int direction = 0;
        
        while (num <= n * n) {
            answer[row][col] = num++;
            
            if (direction == 0) {
                if (col == n - 1 || answer[row][col + 1] != 0) {
                    row++;
                    direction = 1;
                } else {
                    col++;
                }
            } else if (direction == 1) {
                if (row == n - 1 || answer[row + 1][col] != 0) {
                    col--;
                    direction = 2;
                } else {
                    row++;
                }
            } else if (direction == 2) {
                if (col == 0 || answer[row][col - 1] != 0) {
                    row--;
                    direction = 3;
                } else {
                    col--;
                }
            } else {
                if (row == 0 || answer[row - 1][col] != 0) {
                    col++;
                    direction = 0;
                } else {
                    row--;
                }
            }
        }
        
        return answer;
    }
}