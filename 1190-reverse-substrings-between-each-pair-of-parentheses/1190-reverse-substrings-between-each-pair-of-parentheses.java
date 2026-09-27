class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> st=new Stack<>();
        StringBuilder c=new StringBuilder();
        for(char i:s.toCharArray()){
            if(i=='('){
                st.push(c);
                c=new StringBuilder();
            }
            else if(i==')'){
                c.reverse();
                StringBuilder p=st.pop();
                p.append(c);
                c=p;
            }else c.append(i);
        }
        return c.toString();
    }
}