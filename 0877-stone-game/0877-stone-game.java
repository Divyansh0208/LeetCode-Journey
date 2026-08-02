class Solution {
    public boolean stoneGame(int[] piles) {
        int[] dp = new int[piles.length];
        for (int left = piles.length - 1; left >= 0; left--) {
            for (int right = left; right < piles.length; right++) {
                int turn = (left + right) % 2;
                if (left == right) dp[right] = 0;
                else {
                    if (turn == 1) dp[right] = Math.max(piles[left] + dp[right], piles[right] + dp[right - 1]);
                    else dp[right] = Math.min(dp[right], dp[right - 1]);
                }
            }
        }
        int total = 0;
        for (int pile : piles) total += pile;
        return dp[piles.length - 1] > total - dp[piles.length - 1];
    }
}