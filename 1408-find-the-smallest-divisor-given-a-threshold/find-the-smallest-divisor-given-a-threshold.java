class Solution {
    public int smallestDivisor(int[] nums, int threshold) {

        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int low = 1;
        int high = max;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int sum = 0;

            for (int num : nums) {
                sum += (int) Math.ceil((double) num / mid);
            }

            if (sum <= threshold) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}