class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        HashMap<Character,Integer>map=new HashMap<>();
        int a=0,b=0;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))) b=Math.max(b,map.get(s.charAt(i))+1);
            map.put(s.charAt(i),i);
            a=Math.max(a,i-b+1);
        }
        return a;
    }
}
