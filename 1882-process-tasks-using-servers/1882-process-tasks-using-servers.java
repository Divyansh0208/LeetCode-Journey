class Solution {
    class Server{
        int wt, ind, exTm;
        public Server(int wt, int ind, int extm){
            this.wt=wt;
            this.ind=ind; 
            this.exTm=extm;
        }
        public Server(int wt, int ind){
            this.wt=wt;
            this.ind=ind;  
            this.exTm=-1; 
        }
    }
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<Server> unUsed = new PriorityQueue<>(
            (t1,t2) -> {
                if(t1.wt==t2.wt) return Integer.compare(t1.ind,t2.ind);
                return Integer.compare(t1.wt,t2.wt);
            }
        );
        PriorityQueue<Server> used = new PriorityQueue<>( (t1,t2) -> Integer.compare(t1.exTm,t2.exTm) );
        int noSer = servers.length;
        for(int i=0;i<noSer;i++) unUsed.offer(new Server(servers[i],i));
        int curTm=0;
        int noTsk= tasks.length;
        int[] tasksOrder = new int[noTsk];
        int taskInd=0;
        while(taskInd<noTsk){
            int currServerWeight=tasks[taskInd];
            if(curTm<taskInd) curTm=taskInd;
            while(!used.isEmpty() && curTm>=used.peek().exTm) unUsed.offer(used.poll());  
            if(!unUsed.isEmpty()){
                Server srv = unUsed.poll();
                tasksOrder[taskInd++] = srv.ind;
                srv.exTm=curTm+currServerWeight;
                used.offer(srv);
            }
            else{
                Server srv = used.peek();
                curTm=srv.exTm;
            }
        }
        return tasksOrder;
    }
}