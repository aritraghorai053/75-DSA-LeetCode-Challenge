import java.util.*;

class Solution {

    private void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();

        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left++]);
            } else {
                temp.add(arr[right++]);
            }
        }

        while (left <= mid) {
            temp.add(arr[left++]);
        }

        while (right <= high) {
            temp.add(arr[right++]);
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    private int countPairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int cnt = 0;

        for (int i = low; i <= mid; i++) {
            while (right <= high && (long) arr[i] > 2L * arr[right]) {
                right++;
            }
            cnt += right - (mid + 1);
        }

        return cnt;
    }

    private int mergeSort(int[] arr, int low, int high) {
        if (low >= high) {
            return 0;
        }

        int mid = low + (high - low) / 2;

        int cnt = 0;

        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid + 1, high);

        cnt += countPairs(arr, low, mid, high);

        merge(arr, low, mid, high);

        return cnt;
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
}