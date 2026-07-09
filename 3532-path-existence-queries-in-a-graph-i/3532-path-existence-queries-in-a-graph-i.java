class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] arr=new int[n];
        int id=0;
        arr[0]=id;
        for (int i=1; i<n; i++) {
            if(nums[i]-nums[i-1]>maxDiff) id++;
            arr[i]=id;
        }
        boolean[] ans=new boolean[queries.length];
        for (int i=0; i<queries.length; i++) ans[i]=arr[queries[i][0]]==arr[queries[i][1]];
        return ans;
    }
}