class Solution {
    public int numberOfSubstrings(String s) {
        int a=-1, b=-1, c=-1, d=0, e=Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='a') a=i;
            else if(ch=='b') b=i;
            else c=i;
            e=Math.min(a,Math.min(b,c));
            if(a>-1 && b>-1 && c>-1) d+=(1+e);
        }
        return d;
    }
}