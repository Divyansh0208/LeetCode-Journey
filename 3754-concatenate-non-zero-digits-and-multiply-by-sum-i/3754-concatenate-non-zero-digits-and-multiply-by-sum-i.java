class Solution {
    public long sumAndMultiply(int n) {
        long a=0, b=0, c=0;
        while(n!=0){
            if(n%10!=0){
                a=a*10+n%10;
                b+=n%10;
            }
            n/=10;
        }
        while(a!=0){
            c=c*10+a%10;
            a/=10;
        }
        return c*b;
    }
}