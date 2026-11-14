class Solution {
    public int maxEqualSum(ArrayList<Integer> s1, ArrayList<Integer> s2, ArrayList<Integer> s3) {
        int sum1 = 0, sum2 = 0, sum3 = 0;

        for (int num : s1) sum1 += num;
        for (int num : s2) sum2 += num;
        for (int num : s3) sum3 += num;

        int i = 0, j = 0, k = 0;
        int n1 = s1.size(), n2 = s2.size(), n3 = s3.size();

        while (i < n1 && j < n2 && k < n3) {
            if (sum1 == sum2 && sum2 == sum3) {
                return sum1;
            }

            if (sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= s1.get(i++);
            } else if (sum2 >= sum1 && sum2 >= sum3) {
                sum2 -= s2.get(j++);
            } else {
                sum3 -= s3.get(k++);
            }
        }

        return 0;
    }
}