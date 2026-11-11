class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long c1 = cost1;
        long c2 = cost2;
        long cb = costBoth;
        long n1 = need1;
        long n2 = need2;

        long common = Math.min(n1, n2);
        long totalCost = common * Math.min(cb, c1 + c2);

        if (n1 > n2) {
            totalCost += (n1 - n2) * Math.min(c1, cb);
        } else if (n2 > n1) {
            totalCost += (n2 - n1) * Math.min(c2, cb);
        }

        return totalCost;
    }
}