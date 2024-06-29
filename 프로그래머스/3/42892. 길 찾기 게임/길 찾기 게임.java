import java.util.*;

class Solution {
    int[][] answer;
    Node[] nodes;
    int index = 0;
    
    public int[][] solution(int[][] nodeinfo) {
        answer = new int[2][nodeinfo.length];
        nodes = new Node[nodeinfo.length];
        
        for (int i = 0; i < nodeinfo.length; i++) {
            int[] node = nodeinfo[i];
            nodes[i] = new Node(i + 1, node[0], node[1]);
        }
        
        // 레벨 순으로 정렬
        Arrays.sort(nodes);
        
        // tree 구성
        Node root = nodes[0];
        for (int i = 1; i < nodes.length; i++) {
            insertNode(root, nodes[i]);
        }
        
        // 순회
        preOrder(nodes[0]);
        index = 0;
        postOrder(nodes[0]);
        return answer;
    }
    
    public void insertNode(Node parent, Node child) {
        if (parent.x > child.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                insertNode(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                insertNode(parent.right, child);
            }
        }
    }
    
    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        
        answer[0][index++] = node.idx;
        preOrder(node.left);
        preOrder(node.right);
    }
    
    public void postOrder(Node node) {
        if (node == null) {
            return;
        }
        
        postOrder(node.left);
        postOrder(node.right);
        answer[1][index++] = node.idx;
    }
    
    static class Node implements Comparable<Node> {
        int idx;
        int x;
        int y;
        
        Node left;
        Node right;
        
        public Node(int idx, int x, int y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }
        
        public int compareTo(Node o) {
            int result = o.y - y;
            if (result == 0) {
                result = x - o.x;
            }
            return result;
        }
    }
}