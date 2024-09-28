import java.util.*;

class Solution {
    int col, row;
    boolean[] visited;
    List<String> result = new ArrayList<>();
    
    public int solution(String[][] relation) {
        col = relation[0].length;
        row = relation.length;
        visited = new boolean[col];
        
        dfs(0, relation);
        
        return result.size();
    }
    
    public void dfs(int depth, String[][] relation) {
        if (depth == col) {
            List<Integer> index = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < col; i++) {
                if (visited[i]) {
                    index.add(i);
                    sb.append(i);
                }
            }
            
            // 유일성 확인
            Set<String> set = new HashSet<>();
            boolean isUnique = true;

            for (int i = 0; i < row; i++) {
                StringBuilder temp = new StringBuilder();

                for (int column : index) {
                    temp.append(relation[i][column]);
                }

                if (set.contains(temp.toString())) {
                    isUnique = false;
                    break;
                }
                set.add(temp.toString());
            }

            if (isUnique) {
                String indexStr = sb.toString();
                
                for (String str : result) { // 최소성 확인 str: 12, indexStr : 123
                    int cnt = 0;
                    
                    for (int i = 0; i < str.length(); i++) {
                        if (indexStr.contains(String.valueOf(str.charAt(i)))) {
                            cnt++;
                        }
                    }
                    
                    if (cnt == str.length()) {
                        return;
                    }
                }
                
                result.add(indexStr);
            }
            
            return;
        }
        
        visited[depth] = false;
        dfs(depth + 1, relation);
        
        visited[depth] = true;
        dfs(depth + 1, relation);
    }
}