class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0,a=n,m = 1;
        while(a>0){
            int p=a%10;
            sum+=p;
            m*=p;
            a/=10;
        }
        return n%(sum+m)==0 ? true : false;
    }
}