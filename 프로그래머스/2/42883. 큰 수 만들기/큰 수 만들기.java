class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        char max = '0';
        int maxIdx = 0;
        
        for (int i = 0; i < number.length() - k; i++) { // 찾아야하는 수 만큼 반복
            // 뒤에 찾아야하는 수 만큼 남겨두고 가장 큰 수를 찾는다.
            for (int j = maxIdx; j <= k + i; j++) {
                char c = number.charAt(j);
                if (c > max) {
                    max = c;
                    maxIdx = j + 1;
                }
            }
            sb.append(max);
            max = '0';
        }
        return sb.toString();
    }
}