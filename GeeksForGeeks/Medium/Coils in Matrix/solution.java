import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> formCoils(int n) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        int m = 8 * n * n;

        ArrayList<Integer> coil = new ArrayList<>();

        // Starting value
        int curr = 8 * n * n + 2 * n;

        coil.add(curr);

        int flag = 1;
        int step = 2;

        while (coil.size() < m) {

            // Vertical movement
            for (int i = 0; i < step && coil.size() < m; i++) {
                curr -= 4 * n * flag;
                coil.add(curr);
            }

            // Horizontal movement
            for (int i = 0; i < step && coil.size() < m; i++) {
                curr += flag;
                coil.add(curr);
            }

            flag = -flag;
            step += 2;
        }

        /*
         * 'coil' currently is:
         * 10 6 2 3 4 8 12 16  for n = 1
         *
         * The required answer uses the reverse of this
         * as the second coil.
         */
        ArrayList<Integer> coil1 = new ArrayList<>();
        ArrayList<Integer> coil2 = new ArrayList<>();

        int total = 16 * n * n + 1;

        // Required coil 1 = complement of reversed coil
        for (int i = m - 1; i >= 0; i--) {
            coil1.add(total - coil.get(i));
        }

        // Required coil 2 = reversed original coil
        for (int i = m - 1; i >= 0; i--) {
            coil2.add(coil.get(i));
        }

        ans.add(coil1);
        ans.add(coil2);

        return ans;
    }
}
