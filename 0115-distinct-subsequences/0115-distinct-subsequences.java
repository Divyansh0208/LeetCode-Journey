class Solution {
    public int numDistinct(String s, String t) {
        int[] curr=new int[t.length()+1];curr[t.length()]=1;
        for(int i=s.length()-1;i>=0;i--){
            for(int j=0;j<t.length();j++){
                if(s.charAt(i)==t.charAt(j)) curr[j]=curr[j+1]+curr[j];
                else curr[j]=curr[j];
            }
        }
        return curr[0];
    }
}