class Solution {
    public int sumCounts(List<Integer> nums) {
        int a=0;
        Set<Integer> s=new HashSet<>();
        for(int i=0;i<nums.size();i++){
            for(int j=i;j<nums.size();j++){
                s.add(nums.get(j));
                int b=s.size();
                a+=b*b;
            }
            s.clear();
        }
        return a;
    }
}