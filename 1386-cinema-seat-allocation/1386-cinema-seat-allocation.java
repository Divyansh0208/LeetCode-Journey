class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map <Integer,Set<String>> b=new HashMap<>();
        for(int[] arr : reservedSeats){
            int r=arr[0],c=arr[1];
            if(c==1 || c==10) continue;
            Set<String> s=b.computeIfAbsent(r,k->new HashSet<>());
            if(c>=2 && c<=5) s.add("left");
            if(c>=4 && c<=7) s.add("middle");
            if(c>=6 && c<=9) s.add("right");
        }
        int t=2*(n-b.size());
        int[] na={2,1,1,0};
        for(Set<String> ba:b.values()) t+=na[ba.size()];
        return t;
    }
}