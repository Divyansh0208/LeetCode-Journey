class Solution {
    public int maxVowels(String s, int k) {
        int count=0, ans=0, curr=0, left=0;
        boolean[] arr=new boolean[s.length()];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') arr[i]=true;
        }
        for(int i=0;i<s.length();i++){
            if(count==k){
                ans=Math.max(ans,curr);
                if(arr[left])curr--;
                left++;
                count--;
            }
            if(arr[i]) curr++;
            count++;
        }
        if(count==k) ans=Math.max(ans,curr);
        return ans;
    }
}