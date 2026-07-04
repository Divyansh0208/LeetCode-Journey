class Solution {
    public int minScore(int n, int[][] roads) {
        
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        for(int[] edge : roads) {
            int u=edge[0], v=edge[1], wt=edge[2];
            adj.get(u).add(new int[]{v,wt}); adj.get(v).add(new int[]{u,wt});
        }
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1]=true;
        int result = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            for(int[] edge :adj.get(curr)) {
                int v = edge[0];
                int wt = edge[1];
                result = Math.min(result, wt);
                if(!visited[v]) {
                    visited[v]=true;
                    queue.offer(v);
                }
            }
        }
        return result;
    }
}