class Solution {
    public int maxProduct(int n) {
        int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE;
        while(n > 0){
            int i=n%10;
            if(i>a){
                b=a;
                a=i;
            }else if(i>b) b=i;
            n/=10;
        }
        return b==Integer.MIN_VALUE?0:a*b;
    }
}