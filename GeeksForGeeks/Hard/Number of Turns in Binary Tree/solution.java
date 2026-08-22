/* Structure of Binary Tree Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    int turns = 0;

    public int numberOfTurns(Node root, int p, int q) {
        Node lca = findLCA(root, p, q);

        // Case 1: p is an ancestor of q
        if (lca.data == p) {
            turns = 0;
            countTurns(lca.left, true, q, 0);
            countTurns(lca.right, false, q, 0);
            return turns == 0 ? -1 : turns;
        }

        // Case 2: q is an ancestor of p
        if (lca.data == q) {
            turns = 0;
            countTurns(lca.left, true, p, 0);
            countTurns(lca.right, false, p, 0);
            return turns == 0 ? -1 : turns;
        }

        // Case 3: p and q are in separate subtrees of LCA
        turns = 0;
        int turnsP = 0, turnsQ = 0;

        countTurns(lca.left, true, p, 0);
        countTurns(lca.right, false, p, 0);
        turnsP = turns;

        turns = 0;
        countTurns(lca.left, true, q, 0);
        countTurns(lca.right, false, q, 0);
        turnsQ = turns;

        return turnsP + turnsQ + 1;
    }

    private Node findLCA(Node node, int p, int q) {
        if (node == null) return null;
        if (node.data == p || node.data == q) return node;

        Node left = findLCA(node.left, p, q);
        Node right = findLCA(node.right, p, q);

        if (left != null && right != null) return node;
        return left != null ? left : right;
    }

    private boolean countTurns(Node node, boolean isLeft, int target, int currentTurns) {
        if (node == null) return false;

        if (node.data == target) {
            turns = currentTurns;
            return true;
        }

        if (isLeft) {
            if (countTurns(node.left, true, target, currentTurns)) return true;
            if (countTurns(node.right, false, target, currentTurns + 1)) return true;
        } else {
            if (countTurns(node.right, false, target, currentTurns)) return true;
            if (countTurns(node.left, true, target, currentTurns + 1)) return true;
        }

        return false;
    }
}