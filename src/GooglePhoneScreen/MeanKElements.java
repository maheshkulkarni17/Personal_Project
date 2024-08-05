package GooglePhoneScreen;

import java.util.LinkedList;
import java.util.Queue;

public class MeanKElements {
    static Queue<Integer> queue = new LinkedList<>();
    static int k=5;
    static int mean =0;
    public static void main(String[] args) {
        System.out.println(addElements(50));
        System.out.println(addElements(60));
        System.out.println(addElements(70));
        System.out.println(addElements(50));
        System.out.println(addElements(100));
        System.out.println(addElements(120));
        System.out.println(addElements(80));
        System.out.println(addElements(140));

    }

    private static float addElements(int ele) {
        mean += ele;

        if(queue.size()>=k)
        {
            mean -=queue.poll();

        }
        queue.add(ele);
        System.out.println("hello this is the program to print mean = "+ (float)mean/ queue.size());
        return (float) mean/ queue.size();


    }
}
