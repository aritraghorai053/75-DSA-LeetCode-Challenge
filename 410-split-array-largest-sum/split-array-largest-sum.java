class Solution {

    // Counts the number of subarrays needed if the maximum allowed sum is maxSum
    private int countPartitions(int[] nums, int maxSum) {
        int partitions = 1;
        long subarraySum = 0;

        for (int num : nums) {
            if (subarraySum + num <= maxSum) {
                subarraySum += num;
            } else {
                partitions++;
                subarraySum = num;
            }
        }
        return partitions;
    }

    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0;

        // Search space:
        // low = maximum element
        // high = sum of all elements
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int partitions = countPartitions(nums, mid);

            if (partitions > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}