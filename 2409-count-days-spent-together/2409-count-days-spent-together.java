class Solution {
    private int date(String s){
        int[] month={0,31,59,90,120,151,181,212,243,273,304,334};
        int m=Integer.parseInt(s.substring(0,2)), d=Integer.parseInt(s.substring(3,5));
        return month[m-1]+d;
    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int s=Math.max(date(arriveAlice),date(arriveBob)), e=Math.min(date(leaveAlice),date(leaveBob));
        return Math.max(0,e-s+1);
    }
}