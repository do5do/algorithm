class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int num = 1;
        int i = 0;
        int j = 0;
        int direction = 0;

        while (num <= n * n) {
            answer[i][j] = num++;

            if (direction == 0) { // 오른쪽
                if (j == n - 1 || answer[i][j + 1] != 0) {
                    i++;
                    direction = 1;
                } else {
                    j++;
                }
            } else if (direction == 1) { // 아래
                if (i == n - 1 || answer[i + 1][j] != 0) {
                    j--;
                    direction = 2;
                } else {
                    i++;
                }
            } else if (direction == 2) { // 왼쪽
                if (j == 0 || answer[i][j - 1] != 0) {
                    i--;
                    direction = 3;
                } else {
                    j--;
                }
            } else { // 위
                if (i == 0 || answer[i - 1][j] != 0) {
                    j++;
                    direction = 0;
                } else {
                    i--;
                }
            }
        }
        return answer;
    }
}