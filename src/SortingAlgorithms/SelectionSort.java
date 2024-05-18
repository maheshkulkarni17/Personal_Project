package SortingAlgorithms;

public class SelectionSort {
    static int arr[] = {8,6,3,2,4,5};
    public static void main(String []args)
    {
        SelectionSortFun(arr,arr.length);
        for(int e:arr)
            System.out.println(e);
    }
    private static void SelectionSortFun(int[] A, int n) {
        for(int i=0;i<n;i++)
        {
            int j=i,k=i;

            for(;k<n;k++)
            {
                if(A[k]<A[j])
                    j=k;

            }
            swap(i,j);
        }
    }

    private static void swap(int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
