class Solution {
    public int[] solution(String myString) {
        int[] answer = {};
        String[] split = myString.split("x", myString.length());

        answer = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            answer[i] = split[i].length();
        }
        return answer;
    }
}