class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int start = 0, end = 0;
        for(int i : weights){
            start=Math.max(start, i);
            end+=i;
        }
        while(start < end){
            int mid = (end-start)/2+start;
            int d = 1;
            int sum = 0;
            for(int i : weights){
                sum+=i;
                if (sum > mid){
                    sum = i;
                    d++;
                }
            }
            if (d > days) start = mid+1;
            else end = mid;
        }
        return end;
    }
}