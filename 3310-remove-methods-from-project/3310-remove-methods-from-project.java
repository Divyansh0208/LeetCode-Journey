class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] list=new ArrayList[n];
        for(int i=0;i<n;i++) list[i]=new ArrayList<>();

        for(int[] arr:invocations) list[arr[0]].add(arr[1]);

        boolean[] sus =new boolean[n];
        dfs(k,list,sus);

        for(int[] arr:invocations){
            if(!sus[arr[0]] && sus[arr[1]]){
                List<Integer> a=new ArrayList<>();
                for(int i=0;i<n;i++) a.add(i);
                return a;
            }
        }
        List<Integer> a=new ArrayList<>();
        for(int i=0;i<n;i++) if(!sus[i]) a.add(i);
        return a;
    }
    private void dfs(int node, List<Integer>[] arr, boolean[] sus){
        if(sus[node]) return;
        
        sus[node]=true;

        for(int f:arr[node]) dfs(f,arr,sus);
    }
}