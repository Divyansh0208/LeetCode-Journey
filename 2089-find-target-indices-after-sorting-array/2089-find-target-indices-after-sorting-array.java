class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> a=new ArrayList<>();
        int b=0,c=0;
        for(int i:nums){
            if(i<target) b++;
            if(i==target) c++;
        }
        while(c-->0) a.add(b++);
        return a;
    }
}