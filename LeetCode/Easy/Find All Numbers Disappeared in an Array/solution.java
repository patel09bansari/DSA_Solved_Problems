class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int s = 1;
        int e = nums.length;
        List<Integer> miss = new ArrayList<>();

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for(int i=s; i<=e; i++){
        if (!set.contains(i)) {
            miss.add(i);
        }
    } return miss;
}
}