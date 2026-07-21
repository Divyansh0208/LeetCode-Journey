class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int a = 0, b = 0;
        for (char c : s.toCharArray()) if (c == '1') a++;
        String t = "1" + s + "1";
        ArrayList<Character> x = new ArrayList<>();
        ArrayList<Integer> len = new ArrayList<>();
        for (char c : t.toCharArray()) {
            if (x.isEmpty() || x.get(x.size() - 1) != c) {
                x.add(c);
                len.add(1);
            }else len.set(len.size() - 1, len.get(len.size() - 1) + 1);
        }
        for (int i = 1; i + 1 < x.size(); i++) {
            if(x.get(i)=='1' && x.get(i-1)=='0' && x.get(i+1)=='0') b=Math.max(b, len.get(i-1)+len.get(i + 1));
        }
        return a+b;
    }
}