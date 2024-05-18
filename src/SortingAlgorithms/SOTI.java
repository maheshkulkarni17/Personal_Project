package SortingAlgorithms;

import java.util.ArrayList;

public class SOTI {
    static int []arr = {9,3,7,5,6,4,8,2};

    static ArrayList<Integer> arrayList = new ArrayList<>();
    public static void main(String []args)
    {
        System.out.println("This is practice session");
        int []A = {2,8,15,18};
        int []B = {5,9,12,17,20,25};

        int C[] = twoWayMerging(A,B);


//        for(int e:C)
//        {
//            System.out.println(e);
//        }

        mergeSort(arr,0,arr.length-1);

        for(int e:arr)
        {
            System.out.println(e);
        }
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if(low<high)
        {
            int mid = (low + high)/2;
            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }

    private static void merge(int[] A, int l, int mid, int h) {
        int i = l, j = mid+1, k = l;
        int B[] = new int[100]; // aux array

        while (i <= mid && j <= h) {
            if (A[i] < A[j])
                B[k++] = A[i++];
            else
                B[k++] = A[j++];
        }

        for (; i <= mid; i++)
            B[k++] = A[i];
        for (; j <= h; j++)
            B[k++] = A[j];

        for (i = l; i <= h; i++)
            A[i] = B[i];
    }

    private static int[] twoWayMerging(int[] A, int[] B) {
        int i=0,j=0,k=0;
        int m = A.length;
        int n = B.length;
        int []C = new int[m+n];

        while(i<m && j<n)
        {
            if(A[i]<B[j])
            {
                C[k++]=A[i++];
            }
            else {
                C[k++] = B[j++];
            }
        }

        for(;i<m;i++)
        {
            C[k++]=A[i];
        }

        for(;j<n;j++)
        {
            C[k++]=B[j];
        }

        return C;
    }
}
