class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] a=new int[n+1];
        Arrays.fill(a,Integer.MAX_VALUE);
        a[0]=0;
        for(int i=1;i<=n;i++){
            for(int j=Math.max(0,i-3);j<i;j++){
                int b=i-j;
                int c=costs[i-1]+b*b;
                a[i]=Math.min(a[i],a[j]+c);
            }
        }
        return a[n];
    }
}