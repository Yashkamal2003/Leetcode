/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private void trackParents(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        parentMap.put(root, null);

        while (!q.isEmpty()) {
            TreeNode nd = q.poll();

            if (nd.left != null) {
                q.add(nd.left);
                parentMap.put(nd.left, nd);
            }
            if (nd.right != null) {
                q.add(nd.right);
                parentMap.put(nd.right, nd);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        trackParents(root, parentMap);

        Queue<TreeNode> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        q.add(target);
        visited.add(target.val);
        int curLevel = 0;

        while (!q.isEmpty()) {
            if (curLevel == k) break;
            int sz = q.size();

            while (sz-- > 0) {
                TreeNode nd = q.poll();

                if (nd.left != null && !visited.contains(nd.left.val)) {
                    visited.add(nd.left.val);
                    q.add(nd.left);
                }
                if (nd.right != null && !visited.contains(nd.right.val)) {
                    visited.add(nd.right.val);
                    q.add(nd.right);
                }
                TreeNode parent = parentMap.get(nd);
                if (parent != null && !visited.contains(parent.val)) {
                    visited.add(parent.val);
                    q.add(parent);
                }
            }
            curLevel++;
        }

        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            ans.add(q.poll().val);
        }

        return ans;
    }
}
