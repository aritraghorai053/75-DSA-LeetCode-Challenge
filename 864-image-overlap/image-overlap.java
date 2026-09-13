import java.util.*;

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {

        List<int[]> a = new ArrayList<>();
        List<int[]> b = new ArrayList<>();

        int n = img1.length;

        // Store coordinates of 1s in img1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) {
                    a.add(new int[]{i, j});
                }

                if (img2[i][j] == 1) {
                    b.add(new int[]{i, j});
                }
            }
        }

        HashMap<String, Integer> map = new HashMap<>();

        int answer = 0;

        // Compare every 1 in img1 with every 1 in img2
        for (int[] x : a) {
            for (int[] y : b) {

                int dx = y[0] - x[0];
                int dy = y[1] - x[1];

                String key = dx + "," + dy;

                int count = map.getOrDefault(key, 0) + 1;

                map.put(key, count);

                answer = Math.max(answer, count);
            }
        }

        return answer;
    }
}