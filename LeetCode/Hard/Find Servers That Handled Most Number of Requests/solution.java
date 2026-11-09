import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int n = arrival.length;
        int[] count = new int[k];

        // Min-heap to store busy servers: [free_time, server_id]
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // TreeSet to store available server IDs in sorted order
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        for (int i = 0; i < n; i++) {
            int time = arrival[i];
            int duration = load[i];

            // Free up servers that finished before or at current arrival time
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                available.add(busy.poll()[1]);
            }

            // If no servers are available, the request is dropped
            if (available.isEmpty()) {
                continue;
            }

            // Find the closest available server >= (i % k)
            Integer server = available.ceiling(i % k);
            if (server == null) {
                // Wrap around: take the smallest available server
                server = available.first();
            }

            // Assign the request to this server
            count[server]++;
            available.remove(server);
            busy.offer(new int[]{time + duration, server});
        }

        // Find the maximum handled requests
        int maxRequests = 0;
        for (int c : count) {
            maxRequests = Math.max(maxRequests, c);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == maxRequests) {
                result.add(i);
            }
        }

        return result;
    }
}