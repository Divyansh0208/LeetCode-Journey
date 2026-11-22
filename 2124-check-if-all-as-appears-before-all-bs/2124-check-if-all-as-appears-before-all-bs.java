class Solution {
    public boolean checkString(String s) {
        boolean a=false;
        for(char i:s.toCharArray()){
            if(a && i == 'a') return false;
            if(i == 'b') a=true;
        }
        return true; 
    }
}