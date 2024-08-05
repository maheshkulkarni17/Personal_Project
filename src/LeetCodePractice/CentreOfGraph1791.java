package LeetCodePractice;

import java.util.HashMap;

public class CentreOfGraph1791 {
    public static void main(String[] args) {
        System.out.println("find centre of graph");
        int arr[][] = new int[2][3];
        int a[][] = {{1,2},{2,3},{4,2}};
        HashMap<Integer,Integer> degree = new HashMap<>();

        for(int edge[]:a)
        {
            degree.put(edge[0],degree.getOrDefault(edge[0],0)+1);
            degree.put(edge[1],degree.getOrDefault(edge[1],0)+1);

        }
    }
}
