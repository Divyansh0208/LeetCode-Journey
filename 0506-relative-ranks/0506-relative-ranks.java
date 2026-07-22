class Solution {
    public String[] findRelativeRanks(int[] score) {
        int max = 0;
        for (int x : score){
            if (x > max) max = x;
        }
        int score_i[] = new int[max + 1];
        for (int i = 0; i < score.length; i++) score_i[score[i]] = i + 1;
        String rank[] = new String[score.length];
        int c = 1;
        String medals[] = { "Gold Medal", "Silver Medal", "Bronze Medal" };
        for (int i = max; i >= 0; i--) {
            if (score_i[i] != 0) {
                int org_i = score_i[i] - 1;
                if (c < 4) rank[org_i] = medals[c - 1];
                else rank[org_i] = Integer.toString(c);
                c++;
            }
        }
        return rank;
    }
}