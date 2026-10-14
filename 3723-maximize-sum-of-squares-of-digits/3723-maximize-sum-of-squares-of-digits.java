class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (num * 9 < sum) return "";
        int k = sum / 9;
        sum %= 9;
        StringBuilder a = new StringBuilder("9".repeat(k));
        if (sum > 0) a.append(sum);
        a.append("0".repeat(num - a.length()));
        return a.toString();
    }
}