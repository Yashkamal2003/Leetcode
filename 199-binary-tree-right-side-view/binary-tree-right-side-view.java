/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans =new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        if(root !=null)
        q.add(root);
        while(!q.isEmpty()){
            int sz=q.size();
            TreeNode nd=null;
            while(sz -- > 0){
                nd=q.poll();
                if(nd.left !=null)
                q.add(nd.left);
                if(nd.right !=null)
                q.add(nd.right);
            } ans.add(nd.val);
        }
        return ans;
    }
}