class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> free = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            free.add(i);
        }

        PriorityQueue<int[]> busy =
            new PriorityQueue<>((a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            });

        int[] count = new int[k];
        int max = 0;

        for (int i = 0; i < arrival.length; i++) {
            int time = arrival[i];

            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                free.add(busy.poll()[1]);
            }

            if (free.isEmpty()) {
                continue;
            }

            Integer server = free.ceiling(i % k);
            if (server == null) {
                server = free.first();
            }

            free.remove(server);
            count[server]++;

            if (count[server] > max) {
                max = count[server];
            }

            busy.offer(new int[]{time + load[i], server});
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                ans.add(i);
            }
        }

        return ans;
    }
}