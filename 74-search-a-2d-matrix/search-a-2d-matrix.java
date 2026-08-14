class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int lowRow = 0;
        int highRow = rows - 1;

        while (lowRow <= highRow) {

            int midRow = lowRow + (highRow - lowRow) / 2;

            if (target < matrix[midRow][0]) {
                highRow = midRow - 1;
            }
            else if (target > matrix[midRow][cols - 1]) {
                lowRow = midRow + 1;
            }
            else {
                // Target can exist in this row
                int low = 0;
                int high = cols - 1;

                while (low <= high) {

                    int mid = low + (high - low) / 2;

                    if (matrix[midRow][mid] == target) {
                        return true;
                    }
                    else if (matrix[midRow][mid] < target) {
                        low = mid + 1;
                    }
                    else {
                        high = mid - 1;
                    }
                }

                return false;
            }
        }

        return false;
    }
}
