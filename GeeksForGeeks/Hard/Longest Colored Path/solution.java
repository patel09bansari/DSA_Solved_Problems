import java.util.*;

class Solution {

    private int[] head;
    private int[] to;
    private int[] next;
    private int edgeCount;

    private int answer;

    public int longestPath(String s, int[][] edges) {

        int n = s.length();

        head = new int[n + 1];
        Arrays.fill(head, -1);

        to = new int[2 * (n - 1)];
        next = new int[2 * (n - 1)];

        edgeCount = 0;

        for (int[] edge : edges) {
            addEdge(edge[0], edge[1]);
            addEdge(edge[1], edge[0]);
        }

        answer = 1;

        /*
         * Use iterative DFS because n can be 100000.
         * Recursive DFS can cause StackOverflowError.
         */
        int[] parent = new int[n + 1];
        int[] order = new int[n];

        int count = 0;

        order[count++] = 1;
        parent[1] = -1;

        for (int i = 0; i < count; i++) {

            int u = order[i];

            for (int e = head[u]; e != -1; e = next[e]) {

                int v = to[e];

                if (v == parent[u]) {
                    continue;
                }

                parent[v] = u;
                order[count++] = v;
            }
        }

        /*
         * same[u]:
         * Longest path starting at u consisting only of
         * the color of u.
         *
         * mixed[u]:
         * Longest valid path starting at u containing both
         * colors and having at most one transition.
         */
        int[] same = new int[n + 1];
        int[] mixed = new int[n + 1];

        /*
         * Process bottom-up.
         */
        for (int i = n - 1; i >= 0; i--) {

            int u = order[i];

            char color = s.charAt(u - 1);

            /*
             * sameList:
             *
             * Children having the SAME color as u.
             *
             * Their same[v] can be extended through u.
             */
            int bestSame1 = 0;
            int bestSame2 = 0;

            int bestSameId1 = -1;
            int bestSameId2 = -1;

            /*
             * mixedList:
             *
             * A valid mixed arm that can be extended from u.
             *
             * There are two possibilities:
             *
             * 1. Child has same color:
             *       u -> same-color ... -> transition
             *
             * 2. Child has opposite color:
             *       u -> opposite-color ...
             *
             * In either case, u -> child is valid.
             */
            int bestMixed1 = 0;
            int bestMixed2 = 0;

            int bestMixedId1 = -1;
            int bestMixedId2 = -1;

            for (int e = head[u]; e != -1; e = next[e]) {

                int v = to[e];

                /*
                 * Only process children.
                 */
                if (parent[v] != u) {
                    continue;
                }

                char childColor = s.charAt(v - 1);

                /*
                 * ------------------------------------
                 * SAME-COLOR CHILD
                 * ------------------------------------
                 */
                if (childColor == color) {

                    int value = same[v];

                    // Keep top two same-color branches.
                    if (value > bestSame1) {

                        bestSame2 = bestSame1;
                        bestSameId2 = bestSameId1;

                        bestSame1 = value;
                        bestSameId1 = v;

                    } else if (value > bestSame2) {

                        bestSame2 = value;
                        bestSameId2 = v;
                    }

                    /*
                     * A mixed path inside this child can
                     * continue through u.
                     */
                    if (mixed[v] > 0) {

                        value = mixed[v];

                        if (value > bestMixed1) {

                            bestMixed2 = bestMixed1;
                            bestMixedId2 = bestMixedId1;

                            bestMixed1 = value;
                            bestMixedId1 = v;

                        } else if (value > bestMixed2) {

                            bestMixed2 = value;
                            bestMixedId2 = v;
                        }
                    }

                }

                /*
                 * ------------------------------------
                 * OPPOSITE-COLOR CHILD
                 * ------------------------------------
                 *
                 * If u = R and child = B:
                 *
                 *     R -> B -> B -> B
                 *
                 * is valid.
                 *
                 * If u = B and child = R:
                 *
                 *     B -> R
                 *
                 * is not R*B* in this direction,
                 * BUT the same undirected path can be
                 * traversed as R -> B, so it is still
                 * a valid path.
                 *
                 * Therefore the opposite-color child's
                 * same-color arm can be used as the
                 * mixed arm.
                 */
                else {

                    int value = same[v];

                    if (value > bestMixed1) {

                        bestMixed2 = bestMixed1;
                        bestMixedId2 = bestMixedId1;

                        bestMixed1 = value;
                        bestMixedId1 = v;

                    } else if (value > bestMixed2) {

                        bestMixed2 = value;
                        bestMixedId2 = v;
                    }
                }
            }

            /*
             * ------------------------------------
             * STATE: same[u]
             * ------------------------------------
             */
            same[u] = 1 + bestSame1;

            /*
             * ------------------------------------
             * STATE: mixed[u]
             * ------------------------------------
             *
             * One child provides the mixed/transition
             * part.
             */
            if (bestMixed1 > 0) {
                mixed[u] = 1 + bestMixed1;
            } else {
                mixed[u] = 0;
            }

            /*
             * At least the single node itself is valid.
             */
            answer = Math.max(answer, same[u]);
            answer = Math.max(answer, mixed[u]);

            /*
             * ------------------------------------
             * COMBINE TWO SAME-COLOR BRANCHES
             * ------------------------------------
             *
             *          u
             *         / \
             *        C   C
             *
             * This gives a monochromatic path.
             */
            if (bestSame2 > 0) {

                answer = Math.max(
                    answer,
                    1 + bestSame1 + bestSame2
                );
            }

            /*
             * ------------------------------------
             * COMBINE SAME + MIXED
             * ------------------------------------
             *
             *          u
             *         / \
             *      same mixed
             *
             * The two branches MUST be different.
             *
             * We only need the top two candidates from
             * each group.
             */
            if (bestSame1 > 0 && bestMixed1 > 0) {

                if (bestSameId1 != bestMixedId1) {

                    answer = Math.max(
                        answer,
                        1 + bestSame1 + bestMixed1
                    );

                } else {

                    /*
                     * The best candidates came from the
                     * same child, so try the second-best
                     * candidate.
                     */
                    if (bestSame2 > 0) {

                        answer = Math.max(
                            answer,
                            1 + bestSame2 + bestMixed1
                        );
                    }

                    if (bestMixed2 > 0) {

                        answer = Math.max(
                            answer,
                            1 + bestSame1 + bestMixed2
                        );
                    }
                }
            }
        }

        return answer;
    }

    private void addEdge(int u, int v) {

        to[edgeCount] = v;
        next[edgeCount] = head[u];
        head[u] = edgeCount++;

    }
}