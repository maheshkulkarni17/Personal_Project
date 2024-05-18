package SearchingAlgorithms;

public class BinarySearch {
    static int arr[] = {4,8,10,15,18,21,24,27,29,33,34,37,39,41,43};
    public static void main(String[] args) {
        System.out.println("Binary Search Iterative");

        int low = 0;
        int high = arr.length-1;
        int key=18;
        binarySearch(low,high,key);
        recursiveBinarySearch(low,high,key);
        key=34;
        binarySearch(low,high,key);
        recursiveBinarySearch(low,high,key);
        key=9;
        binarySearch(low,high,key);
        recursiveBinarySearch(low,high,key);
    }

    private static int recursiveBinarySearch(int low, int high, int key) {
        if(low<=high)
        {
            int mid = low + (high-low)/2;
            if(arr[mid]==key)
            {
                System.out.println(key+" found at position "+mid);
                return mid;
            }
            else if(arr[mid]<key)
            {
                return recursiveBinarySearch(mid+1,high,key);
            }
            else
            {
                return recursiveBinarySearch(low,mid-1,key);
            }
        }
        System.out.println(key+" is not found");
        return -1;
    }

    private static void binarySearch(int low, int high,int key) {
        while(low<=high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key)
            {
                System.out.println(key+" found at position "+mid);
                return;
            }
            else if(arr[mid]<key)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }

        System.out.println(key+" is not found");
    }
}
