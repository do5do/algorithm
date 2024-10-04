class Solution {    
    public String solution(String number, int k) {
        char[] arr = number.toCharArray();
        int start = 0;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < number.length() - k; i++) { // 뽑아야할 수만큼 반복
            char max = '0';
            for (int j = start; j <= k + i; j++) { // 뒤에 뽑아야할 수 - 1개 만큼은 남겨둔다.
                if (max < arr[j]) {
                    max = arr[j];
                    start = j + 1;
                }
            }
            sb.append(max);
        }
        
        return sb.toString();
    }
}