class Solution {
    public String smallestPalindrome(String s) {
        int[] freq=new int[26];
        for (char c:s.toCharArray()) freq[c-'a']++;
        StringBuilder left=new StringBuilder();
        String a="";
        for (int i=0; i<26; i++) {
            for (int j=0; j<freq[i]/2; j++) left.append((char) ('a'+i));
            if (freq[i]%2==1) a=String.valueOf((char) ('a'+i));
        }
        String b=new StringBuilder(left).reverse().toString();
        return left.toString()+a+b;
    }
}