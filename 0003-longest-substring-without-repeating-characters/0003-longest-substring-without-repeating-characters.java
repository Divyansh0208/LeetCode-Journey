class Solution {
    public int lengthOfLongestSubstring(String s) {
        int index[]=new int[128];
        int a=0,b=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            b=Math.max(b,index[c]);
            index[c]=i+1;
            a=Math.max(a,i-b+1);
        }
        return a;
    }
}