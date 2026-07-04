class Pair {
    int v, d; 
    Pair(int v, int d) {
        this.v = v; this.d = d; 
    }
}
class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>(); 
        for(int i = 0; i <= n; i++) adj.add(new ArrayList<>()); 
        for(int r[]: roads) {
            adj.get(r[0]).add(new Pair(r[1], r[2])); adj.get(r[1]).add(new Pair(r[0], r[2])); 
        }
        Queue<Integer> q = new ArrayDeque<>(); 
        q.add(1); 
        int mn = 1_000_01; 
        boolean vis[] = new boolean[n + 1]; 
        while(q.size() > 0) {
            Integer front = q.remove(); 
            vis[front] = true; 
            for(Pair pr: adj.get(front)) {
                int next=pr.v, d=pr.d; 
                if(!vis[next]) {
                    mn=Math.min(mn,d); q.add(next); 
                }
            }
        }
        return mn; 
    }
}