public class Solution {
    public int maxActiveSectionsAfterTrade(String input) {
        int a=0, b=0, c=0;
        for(int i=0; i<input.length(); ++i){
            int d=0, e=0;
            while(i<input.length() && input.charAt(i)=='1'){
                ++i; ++a; ++d;
            }
            while(i<input.length() && input.charAt(i)=='0'){
                ++i; ++e;
            }
            if(b>0 && d>0 && e>0) c=Math.max(c, b+e);
            --i;
            b=e;
        }
        return a+c;
    }
}