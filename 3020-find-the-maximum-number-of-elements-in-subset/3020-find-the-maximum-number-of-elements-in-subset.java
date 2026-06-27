class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Integer,Integer> a=new HashMap<>();
        for(int i:nums) a.put(i,a.getOrDefault(i,0)+1);
        int b=1;
        if(a.containsKey(1)){
            int x=a.get(1);
            b=Math.max(b,(x%2==0)?x-1:x);
        }
        for(int i:a.keySet()){
            if(i==1) continue;
            int y=i, r=0;
            while(a.containsKey(y) && a.get(y)>=2){
                r+=2; y=y*y;
            }
            if(a.containsKey(y)) r++;
            else r--;
            b=Math.max(b,r);
        }
        return b;
    }
}                                                                                                                          