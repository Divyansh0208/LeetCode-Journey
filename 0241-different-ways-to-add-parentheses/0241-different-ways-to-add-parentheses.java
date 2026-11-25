class Solution {
    public List<Integer> diffWaysToCompute(String exp) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<exp.length();i++){
            char ch = exp.charAt(i);
            if(ch == '-' || ch == '+' || ch == '*'){
                List<Integer> left = diffWaysToCompute(exp.substring(0,i));
                List<Integer> right = diffWaysToCompute(exp.substring(i+1));
                for(int j : left){
                    for(int k : right){
                        if(ch == '-') list.add(j-k);
                        else if(ch == '+') list.add(j+k);
                        else list.add(j*k);
                    }
                }
            }
        }
        if(list.size() == 0) list.add(Integer.valueOf(exp));
        return list;
    }
}