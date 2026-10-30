class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] g=new List[n];
        Arrays.setAll(g,x -> new ArrayList<>());
        for(int[] e:edges) g[e[0]].add(new int[]{e[1],e[2]});
        int[] best=new int[n];
        Arrays.fill(best,k+1);
        PriorityQueue<long[]> h=new PriorityQueue<>(Arrays::compare);
        h.add(new long[]{0,1,0});
        while(!h.isEmpty()){
            long[] s=h.poll();
            long d=s[0];
            int run=(int) s[1],x=(int) s[2];
            if(run >= best[x]) continue;
            if(x==n-1) return (int) d;
            best[x]=run;
            for(int[] e:g[x]){
                int y=e[0],r=labels.charAt(y)==labels.charAt(x) ? run+1:1;
                if(r<best[y]) h.add(new long[]{d+e[1],r,y});
            }
        }
        return -1;
    }
}