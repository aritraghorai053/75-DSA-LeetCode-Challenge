import java.util.Arrays;

class Solution {

    public long calculateTotalHours(int[] piles, int speed) {
        long totalH = 0;

        for (int bananas : piles) {
            totalH += (bananas + speed - 1L) / speed;
        }

        return totalH;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = Arrays.stream(piles).max().getAsInt();

        int low = 1, high = maxPile;
        int ans = maxPile;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            long totalH = calculateTotalHours(piles, mid);

            if (totalH <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}