class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for (int i = 0; i < quiz.length; i++) {
            String[] split = quiz[i].split(" ");
            
            int a = getNum(split[0]);
            String operator = split[1];
            int b = getNum(split[2]);
            int result = getNum(split[4]);
            
            if (operator.equals("+")) {
                if (a + b == result) {
                    answer[i] = "O";
                    continue;
                }
            } else {
                if (a - b == result) {
                    answer[i] = "O";
                    continue;
                }
            }
            
            answer[i] = "X";
        }
        return answer;
    }
    
    public int getNum(String num) {
        return Integer.parseInt(num);
    }
}