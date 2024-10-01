import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        List<Node> list = new ArrayList<>();
        
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '{') {
                Node node = new Node();
                int next = i + 1;
                int cnt = 0;
                
                while (s.charAt(next) != '}') {
                    StringBuilder sb = new StringBuilder();

                    while (s.charAt(next) - '0' >= 0 && s.charAt(next) - '0' <= 9) {
                        sb.append(s.charAt(next) - '0');
                        next++;
                    }

                    node.list.add(Integer.parseInt(sb.toString()));
                    cnt++;

                    if (s.charAt(next) == '}') {
                        break;
                    }
                    next++;
                }

                node.len = cnt;
                list.add(node);
                i = next;
            }
        }
        
        Collections.sort(list);
        Set<Integer> set = new HashSet<>();
        answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            for (int num : node.list) {
                if (!set.contains(num)) {
                    set.add(num);
                    answer[i] = num;
                    break;
                }
            }
        }
        
        return answer;
    }
    
    static class Node implements Comparable<Node> {
        int len;
        List<Integer> list = new ArrayList<>();
        
        public int compareTo(Node o) {
            return Integer.compare(len, o.len);
        }
    }
}