class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] matrix = new int[rows][columns];
        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = num++;
            }
        }
        
        int idx = 0;
        for (int[] query : queries) {
            int x1 = query[0] - 1;
            int y1 = query[1] - 1;
            int x2 = query[2] - 1;
            int y2 = query[3] - 1;
            
            int temp = matrix[x1][y2];
            int min = temp;
            
            // 오른쪽 이동
            for (int i = y2; i > y1; i--) {
                min = Math.min(min, matrix[x1][i - 1]);
                matrix[x1][i] = matrix[x1][i - 1];
            }
            
            // 위로 이동
            for (int i = x1; i < x2; i++) {
                min = Math.min(min, matrix[i + 1][y1]);
                matrix[i][y1] = matrix[i + 1][y1];
            }
            
            // 왼쪽 이동
            for (int i = y1; i < y2; i++) {
                min = Math.min(min, matrix[x2][i + 1]);
                matrix[x2][i] = matrix[x2][i + 1];
            }
            
            // 아래로 이동
            for (int i = x2; i > x1; i--) {
                min = Math.min(min, matrix[i - 1][y2]);
                matrix[i][y2] = matrix[i - 1][y2];
            }
            
            matrix[x1 + 1][y2] = temp;
            answer[idx++] = min;
        }
        
        return answer;
    }
}