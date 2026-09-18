
class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int[] f = new int[26];
        int[] l = new int[26];
        Arrays.fill(f, s.length());
        Arrays.fill(l, -1);
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            f[c] = Math.min(f[c], i);
            l[c] = i;
        }
        List<int[]> intervals = new ArrayList<>();
        for (int c = 0; c < 26; c++) {
            if (l[c] == -1) continue;
            int l1 = f[c], r = l[c];
            boolean valid = true;
            for (int i = l1; i <= r; i++) {
                int x = s.charAt(i) - 'a';
                if (f[x] < l1) {
                    valid = false;
                    break;
                }
                r = Math.max(r, l[x]);
            }
            if (valid) intervals.add(new int[]{l1, r});
        }
        intervals.sort((a, b) -> a[1] - b[1]);
        List<String> res = new ArrayList<>();
        int e = -1;
        for (int[] i : intervals) {
            if (i[0] > e) {
                res.add(s.substring(i[0], i[1] + 1));
                e = i[1];
            }
        }
        return res;
    }
}