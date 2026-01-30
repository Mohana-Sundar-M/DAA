package Exp1;
class SelectionSort{
    void selectionSort(int[] arr){
        int n = arr.length;
        for(int i = 0; i<n-1;i++){
            int minIndex = i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        System.out.println("After Sort");
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}

public class Exp1 {
    public static void main(String[] args) {
        SelectionSort sr = new SelectionSort();
        int arr[] = {10,25,2,55,3};
        System.out.println("Before Sort");
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
        sr.selectionSort(arr);
    }
}
