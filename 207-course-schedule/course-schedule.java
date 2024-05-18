class Solution {
    public boolean canFinish(int n, int[][] pre) {
       List<List<Integer>> graph= new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
         for(int i=0;i<pre.length;i++){
            int v1 = pre[i][0];
            int v2 = pre[i][1];
            graph.get(v1).add(v2);
         }

         boolean vis[] = new boolean[n];
         boolean paths[] = new boolean[n];

         for(int i=0;i<n;i++){
            if(dfs(i,vis,paths,graph))return false;
         }
         return true;
    }
    private boolean dfs(int curr,boolean vis[],boolean paths[],List<List<Integer>> graph){
        if(paths[curr])return true;
        if(vis[curr])return false;

        vis[curr] = true;
        paths[curr] = true;

        for(int neighbour : graph.get(curr)){
            if(dfs(neighbour,vis,paths,graph))return true;
        }
        paths[curr] = false;
        return false;
    }
}