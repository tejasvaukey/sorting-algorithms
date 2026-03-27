class Main{

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] +" ");
        }
        System.out.println();
    }

    // SELECTION SORT - select minimum and put it in the right place
    public static void selectionSort(int[] arr) {
        int min;
        for (int i = 0; i < arr.length-1; i++) {
            min = i;
            for (int j = i; j < arr.length; j++) {
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    // BUBBLE SORT - opposite - pushes maximum to the last - adjacent swaps
    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i- 1; j++) {
                if(arr[j] > arr[j+1]) swap(arr, j, j+1);
            }
        }
    }

    // INSERTION SORT -  takes element and places it in its correct position
    public static void insertionSort(int[] arr){
        int key;
        for (int i = 0; i < arr.length; i++) {
            key = arr[i];
            int j = i - 1;
            while(j>=0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    public static void main(String[] args){
        int[] arr = {34,16,37,45,67,12,21};
        insertionSort(arr);
        print(arr);

    }
}