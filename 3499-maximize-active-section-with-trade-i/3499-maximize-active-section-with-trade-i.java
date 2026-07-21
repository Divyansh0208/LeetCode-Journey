class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int a=0, b=0, c=0, d=0;
        for(char ch : s.toCharArray()){
            if(ch=='0') c++;
            else{
                if(c!=0) d=c;
                c=0; a++;
            }
            b=Math.max(b, c+d);
        }
        if(b==c || b==d) return a;
        return a+b;
    }
}