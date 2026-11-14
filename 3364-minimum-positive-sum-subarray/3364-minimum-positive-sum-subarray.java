class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int[] arr=new int[nums.size()+1];
        for(int i=0;i<nums.size();i++) arr[i+1]=arr[i]+nums.get(i);
        int a=Integer.MAX_VALUE;
        for(int i=l;i<=r;i++){
            int b=0;
            for(int j=i,k=0;j<=nums.size();j++){
                int c=arr[j]-b;
                b+=nums.get(k++);
                if(c>0) a=Math.min(a,c);  
            }
        }
        return a==Integer.MAX_VALUE?-1:a;
    }
}