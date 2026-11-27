class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int[] f=new int[items.length];
        int p=Integer.MAX_VALUE;
        for(int i=0;i<items.length;i++){
            p=Math.min(p,items[i][1]);
            for(int j=0;j<items.length;j++){
                if(i!=j &&(items[j][0]%items[i][0] == 0)) f[i]++;
            }
        }
        int[] dp=new int[budget+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int i=0;i<items.length;i++){
            int price=items[i][1], rew=1+f[i];
            for(int w=budget;w>=price;w--){
                if(dp[w-price] != -1) dp[w]=Math.max(dp[w],dp[w-price]+rew);
            }
        }
        int max=0;for(int w=0;w<=budget;w++){
            if(dp[w] != -1){
                int rem=budget-w;
                int add=rem/p;
                max=Math.max(max,dp[w]+add);
            }
        }
        return max;
    }
}