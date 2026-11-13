class Solution {
    public static ArrayList<Integer> findCommon(Node r1, Node r2) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        while (true) {
            // Push all left nodes of first BST
            while (r1 != null) {
                s1.push(r1);
                r1 = r1.left;
            }
            // Push all left nodes of second BST
            while (r2 != null) {
                s2.push(r2);
                r2 = r2.left;
            }

            // If either stack is empty, no more common nodes can exist
            if (s1.isEmpty() || s2.isEmpty()) {
                break;
            }

            Node top1 = s1.peek();
            Node top2 = s2.peek();

            // Case 1: Match found
            if (top1.data == top2.data) {
                result.add(top1.data);
                s1.pop();
                s2.pop();
                // Move to the right subtrees
                r1 = top1.right;
                r2 = top2.right;
            } 
            // Case 2: First BST's current smallest node is smaller
            else if (top1.data < top2.data) {
                s1.pop();
                r1 = top1.right;
            } 
            // Case 3: Second BST's current smallest node is smaller
            else {
                s2.pop();
                r2 = top2.right;
            }
        }

        return result;
    }
}