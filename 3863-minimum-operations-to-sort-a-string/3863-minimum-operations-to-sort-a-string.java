class Solution {
    public int minOperations(String s) {
        char a=s.charAt(0), b=s.charAt(0);
        boolean c=true;
        for(int i=1;i<s.length();i++){
            char cur=s.charAt(i);
            a=(char)Math.min(a,cur);
            b=(char)Math.max(b,cur);
            if(cur<s.charAt(i-1)) c=false;
        }
        if(c) return 0;
        if(s.length()==2) return -1;
        if(s.charAt(0)==a || s.charAt(s.length()-1)==b) return 1;
        for(int i=1;i<s.length()-1;i++){
            if(s.charAt(i)==a || s.charAt(i)==b) return 2;
        }
        return 3;
    }
}