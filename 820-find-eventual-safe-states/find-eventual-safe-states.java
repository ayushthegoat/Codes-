class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        List<List<Integer>>adj = new ArrayList();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[V];
        for(int i=0;i<V;i++){
            for(int it : graph[i]){
                adj.get(it).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer>q = new LinkedList();
        List<Integer>list = new ArrayList();

        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            list.add(node);

            for(int it : adj.get(node)){
                indegree[it]--;

                if(indegree[it]==0){
                    q.offer(it);
                }
            }
        }
        Collections.sort(list);
        return list;
    }
}