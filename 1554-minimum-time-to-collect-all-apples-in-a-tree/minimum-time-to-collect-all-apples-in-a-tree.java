class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>>map = new ArrayList();
        for(int i=0;i<n;i++){
            map.add(new ArrayList<>(0));

        }
        boolean[] vis = new boolean[n];
        
        for(int []arr : edges){
            map.get(arr[0]).add(arr[1]);
            map.get(arr[1]).add(arr[0]);
        }
        return dfs(map, vis, hasApple,0);
    }
    private int dfs(List<List<Integer>> map,boolean[] vis,List<Boolean> hasApple,int index) {
    
        int result = 0;
        vis[index] = true;

        for(int iterator : map.get(index)){
            if(!vis[iterator]){

                result += dfs(map, vis, hasApple, iterator);
            }
        }
        if(index == 0) {
            return result;
        }
         return result+=(hasApple.get(index) || result>0)?2:0;
}
}