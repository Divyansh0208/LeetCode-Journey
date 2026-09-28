class Solution {
    public int maxDepth(String s) {
        int a=0,b=0;
        for(char i:s.toCharArray()){
            if(i=='('){
                a++;
                b=Math.max(b,a);
            }else if(i==')') a--;
        }
        return b;
    }
}