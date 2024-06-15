class Solution {
    int[] rates = new int[] {10, 20, 30, 40}; // 중복 가능
    int maxTotal = 0;
    int maxJoin = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        dfs(0, emoticons, new int[emoticons.length], users);
        return new int[] {maxJoin, maxTotal};
    }
    
    public void dfs(int depth, int[] emoticons, int[] result, int[][] users) {
        if (depth == emoticons.length) {
            int[] answer = check(result, emoticons, users); // (1000, 0), (9000, 1)
            int join = answer[1];
            int total = answer[0];
            
            if (maxJoin < join) {
                maxJoin = join;
                maxTotal = total;
            } else if (maxJoin == join) {
                if (maxTotal < total) {
                    maxJoin = join;
                    maxTotal = total;
                }
            }
            return;
        }
        
        for (int i = 0; i < rates.length; i++) {
            result[depth] = rates[i];
            dfs(depth + 1, emoticons, result, users);
        }
    }
    
    public int[] check(int[] result, int[] emoticons, int[][] users) {
        int total = 0; // 모든 유저의 구매 가격
        int join = 0;
        
        for (int[] user : users) {
            int price = 0; // 유저별 총 구매 가격
            
            for (int i = 0; i < result.length; i++) {
                if (user[0] <= result[i]) { // 구매
                    price += emoticons[i] * (1 - (result[i] / 100.0));
                }
                
                if (price >= user[1]) {
                    price = 0;
                    join++;
                    break;
                }
            }
            
            total += price;
        }
        
        return new int[] {total, join};
    }
}