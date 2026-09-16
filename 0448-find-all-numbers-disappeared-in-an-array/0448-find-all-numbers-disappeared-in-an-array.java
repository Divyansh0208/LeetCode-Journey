class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int a=nums.length;
        boolean[] s=new boolean[a+1];
        for(int i=0;i<a;i++) s[nums[i]]=true;
        List<Integer> r=new ArrayList<>();
        for(int i=1;i<=a;i++){
            if(!s[i]) r.add(i);
        }
        return r;
    }
}