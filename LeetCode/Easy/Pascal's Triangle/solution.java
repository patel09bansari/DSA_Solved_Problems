import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numrows) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < numrows; i++) {
            List<Integer> row = new ArrayList<>();    //each row
            
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    int prev1 = res.get(i - 1).get(j - 1) + res.get(i - 1).get(j);
                    row.add(prev1);
                }
            }
            res.add(row);
        }
        return res;
    }
}