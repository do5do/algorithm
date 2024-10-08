class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        
        if (board.length <= 1 || board[0].length <= 1) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 1) {
                        return 1;
                    }
                }
            }
        }
        
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                if (board[i][j] != 0) {
                    int min = Math.min(board[i - 1][j], board[i][j - 1]);
                    min = Math.min(board[i - 1][j - 1], min);
                    
                    board[i][j] = min + 1;
                    answer = Math.max(board[i][j], answer);
                }
            }
        }
        
        return answer * answer;
    }
}