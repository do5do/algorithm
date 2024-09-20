class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliverBox = 0;
        int pickupBox = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            if (deliveries[i] > 0 || pickups[i] > 0) {
                int visit = 0;
                
                while (deliverBox < deliveries[i] || pickupBox < pickups[i]) {
                    visit++;
                    deliverBox += cap;
                    pickupBox += cap;
                }
                
                deliverBox -= deliveries[i];
                pickupBox -= pickups[i];
                
                answer += (i + 1) * 2 * visit;
            }
        }
        
        return answer;
    }
}