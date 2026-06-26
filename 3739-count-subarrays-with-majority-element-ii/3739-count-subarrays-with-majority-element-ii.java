class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int a=nums.length;
        int[] arr=new int[2*nums.length+1];
        arr[nums.length] = 1;
        long b = 0, ans = 0;
        for(int n:nums){
            if(n==target){
                b+=arr[a]; a++;
            }else{
                a--; b-=arr[a];
            }
            arr[a]++;
            ans+=b;
        }
        return ans;
    }
}