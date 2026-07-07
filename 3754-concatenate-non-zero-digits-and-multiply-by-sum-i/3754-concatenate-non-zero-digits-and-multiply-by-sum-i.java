class Solution {
    public long sumAndMultiply(int n) {
        if(n<=0) return 0;
        int a=0;
        StringBuilder s=new StringBuilder();
        while(n>0){
            int x=n%10;
            if(x==0){
                n/=10; continue;
            }
            s.append(x);
            a+=x;
            n/=10;
        }
        return Long.parseLong(s.reverse().toString())*a;
    }
}