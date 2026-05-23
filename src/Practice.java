import java.util.Arrays;
import java.util.Random;


public class Practice {
    // selection sort - find the lowest and its index and then swap it at the right position
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void selectionSort(int[] arr){
        int len = arr.length;
        for (int i = 0; i < len-1; i++) {
            int min = arr[i];
            int idx = i;
            for (int j = i+1; j < len; j++) {
                if(arr[j] < min) {
                    min = arr[j];
                    idx = j;
                }
            }
            swap(arr, i, idx);
        }
    }
    // insertion - like arranging cards, picking one comparing backwards and then swap
    public static void insertionSort(int[] arr){
        // assuming 1st element is already sorted
        for (int i = 1; i < arr.length; i++) {
            int currVal = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j] > currVal){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = currVal;
        }
    }
    // bubble - simple compare swap
    public static void bubbleSort(int[] arr){
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length-1-j; i++) { // no need to check last values
                if(arr[i] > arr[i+1]){
                swap(arr, i+1, i);
                }
            }
        }
    }


    public static void mergeSort(int[] arr){
        int len = arr.length;
        if(len < 2) return;

        int midIdx = len/2;
        int[] leftHalf = new int[midIdx];
        int[] rightHalf = new int[len - midIdx];

        for (int i = 0; i < midIdx; i++) {
            leftHalf[i] = arr[i];
        }
        for (int i = midIdx; i < len; i++) {
            rightHalf[i - midIdx] = arr[i];
        }

        mergeSort(leftHalf); mergeSort(rightHalf);

        merge(arr, leftHalf, rightHalf);

    }
    private static void merge(int[] arr, int[] leftHalf, int[] rightHalf){
        int leftSize = leftHalf.length, rightSize = rightHalf.length;
        int i = 0, j = 0, k = 0;
        while(i < leftSize && j < rightSize){
            if(leftHalf[i] <= rightHalf[j]){
                arr[k] = leftHalf[i];
                i++;
            } else {
                arr[k] = rightHalf[j];
                j++;
            }
            k++;
        }
        while(i < leftSize){
            arr[k++] = leftHalf[i++];
        }
        while(j < rightSize){
            arr[k++] = rightHalf[j++];
        }
    }



    static void main(String[] args) {
        int[] numbers = new int[5];
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(10);
        }
        System.out.println(Arrays.toString(numbers));
        long startTime = System.currentTimeMillis();
        mergeSort(numbers);
        long endTime = System.currentTimeMillis();
        System.out.println("Took "+ (endTime - startTime) +"ms");
        System.out.println(Arrays.toString(numbers));
    }
}
