class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination )return true;
        ArrayList<ArrayList<Integer>> g  = new ArrayList<>();
        for(int i = 0 ;i <n ;i++)
        g.add(new ArrayList<>());
    
        
        for(int i = 0 ; i< edges.length ;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            g.get(a).add(b);
            g.get(b).add(a);
            
        }
        boolean visit[] = new boolean[n];
        Queue<Integer> q  = new LinkedList<>();
        q.offer(source);
       
        while(!q.isEmpty()){
            int cur = q.poll();
            if(visit[cur])continue;
            visit[cur] = true;
            
            for(Integer nv : g.get(cur)){
                if(!visit[nv])
                    q.offer(nv);
            }
        }
        return visit[destination];
    }
}