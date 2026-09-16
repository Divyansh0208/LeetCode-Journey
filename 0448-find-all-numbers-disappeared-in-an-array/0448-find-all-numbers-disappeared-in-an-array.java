class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] a=new boolean[nums.length+1];
        for(int i=0;i<nums.length;i++) a[nums[i]]=true;
        List<Integer> r=new ArrayList<>();
        for(int i=1;i<=nums.length;i++){
            if(!a[i]) r.add(i);
        }
        return r;
    }
}