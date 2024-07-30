class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for (int i = 0; i < quiz.length; i++) {
            String[] arr = quiz[i].split(" ");
            int a = Integer.parseInt(arr[0]);
            String operator = arr[1];
            int b = Integer.parseInt(arr[2]);
            int result = Integer.parseInt(arr[4]);
            
            boolean flag = false;
            if (operator.equals("+")) {
                if (a + b == result) {
                    flag = true;
                }
            } else {
                if (a - b == result) {
                    flag = true;
                }
            }
            
            if (flag) {
                answer[i] = "O";
            } else {
                answer[i] = "X";
            }
        }
        return answer;
    }
}