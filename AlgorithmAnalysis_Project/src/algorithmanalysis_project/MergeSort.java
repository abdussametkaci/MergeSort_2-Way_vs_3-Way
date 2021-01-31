package algorithmanalysis_project;

public class MergeSort {

    public static void sort(int arr[]) {
        int copy[] = new int[arr.length];
        sort(arr, copy, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int[] copy, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int m = lo + (hi - lo) / 2;
        sort(arr, copy, lo, m);     // sort left part
        sort(arr, copy, m + 1, hi); // sort right part
        merge(arr, copy, lo, m, hi); // merge sorted subarrays

    }

    // stably merge a[lo .. mid] with a[mid+1 ..hi] using copy[lo .. hi]
    private static void merge(int[] arr, int[] copy, int lo, int mid, int hi) {
        // copy
        for (int k = lo; k <= hi; k++) {
            copy[k] = arr[k];
        }
        
        // initial indexes of first and second subarrays
        int i = lo, j = mid + 1;
 
        int k = lo;
        // sort the subarrays
        while (i <= mid && j <= hi) {
            if (copy[i] <= copy[j]) {
                arr[k] = copy[i++];
            }
            else {
                arr[k] = copy[j++];
            }
            k++;
        }
        
        // copy remaining elements of left part if any
        while (i <= mid) {
            arr[k++] = copy[i++];
        }
 
        // copy remaining elements of right if any
        while (j <= hi) {
            arr[k++] = copy[j++];
        }
    }
}
