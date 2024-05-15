package SearchingAlgorithms;

public class InsertionSort {
    static int arr[] = {8,5,7,3,2};
    public static void main(String []args)
    {
        InsertionSortFun(arr,arr.length);
        for(int e:arr)
            System.out.println(e);
    }

    private static void InsertionSortFun(int[] A, int n) {


        for(int i=1;i<n;i++)
        {
            int ele=arr[i];
            int j=i-1;
            while(j>=0 && A[j]>ele)
            {
                A[j+1]=A[j];
                j--;
            }
            arr[j+1]=ele;
        }
    }

    private static void swap(int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
