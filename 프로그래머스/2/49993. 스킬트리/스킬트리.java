import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String skillTree : skill_trees) {
            Map<Character, Integer> map = new HashMap<>(); // 나온 순서 입력
            
            for (int i = 0; i < skillTree.length(); i++) {
                map.put(skillTree.charAt(i), i);
            }
            
            // 순서 검증
            boolean isPossible = true;
            
            for (int i = skill.length() - 1; i >= 1; i--) {
                char cur = skill.charAt(i);
                char prev = skill.charAt(i - 1);
                
                if (!map.containsKey(cur)) {
                    continue;
                } else {
                    if (!map.containsKey(prev)) {
                        isPossible = false;
                        break;
                    }
                }
                
                if (map.get(prev) > map.get(cur)) {
                    isPossible = false;
                    break;
                }
            }
            
            if (isPossible) {
                answer++;
            }
        }
        return answer;
    }
}