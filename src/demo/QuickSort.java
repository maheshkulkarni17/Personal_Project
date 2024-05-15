package demo;

public class QuickSort {

    static int arr[] = {10,16,8,12,15,6,3,9,5,100};
    public static void main(String args[])
    {
        quickSort(0,arr.length-1);
        for(int e:arr)
            System.out.println(e);
    }

    private static void quickSort(int low, int high) {
        if(low<high) {
            int j = partition(low, high);
            quickSort(low, j);
            quickSort(j + 1, high);

        }
    }

    private static int partition(int l, int h) {
        int pivot = arr[l];
        int i=l,j=h;
        while(i<j)
        {
            do{
                i++;
            }while(arr[i]<=pivot);
            do{
                j--;
            }while(arr[j]>pivot);

            if(i<j)
                swap(i,j);

        }
        swap(l,j);
        return j;
    }
    public static void swap(int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }


}
