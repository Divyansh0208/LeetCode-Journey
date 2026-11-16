class Solution {
    public String digitSum(String s, int k) {
        String a = s;
        while (a.length() > k) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < a.length(); i += k) {
                int sum = 0, end = Math.min(i + k, a.length());
                for (int j = i; j < end; j++) sum += a.charAt(j) - '0';
                sb.append(sum);
            }
            a = sb.toString();
        }
        return a;
    }
}