class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> free = new TreeSet<>();
        for (int i = 0; i < k; i++) free.add(i);
        PriorityQueue<long[]> busy =
            new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        int[] count = new int[k];
        for (int i = 0; i < arrival.length; i++) {
            int currentTime = arrival[i];
            while (!busy.isEmpty() && busy.peek()[0] <= currentTime) {
                long[] server = busy.poll();
                free.add((int) server[1]);
            }
            if (free.isEmpty()) continue;
            int preferred = i % k;
            Integer server = free.ceiling(preferred);
            if (server == null) server = free.first();
            count[server]++;
            free.remove(server);
            busy.offer(new long[]{(long) currentTime + load[i], server});
        }
        int max = 0;
        for (int c : count) max = Math.max(max, c);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == max) ans.add(i);
        }
        return ans;
    }
}