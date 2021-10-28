package programers.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Level1 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] participant = {"mislav", "stanko", "ana", "test"};
        String[] completion = {"stanko", "ana", "mislav"};
        System.out.println("so: "+ s.solution(participant, completion));
    }
}

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();

        for (String parti : participant) {
            hm.put(parti, hm.getOrDefault(parti, 0) + 1);
            // getOrDefault(key, defaultValue) : 키가 존재하지않으면 default값을 return, 키가 존재하면 해당 키의 value를 가져온다.
        }

        for (String com : completion) {
            hm.put(com, hm.get(com)-1);
        }

        for (String parti : participant) {
            if (hm.get(parti) > 0) {
                answer = parti;
            }
        }
        System.out.println(hm);
        System.out.println(Arrays.toString(participant));
        return answer;
    }
}

