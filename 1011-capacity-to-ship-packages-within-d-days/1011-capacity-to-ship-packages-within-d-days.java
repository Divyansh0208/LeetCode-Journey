class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int a=0;
        for(int i:weights) a=Math.max(a,i);
        int x=a, y=Integer.MAX_VALUE, z=Integer.MAX_VALUE;
        while(x<=y){
            int cap=x+(y-x)/2, t=1, cur=cap;
            for(int i=0;i<weights.length;i++){
                if(cur<weights[i]){
                    t++; cur=cap;
                }
                cur-=weights[i];
            }
            if(t<=days){
                z=cap; y=cap-1;
            }
            else x=cap+1;
        }
        return z;
    }
}
