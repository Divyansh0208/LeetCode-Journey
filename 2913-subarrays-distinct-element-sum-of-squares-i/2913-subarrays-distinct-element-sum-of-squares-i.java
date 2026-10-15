class Solution {
    public int sumCounts(List<Integer> nums) {
        int a=0;
        for(int i=0;i<nums.size();i++){
            boolean[] s=new boolean[101];
            int b=0;
            for(int j=i;j<nums.size();j++){
                int n=nums.get(j);
                if(!s[n]){
                    s[n]=true;
                    b++;
                }
                a+=b*b;
            }
        }
        return a;
    }
}