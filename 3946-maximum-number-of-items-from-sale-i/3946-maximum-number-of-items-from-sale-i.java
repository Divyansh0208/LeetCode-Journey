class Solution {
  public int maximumSaleItems(int[][] items, int budget) {
    int n = items.length, MAXF = 1501;
    int[] cnt = new int[MAXF];
    int minPrice = Integer.MAX_VALUE;
    for (int[] i : items) {
      cnt[i[0]]++;
      minPrice = Math.min(minPrice, i[1]);
    }
    int[] dp = new int[budget + 1];
    for (int[] i : items) {
      int free = -1;
      for (int m = i[0]; m < MAXF; m += i[0]) free += cnt[m];
      int cost = i[1], value = 1 + free;
      for (int w = budget; w >= cost; w--) dp[w] = Math.max(dp[w], dp[w - cost] + value);
    }
    int best = 0;
    for (int w = 0; w <= budget; w++) best = Math.max(best, dp[w] + (budget - w) / minPrice);
    return best;
  }
}