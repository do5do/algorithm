class Solution {
    public String solution(String new_id) {
        String answer = "";
        answer = new_id.toLowerCase().replaceAll("[^-_.\\w]", "");
        
        answer = answer.replaceAll("\\.{2,}", ".");
        
        if (answer.startsWith(".")) {
            answer = answer.substring(1);
        }
        
        if (answer.endsWith(".")) {
            answer = answer.substring(0, answer.length() - 1);
        }
        
        if (answer.isEmpty()) {
            answer = "a";
        } 
        
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            if (answer.endsWith(".")) {
                answer = answer.substring(0, answer.length() - 1);
            }
        } 
        
        if (answer.length() <= 2) {
            String lastWord = answer.charAt(answer.length() - 1) + "";
            while (answer.length() < 3) {
                answer += lastWord;
            }
        }
        
        return answer;
    }
}