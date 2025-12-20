class state{
    int node,time;
    state(int a , int b){
        this.time=b;
        this.node=a;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<int[]>[] adjlist = new ArrayList[n+1];
        int[] dist= new int[n+1];
        PriorityQueue<state> pq= new PriorityQueue<>((a,b)->a.time-b.time);
        for(int i=0;i<n+1;i++){
            adjlist[i]=new ArrayList<>();
        }
        for(int[] i:times){
            adjlist[i[0]].add(new int[]{i[1],i[2]});
        }
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        pq.offer(new state(k,0));
        while(!pq.isEmpty()){
            state p=pq.poll();
            int node=p.node;
            int time=p.time;
            if(time>dist[node])continue;
            for(int[] i:adjlist[node]){
                int dnode=i[0];
                int dtime=i[1];
                int newtime=dtime+time;
                if(newtime<dist[dnode]){
                    dist[dnode]=newtime;
                    pq.offer(new state(dnode,newtime));
                }
            }

        }
        int max=-1;
        for(int i=1;i<n+1;i++){
            max=Math.max(dist[i],max);
        }
        return (max==Integer.MAX_VALUE)?-1:max;

    }
}