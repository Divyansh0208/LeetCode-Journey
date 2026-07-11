class Solution {
    void dfs(int u, List<List<Integer>> adj, boolean[] vis, List<Integer> comp) {
        vis[u] = true;
        comp.add(u);
        for (int v : adj.get(u)) if (!vis[v]) dfs(v, adj, vis, comp);
    }
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean[] vis = new boolean[n];
        int a = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                List<Integer> comp = new ArrayList<>();
                dfs(i, adj, vis, comp);
                boolean ic = true;
                for (int u : comp) {
                    if (adj.get(u).size() != comp.size() - 1) {
                        ic = false;
                        break;
                    }
                }
                if (ic) a++;
            }
        }
        return a;
    }
}