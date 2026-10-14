class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum>9 *num) return "";
        int q=sum/9, r=sum%9;
        StringBuilder a=new StringBuilder();
        for(int i=0;i<q;i++) a.append('9');
        if(r>0) a.append(r);
        while(a.length()<num) a.append('0');
        return a.toString();
    }
}