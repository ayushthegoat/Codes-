/*
// Definition for a Node.
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
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
     

        List<List<Integer>> l = new ArrayList<>();

        if(root==null)return l;
        Queue<Node> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> store = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node temper = q.poll();
                store.add(temper.val);
                if (temper.children != null) {
                    q.addAll(temper.children);
                }

            }
            l.add(store);

        }
        return l;
    }
}