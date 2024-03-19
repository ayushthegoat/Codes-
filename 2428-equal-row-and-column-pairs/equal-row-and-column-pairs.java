class Solution {
    public int equalPairs(int[][] grid) {
        int ctr=0;

        HashMap<ArrayList<Integer>,Integer>map=new HashMap<>();
            for(int i=0;i<grid.length;i++){
                ArrayList<Integer>l=new ArrayList<>();
                for(int j=0;j<grid.length;j++){
                    l.add(grid[i][j]);
                }
                map.put(l,map.getOrDefault(l,0)+1);
            }
            for(int i=0;i<grid.length;i++){
                ArrayList<Integer>l=new ArrayList<>();
                for(int j=0;j<grid.length;j++){
                    l.add(grid[j][i]); 
                } 
                 if(map.containsKey(l)){
                    ctr+=map.get(l);
                 }
            }
            return ctr;
    }
}