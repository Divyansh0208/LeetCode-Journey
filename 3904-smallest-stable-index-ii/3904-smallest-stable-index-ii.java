class Solution {
    public int firstStableIndex(int[] n, int k) {
        int[] maxPrev = new int[n.length];
        int[] minNext = new int[n.length];

        for (int i = 0; i < n.length; i++) {
            maxPrev[i] = i > 0 ? Math.max(maxPrev[i - 1], n[i]) : n[i];
            minNext[n.length - i - 1] = i > 0 ? Math.min(minNext[n.length - i], n[n.length - i - 1]) : n[n.length - i - 1];
        }
        for (int i = 0; i < n.length; i++) {
            if (maxPrev[i] - minNext[i] <= k) return i;
        }
        return -1;
    }
}