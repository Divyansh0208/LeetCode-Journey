class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map=new HashMap<>();
        for (List<String> i : knowledge) map.put(i.get(0), i.get(1));
        StringBuilder a=new StringBuilder();
        int i=0;
        while (i<s.length()) {
            char c=s.charAt(i);
            if(c=='(') {
                i++;
                int x=i;
                while(s.charAt(i)!=')') i++;
                String key=s.substring(x, i);
                a.append(map.getOrDefault(key, "?")); 
            } else a.append(c);
            i++; 
        }
        return a.toString();
    }
}