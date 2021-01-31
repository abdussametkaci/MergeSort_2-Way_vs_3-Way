package algorithmanalysis_project;

public class MergeSort3Way {

    public static void sort(int arr[]) {
        if(arr.length == 0){
            return;
        }
        int copy[] = new int[arr.length];
        sort(arr, copy, 0, arr.length);
    }

    private static void sort(int[] arr, int[] copy, int lo, int hi) {
        if (hi - lo < 2) {
            return;
        }

        // split arrays (3 parts)
        int mid1 = lo + ((hi - lo) / 3);
        int mid2 = lo + 2 * ((hi - lo) / 3) + 1;

        sort(arr, copy, lo, mid1);      // first part
        sort(arr, copy, mid1, mid2);    // second part
        sort(arr, copy, mid2, hi);      // last part

        // merging the sorted arrays 
        merge(arr, copy, lo, mid1, mid2, hi);

    }

    private static void merge(int[] arr, int[] copy, int lo, int mid1, int mid2, int hi) {
        // copy
        for (int k = lo; k < hi; k++) {
            copy[k] = arr[k];
        }

        int i = lo, j = mid1, k = mid2, l = lo; // initials indexes
        // sort the subarrays
        while ((i < mid1) && (j < mid2) && (k < hi)) {
            if (copy[i] < copy[j]) {
                if (copy[i] < copy[k]) {
                    arr[l] = copy[i++];
                } else {
                    arr[l] = copy[k++];
                }
            } else {
                if (copy[j] < copy[k]) {
                    arr[l] = copy[j++];
                } else {
                    arr[l] = copy[k++];
                }
            }
            l++;
        }

        // case where first and second ranges have remaining values 
        while ((i < mid1) && (j < mid2)) {
            if (copy[i] < copy[j]) {
                arr[l] = copy[i++];
            } else {
                arr[l] = copy[j++];
            }
            l++;
        }

        // case where second and third ranges have remaining values
        while ((j < mid2) && (k < hi)) {
            if (copy[j] < copy[k]) {
                arr[l] = copy[j++];
            } else {
                arr[l] = copy[k++];
            }
            l++;
        }

        // case where first and third ranges have  remaining values 
        while ((i < mid1) && (k < hi)) {
            if (copy[i] < copy[k]) {
                arr[l] = copy[i++];
            } else {
                arr[l] = copy[k++];
            }
            l++;
        }

        // copy remaining values from the first part  
        while (i < mid1) {
            arr[l++] = copy[i++];
        }

        // copy remaining values from the second part  
        while (j < mid2) {
            arr[l++] = copy[j++];
        }

        // copy remaining values from the third part  
        while (k < hi) {
            arr[l++] = copy[k++];
        }

    }
}
