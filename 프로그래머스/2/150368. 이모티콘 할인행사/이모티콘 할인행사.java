class Solution {
    int maxJoin, maxBuy; // 가입자 수, 매출액
    int[] percent = {10, 20, 30, 40};
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        
        dfs(0, new int[emoticons.length], users, emoticons);
        
        answer[0] = maxJoin;
        answer[1] = maxBuy;
        return answer;
    }
    
    public void dfs(int depth, int[] result, int[][] users, int[] emoticons) {
        if (depth == emoticons.length) {
            // 뽑은 할인율가지고 계산
            int join = 0;
            int totalBuy = 0;
            
            for (int[] user : users) {
                int buy = 0;
                
                for (int i = 0; i < emoticons.length; i++) {
                    int discount = result[i];
                    
                    if (discount >= user[0]) { // 구매 가능
                        buy += emoticons[i] * ((100 - discount) / 100.0);
                    }
                    
                    if (buy >= user[1]) { // 가입
                        buy = 0;
                        join++;
                        break;
                    }
                }
                
                totalBuy += buy;
            }
            
            if (maxJoin < join) {
                maxJoin = join;
                maxBuy = totalBuy;
            } else if (maxJoin == join) {
                if (maxBuy < totalBuy) {
                    maxBuy = totalBuy;
                }
            }
            return;
        }
        
        for (int i = 0; i < percent.length; i++) {
            result[depth] = percent[i];
            dfs(depth + 1, result, users, emoticons);
        }
    }
}