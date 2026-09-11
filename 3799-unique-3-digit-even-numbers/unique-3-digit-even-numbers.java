class Solution {
    public int totalNumbers(int[] digits) {

        int[] freq = new int[10];

        // Count frequency of each digit
        for (int digit : digits) {
            freq[digit]++;
        }

        int count = 0;

        // Generate every 3-digit even number
        for (int num = 100; num <= 998; num += 2) {

            int a = num / 100;        // hundreds
            int b = (num / 10) % 10;  // tens
            int c = num % 10;         // units

            // Check if digits are available
            freq[a]--;

            if (freq[a] >= 0) {
                freq[b]--;

                if (freq[b] >= 0) {
                    freq[c]--;

                    if (freq[c] >= 0) {
                        count++;
                    }

                    freq[c]++;
                }

                freq[b]++;
            }

            freq[a]++;
        }

        return count;
    }
}