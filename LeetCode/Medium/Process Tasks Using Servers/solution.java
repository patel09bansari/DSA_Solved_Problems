import java.util.PriorityQueue;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;
        int[] ans = new int[m];

        // freeServers: [weight, index]
        PriorityQueue<int[]> freeServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        // busyServers: [freeTime, weight, index]
        // Note: freeTime can exceed standard 32-bit int, store as long or handle carefully
        PriorityQueue<long[]> busyServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Long.compare(a[0], b[0]);
            if (a[1] != b[1]) return Long.compare(a[1], b[1]);
            return Long.compare(a[2], b[2]);
        });

        for (int i = 0; i < n; i++) {
            freeServers.offer(new int[]{servers[i], i});
        }

        long currentTime = 0;

        for (int j = 0; j < m; j++) {
            currentTime = Math.max(currentTime, (long) j);

            // Free up servers whose tasks have finished by currentTime
            while (!busyServers.isEmpty() && busyServers.peek()[0] <= currentTime) {
                long[] server = busyServers.poll();
                freeServers.offer(new int[]{(int) server[1], (int) server[2]});
            }

            // If no servers are available, jump time forward to when the next server frees up
            if (freeServers.isEmpty()) {
                currentTime = busyServers.peek()[0];
                while (!busyServers.isEmpty() && busyServers.peek()[0] <= currentTime) {
                    long[] server = busyServers.poll();
                    freeServers.offer(new int[]{(int) server[1], (int) server[2]});
                }
            }

            // Assign the task to the top available server
            int[] chosen = freeServers.poll();
            ans[j] = chosen[1];
            busyServers.offer(new long[]{currentTime + tasks[j], (long) chosen[0], (long) chosen[1]});
        }

        return ans;
    }
}