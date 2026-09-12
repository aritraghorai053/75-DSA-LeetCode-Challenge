import java.util.*;

class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        // start, end, weight, original index
        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        // Sort by end time
        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        // Find previous non-overlapping interval
        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {

            int left = 0;
            int right = i - 1;
            prev[i] = -1;

            while (left <= right) {

                int mid = left + (right - left) / 2;

                if (arr[mid][1] < arr[i][0]) {
                    prev[i] = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        // dp[k][i] = maximum score using at most k intervals
        // among first i intervals
        long[][] dp = new long[5][n + 1];

        List<Integer>[][] path = new ArrayList[5][n + 1];

        for (int k = 0; k <= 4; k++) {
            for (int i = 0; i <= n; i++) {
                path[k][i] = new ArrayList<>();
            }
        }

        for (int i = 1; i <= n; i++) {

            for (int k = 1; k <= 4; k++) {

                // Option 1: Don't take current interval
                dp[k][i] = dp[k][i - 1];
                path[k][i] = new ArrayList<>(path[k][i - 1]);

                // Option 2: Take current interval
                int p = prev[i - 1] + 1;

                long take = dp[k - 1][p] + arr[i - 1][2];

                List<Integer> takePath =
                    new ArrayList<>(path[k - 1][p]);

                takePath.add(arr[i - 1][3]);

                // Sort before comparing lexicographically
                Collections.sort(takePath);

                if (take > dp[k][i] ||
                    (take == dp[k][i] &&
                     smaller(takePath, path[k][i]))) {

                    dp[k][i] = take;
                    path[k][i] = takePath;
                }
            }
        }

        List<Integer> ans = path[4][n];

        Collections.sort(ans);

        int[] result = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }

    // Check lexicographically smaller list
    private boolean smaller(List<Integer> a, List<Integer> b) {

        int n = Math.min(a.size(), b.size());

        for (int i = 0; i < n; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }
}