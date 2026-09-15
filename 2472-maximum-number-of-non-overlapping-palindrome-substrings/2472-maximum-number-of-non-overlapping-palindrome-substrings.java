class Solution {
    public int maxPalindromes(String s, int k) {
        int lastEnd=0, c=0;
        for (int i=0; i<2*s.length(); i++) {
            int l=i/2;
            int r=l+i%2;
            while (l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)) {
                if (r-l+1>=k) {
                    int e=r+1;
                    if (l>=lastEnd) {
                        lastEnd=e;
                        c++;
                    }else lastEnd = Math.min(lastEnd, e);
                    break;
                }
                l--; r++;
            }
        }
        return c;
    }
}