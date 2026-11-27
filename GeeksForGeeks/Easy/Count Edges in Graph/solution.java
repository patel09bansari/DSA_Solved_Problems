class Solution {
    public int countEdges(ArrayList<ArrayList<Integer>> adj) {
        int totalDegree = 0;

        for (ArrayList<Integer> neighbors : adj) {
            totalDegree += neighbors.size();
        }

        return totalDegree / 2;
    }
}