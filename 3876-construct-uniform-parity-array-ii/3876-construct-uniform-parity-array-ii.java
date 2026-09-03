class Solution {
    public boolean uniformArray(int[] num) {
        int min = Integer.MAX_VALUE;
        int minOdd = Integer.MAX_VALUE;
        for (int x : num) {
            if (x < min) min = x;
            if (x % 2 != 0 && x < minOdd) minOdd = x;
        }
        if (min % 2 == 0) {
            for (int x : num) {
                if (x % 2 != 0 && minOdd >= x) return false;
            }
        } else {
            for (int x : num) {
                if (x % 2 == 0 && minOdd >= x) return false;
            }
        }
        return true;
    }
}