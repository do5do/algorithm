import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = Integer.MAX_VALUE;
        
        if (N == number) {
            return 1;
        }
        
        // N을 i번 썼을 때 나올 수 있는 값 담기
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }
        
        dp.get(1).add(N);
        
        for (int i = 2; i <= 8; i++) {
            Set<Integer> countSet = dp.get(i);
            
            for (int j = 1; j <= i; j++) {
                Set<Integer> preSet = dp.get(j);
                Set<Integer> postSet = dp.get(i - j);
                
                for (int preNum : preSet) {
                    for (int postNum : postSet) {
                        countSet.add(preNum + postNum);
                        countSet.add(preNum - postNum);
                        countSet.add(preNum * postNum);
                        
                        if (preNum != 0 && postNum != 0) {
                            countSet.add(preNum / postNum);
                        }
                    }
                }
            }
            
            countSet.add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }
        
        for (Set<Integer> d : dp) {
            if (d.contains(number)) {
                return dp.indexOf(d);
            }
        }
        return -1;
    }
}