package algorithmanalysis_project;

import java.util.Random;


enum Algorithm {
    MergeSort2Way, MergeSort3Way, BottomUpMergesort
}

enum Create {
    RANDOM, INC, DEC
}

public class AlgorithmAnalysis_Project {


    public static void main(String[] args) {
        int sizes[] = {(int) 4e6, (int) 8e6, (int) 16e6, (int) 32e6, (int) 64e6, (int) 128e6, (int) 64e6, (int) 64e6};
        int arr[];
        long t0 = 0, t1 = 0;
        Algorithm algoithms[] = Algorithm.values();
        Create create = Create.RANDOM;
        String filename = "result.txt";
        String data = "Results\n";
        //MergeSort.sort(arr); // 2way actually
        //MergeSort3Way.sort(arr);
        //BottomUpMergeSort.sort(arr);
        FileOperation.writeFile(data, filename);

        Random r = new Random();
        for (Algorithm a : algoithms) { // try all sorting algorithms
            for (int i = 0; i < sizes.length; i++) {
                // craete array
                arr = new int[sizes[i]];
                // loop seed values
                for (int j = 0; j < 10; j++) {
                    data = "";
                    if (i < sizes.length - 2) {
                        create = Create.RANDOM;
                    } else if (i == sizes.length - 2) {
                        create = Create.INC;
                    } else if (i == sizes.length - 1) {
                        create = Create.DEC;
                    }

                    create_arr(arr, r, j*1000, create);

                    if (a == Algorithm.MergeSort2Way) {
                        t0 = System.currentTimeMillis();
                        MergeSort.sort(arr);
                        t1 = System.currentTimeMillis();
                    } else if (a == Algorithm.MergeSort3Way) {
                        t0 = System.currentTimeMillis();
                        MergeSort3Way.sort(arr);
                        t1 = System.currentTimeMillis();
                    } else if (a == Algorithm.BottomUpMergesort) {
                        t0 = System.currentTimeMillis();
                        BottomUpMergeSort.sort(arr);
                        t1 = System.currentTimeMillis();
                    }
                    data += "algorithm = " + a + ", size = " + i + ", seed = " + j + ", time = " + (t1 - t0) + " ms\n";
                    FileOperation.writeFile(data, filename);
                    System.out.println(data);
                }
            }
        }

    }

    public static void create_arr(int[] arr, Random r, int seed, Create c) {
        if (c == Create.RANDOM) {
            create_random_arr(arr, r, seed);
        } else if (c == Create.INC) {
            create_inc_arr(arr, r, seed);
        } else if (c == Create.DEC) {
            create_dec_arr(arr, r, seed);
        }
    }

    public static void create_random_arr(int[] arr, Random r, int seed) {
        r.setSeed(seed);   // set seed

        // assign random number to array
        for (int k = 0; k < arr.length; k++) {
            arr[k] = r.nextInt();
        }
    }
    
    // cretae an array with increasing
    public static void create_inc_arr(int[] arr, Random r, int seed) {
        r.setSeed(seed);   // set seed
        int value = r.nextInt();
        // assign random number to array
        for (int k = 0; k < arr.length; k++) {
            arr[k] = value++;
        }
    }
    
     // cretae an array with idecreasing
    public static void create_dec_arr(int[] arr, Random r, int seed) {
        r.setSeed(seed);   // set seed
        int value = r.nextInt();
        // assign random number to array
        for (int k = 0; k < arr.length; k++) {
            arr[k] = value--;
        }
    }

}
