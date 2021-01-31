package algorithmanalysis_project;


public class BottomUpMergeSort {

    public static void sort(int[] a) {
        int n = a.length;
        int[] copy = new int[n];
        int mid, hi ,num1, num2;
        for (int len = 1; len < n; len *= 2) {
            for (int lo = 0; lo < n - len; lo += len + len) {
                mid = lo + len - 1;
                num1 = lo + len + len - 1;
                num2 = n - 1;
                hi = num1 < num2 ? num1 : num2;
                merge(a, copy, lo, mid, hi);
            }

        }

    }

    private static void merge(int[] arr, int[] copy, int lo, int mid, int hi) {
        // copy
        for (int k = lo; k <= hi; k++) {
            copy[k] = arr[k];
        }

        // initial indexes of first and second subarrays
        int i = lo, j = mid + 1;

        // initial index of merged subarry array
        int k = lo;
        while (i <= mid && j <= hi) {
            if (copy[i] <= copy[j]) {
                arr[k] = copy[i++];
            } else {
                arr[k] = copy[j++];
            }
            k++;
        }

        // copy remaining elements of left part if any
        while (i <= mid) {
            arr[k++] = copy[i++];
        }

        // copy remaining elements of right part if any
        while (j <= hi) {
            arr[k++] = copy[j++];
        }
    }

}
