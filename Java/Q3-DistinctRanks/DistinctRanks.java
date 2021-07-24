
// Java Implementation of above approach
import java.util.*;

class DisctictRanks {

    // function to find minimum increment required
    static int minIncrementForUnique(int[] input2) {
        // collect frequency of each element
        TreeMap<Integer, Integer> dict = new TreeMap<Integer, Integer>();
        HashSet<Integer> used = new HashSet<Integer>();

        // Load Frequency Map (Element -> Count) and Used Set
        for (int i : input2) {
            if (dict.containsKey(i))
                dict.put(i, dict.get(i) + 1);
            else {
                dict.put(i, 1);
                used.add(i);
            }
        }

        int maxUsed = 0; // Works for +ve numbers
        int ans = 0;

        for (Map.Entry<Integer, Integer> entry : dict.entrySet()) {

            int value = entry.getKey();
            int freq = entry.getValue();

            if (freq <= 1) // If not a duplicate, skip
                continue;

            int duplicates = freq - 1; // Number of duplicates 1 less than count

            // Start with next best option for this duplicate:
            // CurNum + 1 or an earlier maximum number that has been used
            int cur = Math.max(value + 1, maxUsed);
            while (duplicates > 0) {
                if (!used.contains(cur)) {
                    ans += cur - value; // Number of increments = Available Spot - Duplicate Value
                    used.add(cur);
                    duplicates--;
                    maxUsed = cur;
                }
                cur++;
            }
        }

        // return answer
        return ans;
    }

    // Driver code

    public static void main(String[] args) {
        int[] A = { 1, 1, 3, 4 };
        System.out.print(minIncrementForUnique(A));
    }
}

// This code is contributed by Aditya
