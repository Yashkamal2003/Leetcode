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
 class Pair{
    int height;
    int val;
    public Pair(int h,int v)
    {
        val=v;
        height=h;
    }
 }
class Solution {
      private Map<Integer,List<Pair>> map= new HashMap<>(); 
      int minCol=Integer.MAX_VALUE;
      int maxCol=Integer.MIN_VALUE;
      private void traverse(TreeNode node,int colNo,int height){
        if(node== null)
        return;
       // if(map.get(colNo)== null)
      //  map.put(colNo,new ArrayList<>());
        //map.get(colNo).add(node.val);
        minCol= Math.min(minCol,colNo);
        maxCol=Math.max(maxCol,colNo);
        map.computeIfAbsent(colNo,f -> new ArrayList<>()).add(new Pair(height,node.val));
        traverse(node.left,colNo-1,height +1);
        traverse(node.right,colNo+1,height+1);
      }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans= new ArrayList<>();
        traverse(root,0,0);
        for( int colNo=minCol;colNo <= maxCol; colNo ++){
            if(map.get(colNo) !=null){
                List<Pair> nodes=map.get(colNo);
                Collections.sort(nodes,(p1,p2)-> {
                    if(p1.height == p2.height)
                    return p1.val -p2.val;
                    return p1.height -p2.height;
                }
                );
                List<Integer> lst =new ArrayList<>();
                for(Pair p : nodes)
                lst.add(p.val);
                ans.add(lst);
            }
        }
return ans;
    }
}