class Solution {
    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> res = new ArrayList<>();
        
        if (node == null) return res;
        
        // 1. Add root (if not a leaf)
        if (!isLeaf(node)) res.add(node.data);
        
        // 2. Add left boundary
        addLeftBoundary(node.left, res);
        
        // 3. Add all leaves
        addLeaves(node, res);
        
        // 4. Add right boundary in reverse
        addRightBoundary(node.right, res);
        
        return res;
    }
    
    private boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }
    
    private void addLeftBoundary(Node root, ArrayList<Integer> res) {
        Node curr = root;
        while (curr != null) {
            if (!isLeaf(curr)) res.add(curr.data);
            if (curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }
    
    private void addLeaves(Node root, ArrayList<Integer> res) {
        if (root == null) return;
        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }
        addLeaves(root.left, res);
        addLeaves(root.right, res);
    }
    
    private void addRightBoundary(Node root, ArrayList<Integer> res) {
        ArrayList<Integer> temp = new ArrayList<>();
        Node curr = root;
        while (curr != null) {
            if (!isLeaf(curr)) temp.add(curr.data);
            if (curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        // Add in reverse
        for (int i = temp.size() - 1; i >= 0; i--) {
            res.add(temp.get(i));
        }
    }
}
