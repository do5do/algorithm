class Solution {
    public int[] solution(String myString) {
        int[] answer = {};
        String[] split = myString.split("x");

        if (myString.charAt(myString.length() - 1) == 'x') {
            answer = new int[split.length + 1];
        } else {
            answer = new int[split.length];
        }

        for (int i = 0; i < split.length; i++) {
            answer[i] = split[i].length();
        }
        return answer;
    }
}