import java.util.Arrays;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = queries.length;
        int[] ans = new int[m];

        // Sort logs chronologically by timestamp
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        // Pair queries with their original indices and sort by query time
        int[][] sortedQueries = new int[m][2];
        for (int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        // serverCount tracks requests for server_id (1-indexed, up to n)
        int[] serverCount = new int[n + 1];
        int activeServers = 0;
        int left = 0;
        int right = 0;
        int logCount = logs.length;

        for (int[] q : sortedQueries) {
            int queryTime = q[0];
            int originalIdx = q[1];
            int windowStart = queryTime - x;

            // Expand window: include logs where time <= queryTime
            while (right < logCount && logs[right][1] <= queryTime) {
                int serverId = logs[right][0];
                if (serverCount[serverId] == 0) {
                    activeServers++;
                }
                serverCount[serverId]++;
                right++;
            }

            // Shrink window: exclude logs where time < windowStart
            while (left < logCount && logs[left][1] < windowStart) {
                int serverId = logs[left][0];
                serverCount[serverId]--;
                if (serverCount[serverId] == 0) {
                    activeServers--;
                }
                left++;
            }

            // Servers with zero requests = total servers - active servers
            ans[originalIdx] = n - activeServers;
        }

        return ans;
    }
}