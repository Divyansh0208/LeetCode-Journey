
class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];
        for (int digit : digits) freq[digit]++;
        int count = 0;
        for (int first = 1; first < 10; first++) {
            for (int second = 0; second < 10; second++) {
                for (int last = 0; last < 10; last += 2) {
                    freq[first]--;
                    freq[second]--;
                    freq[last]--;
                    if (freq[first] >= 0 &&
                        freq[second] >= 0 &&
                        freq[last] >= 0) {
                        count++;
                    }
                    freq[first]++;
                    freq[second]++;
                    freq[last]++;
                }
            }
        }

        return count;
    }
}