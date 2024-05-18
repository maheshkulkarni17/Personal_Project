package SearchingAlgorithms;

public class LinearSearch {
    static int arr[] = {8,9,4,7,6,3,10,5,14,2};
    public static void main(String []args)
    {

        int key = 5;
        int key1 = 12;

        LinearSearchMethod(arr,arr.length,key);
        LinearSearchMethod(arr,arr.length,key);
        LinearSearchMethod(arr,arr.length,key);
        LinearSearchMethod(arr,arr.length,key);
        LinearSearchMethod(arr,arr.length,key);
        LinearSearchMethod(arr,arr.length,key);
        LinearSearchMethod(arr,arr.length,key);
        LinearSearchMethod(arr,arr.length,key);
        LinearSearchMethod(arr,arr.length,key);
        LinearSearchMethod(arr,arr.length,key1);

    }

    private static void LinearSearchMethod(int[] arr, int n, int key) {
        for(int i=0;i<n;i++)
        {
            if(key==arr[i])
            {
                System.out.println("Search is Successful "+key+" is found at "+i+" th position");
                if(i>0)
                    swap(i,i-1); //transposition // improvement method // frquently searched element moved to the i-1 position
                return;
            }
        }


        System.out.println("Search is Unsuccessful "+key+" is NOT found");
    }

    private static void swap(int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
    }
}
