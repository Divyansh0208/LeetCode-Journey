class Solution {
    public int countCommas(int n) {
        long t=0;
        for(long th=1000;th<=n;th*=1000){
            t+=(n-th+1);
        }
        return (int)t;
    }
    public static void main(String[] args){
        Solution sol=new Solution();
        System.out.println(sol.countCommas(1002));
        System.out.println(sol.countCommas(998));
    }
}