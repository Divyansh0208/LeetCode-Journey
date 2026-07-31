class Solution {
    public int minimumPushes(String word) {
        int[] arr=new int[26];
        for (char ch : word.toCharArray()) arr[ch - 'a']++;
        Arrays.sort(arr);
        int ans=0, dex=0;
        for (int i=25; i>=0; i--) {
            if (arr[i] == 0) break;
            int button=(dex/8)+1;
            ans+=arr[i]*button;
            dex++;
        }
        return ans;
    }
}