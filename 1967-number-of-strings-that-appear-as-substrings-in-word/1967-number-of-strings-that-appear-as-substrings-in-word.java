class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int a=0;
        for(String st:patterns){
            if(word.indexOf(st)!=-1) a++;
        }
        return a;
    }
}