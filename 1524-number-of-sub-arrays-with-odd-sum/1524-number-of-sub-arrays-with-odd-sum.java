class Solution {
    public int numOfSubarrays(int[] arr) {
        int a=0;
        long b=0;
        for(int i=0;i<arr.length;i++){
            a+=arr[i];
            b+=a%2;
        }
        b+=(arr.length-b)*b;
        return (int) (b%1000000007);
    }
}