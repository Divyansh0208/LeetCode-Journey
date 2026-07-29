class Solution {
    public int maxProfit(int[] prices) {
        int a=Integer.MAX_VALUE,b=0;
        for(int c:prices){
            if(c<a) a=c;
            else if(c-a>b) b=c-a;
        }
        return b;
    }
}