package demo;

public class BubbleSort {

    static int arr[] = {8,5,7,3,2};

    public static void main(String args[])
    {
            bubbleSort(arr,arr.length);
            for(int e:arr)
                System.out.println(e);

    }
    public static void bubbleSort(int []arr,int n)
    {
        boolean flag=false;
        for(int i=0; i<n-1;i++)
        {
            flag=false;
            for(int j=0;j<n-1-i;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    swap(j,j+1);
                    flag=true;
                }
            }
            if(!flag)
                return;
        }
    }

    public static void swap(int i,int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}
