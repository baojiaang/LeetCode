package Easy;

import java.util.List;

public class Q559 {
    int ret = 0;
    public int maxDepth(Node root) {

        dfs(root,0);
        return ret;
    }
    public void dfs(Node root, int len){
        if(root == null){
            return;
        }
        len++;
        if(len > ret){
            ret = len;
        }
        if(root.children != null){
            for(Node n : root.children){
                dfs(n,len);
            }
        }
    }
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
