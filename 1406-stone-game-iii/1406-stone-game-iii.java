class Solution {
    public String stoneGameIII(int[] sv) {
        int [] arr= new int[sv.length+1];
        arr[sv.length]=0;
        for(int i=sv.length-1;i>=0;i--){
            arr[i]=Integer.MIN_VALUE;
            int s=0;
            for(int j=0;j<3 && i+j<sv.length;j++){
                s+=sv[i+j];
                arr[i]=Math.max(arr[i], s-arr[i+j+1]);
            }
        }
        if(arr[0]>0) return "Alice";
        else if(arr[0]<0) return "Bob";
        else return "Tie";
    }
}