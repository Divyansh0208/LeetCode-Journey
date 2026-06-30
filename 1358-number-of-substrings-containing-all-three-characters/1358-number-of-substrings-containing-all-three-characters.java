class Solution {
    public int numberOfSubstrings(String s) {
        int l=0, an=0;
        int a=0, b=0, c=0;
        for(int i=0; i<s.length(); i++) {
            char ch=s.charAt(i);
            if(ch=='a') a++;
            else if(ch=='b') b++;
            else c++;
            while(a>0 && b>0 && c>0){
                an+=(s.length()-i);
                char lc=s.charAt(l);
                if(lc=='a') a--;
                else if(lc=='b') b--;
                else c--;
                l++;
            }
        }
        return an;
    }
}