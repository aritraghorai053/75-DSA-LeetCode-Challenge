class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int maxi = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) {
                sum = 0;
            }

            sum += nums[i];

            if (sum > maxi) {
                maxi = sum;
            }
        }

        return maxi;
    }
}