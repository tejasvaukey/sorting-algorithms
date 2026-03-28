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

    // QUICK SORT - divide and conquer with space complexity - O(1), time complexity - O(nlogn)
    private static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low-1;
        for (int j = low; j < high; j++) {
            if(arr[j] < pivot){
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;
        return i;
    }
    public static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    // MERGE SORT - divide and conquer with space complexity - O(n), time complexity - O(nlogn)
    private static void merge(int[] arr, int l, int mid, int r) {
        int n1 = mid - l +1;
        int n2 = r - mid;
        int lArr[] = new int[n1];
        int rArr[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            lArr[i] = arr[l+i];
        }
        for (int i = 0; i < n2; i++) {
            rArr[i] = arr[mid+1+i];
        }

        int i=0, j=0, k=l;
        while(i<n1 && j<n2){
            if(lArr[i] <= rArr[j]){
                arr[k] = lArr[i];
                i++;
            } else {
                arr[k] = rArr[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k] = lArr[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k] = rArr[j];
            j++;
            k++;
        }
    }
    public static void mergeSort(int[] arr, int l, int r){
        if(l<r){
            int mid = (l+r)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);

            merge(arr, l, mid, r);
        }
     }



    public static void main(String[] args){
        int[] arr = {3,6,7,5,4,1,2};
        mergeSort(arr, 0, arr.length-1);
        print(arr);

    }
}