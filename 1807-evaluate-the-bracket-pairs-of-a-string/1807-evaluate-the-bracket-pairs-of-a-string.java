class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>(knowledge.size());
        for (List<String> i : knowledge) map.put(i.get(0), i.get(1));
        StringBuilder a = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                int closingBracketIndex = s.indexOf(')', i + 1);
                String key = s.substring(i + 1, closingBracketIndex);
                a.append(map.getOrDefault(key, "?"));
                i = closingBracketIndex;
            } else a.append(s.charAt(i));
        }
        return a.toString();
    }
}