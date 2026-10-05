class Solution {
    public int scoreOfParentheses(String s) {
        int a=0,b=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') a++;
            else{
                a--;
                if(s.charAt(i-1)=='(') b+=1<<a;
            }
        }
        return b;
    }
}