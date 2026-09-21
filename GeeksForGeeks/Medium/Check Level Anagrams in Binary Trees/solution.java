import java.util.*;

/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    public boolean areAnagrams(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();

        q1.add(root1);
        q2.add(root2);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            int n1 = q1.size();
            int n2 = q2.size();

            // If level sizes differ, they cannot be anagrams
            if (n1 != n2) return false;

            List<Integer> l1 = new ArrayList<>();
            List<Integer> l2 = new ArrayList<>();

            for (int i = 0; i < n1; i++) {
                Node node1 = q1.poll();
                Node node2 = q2.poll();

                l1.add(node1.data);
                l2.add(node2.data);

                if (node1.left != null) q1.add(node1.left);
                if (node1.right != null) q1.add(node1.right);

                if (node2.left != null) q2.add(node2.left);
                if (node2.right != null) q2.add(node2.right);
            }

            // Sort level nodes to check if they are anagrams
            Collections.sort(l1);
            Collections.sort(l2);

            if (!l1.equals(l2)) return false;
        }

        return q1.isEmpty() && q2.isEmpty();
    }
}