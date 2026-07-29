class Solution {
    private void dfs(int node,ArrayList<ArrayList<Integer>> graph, boolean [] visited,ArrayList<Integer> component){
        visited[node]=true;
         component.add (node);
         for(int neighbor: graph.get(node)){
             if(!visited[neighbor]){
                 dfs(neighbor,graph,visited,component);
             }
         }
    }
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
         ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
         ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        
       for( int i=0;i<V; i++){
           graph.add( new ArrayList<>());
            
       }
        for( int [] edge :edges){
            int u= edge[0];
            int v= edge[1];
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
         boolean[] visited = new boolean[V];
         for ( int i=0; i<V;i++)
         if(!visited[i]){
         {
             
             ArrayList<Integer> component =new ArrayList<>();
             dfs(i,graph,visited,component);
             ans.add(component);
         }
             
         }
          return ans;
    }
}
