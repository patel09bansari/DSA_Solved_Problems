class Solution {

    void findLeafLevels(Node root, int level, ArrayList<Integer> levels) {
        if (root == null) {
            return;
        }

        // If current node is a leaf
        if (root.left == null && root.right == null) {
            levels.add(level);
            return;
        }

        findLeafLevels(root.left, level + 1, levels);
        findLeafLevels(root.right, level + 1, levels);
    }

    int getCount(Node root, int k) {

        ArrayList<Integer> levels = new ArrayList<>();

        // Root is at level 1
        findLeafLevels(root, 1, levels);

        // Visit cheapest leaves first
        Collections.sort(levels);

        int count = 0;
        int cost = 0;

        for (int level : levels) {

            if (cost + level <= k) {
                cost += level;
                count++;
            } else {
                break;
            }
        }

        return count;
    }
}