class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder r=new StringBuilder();
        int a=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                if(a>0) r.append(c);
                a++;
            }else{
                a--;
                if(a>0) r.append(c);
            }
        }
        return r.toString();
    }
}