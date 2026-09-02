import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solve(int n, String s) {
        Set<Character> occupied = new HashSet<>();
        Set<Character> rejected = new HashSet<>();
        int unassignedCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char customer = s.charAt(i);

            // If customer was previously rejected, departure event does nothing extra
            if (rejected.contains(customer)) {
                continue;
            }

            // Customer arrives
            if (!occupied.contains(customer)) {
                if (occupied.size() < n) {
                    occupied.add(customer); // Assign computer
                } else {
                    rejected.add(customer); // Reject customer
                    unassignedCount++;
                }
            } else {
                // Customer departs
                occupied.remove(customer);
            }
        }

        return unassignedCount;
    }
}