import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> socialNetwork(int[] arr) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int n = arr.length + 1;

        for (int i = 2; i <= n; i++) {

            // distance[j] = number of links from i to j
            int[] distance = new int[i];

            int current = i;
            int steps = 0;

            while (current != 1) {

                current = arr[current - 2];
                steps++;

                distance[current] = steps;
            }

            // IMPORTANT:
            // Visit j in increasing order
            for (int j = 1; j < i; j++) {

                if (distance[j] != 0) {

                    ArrayList<Integer> temp = new ArrayList<>();

                    temp.add(i);
                    temp.add(j);
                    temp.add(distance[j]);

                    ans.add(temp);
                }
            }
        }

        return ans;
    }
}