class Solution {
    public int minMoves(String[] classroom, int energy) {
        int sr=-1, sc=-1, cnt=0;
        int idL[][] = new int[classroom.length][classroom[0].length()];
        for(int i=0;i<classroom.length;i++){
            for(int j=0;j<classroom[0].length();j++){
                if(classroom[i].charAt(j)=='S'){
                    sr=i;
                    sc=j;
                }
                else if(classroom[i].charAt(j)=='L') idL[i][j]=cnt++;
            }
        }
        int masks=1<<cnt, fullmask=masks-1;
        int best[][][] = new int[classroom.length][classroom[0].length()][masks];
        for(int i[][] : best){
            for(int j[] : i) Arrays.fill(j, -1);
        }
        int dir[][] = { {1,0},{0,1},{0,-1},{-1,0} };
        Queue<State>q = new LinkedList<>();
        q.add(new State(sr,sc,energy,0,0));
        while(!q.isEmpty()){
            State rm = q.poll();
            int r = rm.r, c = rm.c, en = rm.en, mask = rm.mask, dist = rm.dist;
            if(r<0 || r>=classroom.length || c<0 || c>=classroom[0].length())continue;
            if(classroom[r].charAt(c)=='X')continue;
            if(classroom[r].charAt(c)=='R')en=energy;
            if(classroom[r].charAt(c)=='L') mask|=(1<<idL[r][c]);
            if(mask==fullmask) return dist;
            if(best[r][c][mask]>=en) continue;
            else best[r][c][mask]=en;
            if(en==0)continue;
            for(int i=0;i<4;i++) q.add(new State(r+dir[i][0], c+dir[i][1], en-1, mask, dist+1));
        }
        return -1;
    }
    class State{
        int r, c, en, mask, dist;
        public State(int r, int c, int en, int mask, int dist){
            this.r=r;
            this.c=c;
            this.en=en;
            this.mask=mask;
            this.dist=dist;
        }
    }
}