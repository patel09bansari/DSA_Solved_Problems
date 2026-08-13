class Solution {
    class Node {
        int maxLen;
        int prefixLen;
        int suffixLen;
        char leftChar;
        char rightChar;

        Node() {}
    }

    private Node[] tree;
    private char[] chars;

    private Node merge(Node left, Node right, int leftLen, int rightLen) {
        Node res = new Node();
        res.leftChar = left.leftChar;
        res.rightChar = right.rightChar;
        res.maxLen = Math.max(left.maxLen, right.maxLen);

        // Check if middle boundary characters match
        if (left.rightChar == right.leftChar) {
            res.maxLen = Math.max(res.maxLen, left.suffixLen + right.prefixLen);

            // Update prefix length if left child is entirely one character
            if (left.prefixLen == leftLen) {
                res.prefixLen = left.prefixLen + right.prefixLen;
            } else {
                res.prefixLen = left.prefixLen;
            }

            // Update suffix length if right child is entirely one character
            if (right.suffixLen == rightLen) {
                res.suffixLen = right.suffixLen + left.suffixLen;
            } else {
                res.suffixLen = right.suffixLen;
            }
        } else {
            res.prefixLen = left.prefixLen;
            res.suffixLen = right.suffixLen;
        }

        return res;
    }

    private void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = new Node();
            tree[node].maxLen = 1;
            tree[node].prefixLen = 1;
            tree[node].suffixLen = 1;
            tree[node].leftChar = chars[start];
            tree[node].rightChar = chars[start];
            return;
        }

        int mid = start + (end - start) / 2;
        int leftChild = 2 * node;
        int rightChild = 2 * node + 1;

        build(leftChild, start, mid);
        build(rightChild, mid + 1, end);

        tree[node] = merge(tree[leftChild], tree[rightChild], mid - start + 1, end - mid);
    }

    private void update(int node, int start, int end, int idx, char ch) {
        if (start == end) {
            chars[idx] = ch;
            tree[node].leftChar = ch;
            tree[node].rightChar = ch;
            return;
        }

        int mid = start + (end - start) / 2;
        int leftChild = 2 * node;
        int rightChild = 2 * node + 1;

        if (idx <= mid) {
            update(leftChild, start, mid, idx, ch);
        } else {
            update(rightChild, mid + 1, end, idx, ch);
        }

        tree[node] = merge(tree[leftChild], tree[rightChild], mid - start + 1, end - mid);
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        chars = s.toCharArray();
        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int k = queryIndices.length;
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            int idx = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            update(1, 0, n - 1, idx, ch);
            ans[i] = tree[1].maxLen;
        }

        return ans;
    }
}