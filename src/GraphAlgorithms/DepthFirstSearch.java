package GraphAlgorithms;

import java.util.LinkedList;
import java.util.Queue;

public class DepthFirstSearch {

    static class Graph{
        int vertices;
        LinkedList<Integer> [] adjList;

        public Graph(int vertices)
        {
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            for(int i=0;i<vertices;i++)
            {
                adjList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int from, int to)
        {
            adjList[from].add(to);
        }
    }
    public static void main(String[] args) {
        System.out.println("This is DFS");
        Graph graph = new Graph(5);
        graph.vertices=5;
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);

        dfs(0,graph.adjList);
    }
    static boolean visited [] = new boolean[5+1];

    private static void dfs(int startNode,LinkedList<Integer> [] adjList) {


        if(!visited[startNode])
        {
            visited[startNode]=true;
            System.out.println("visited "+startNode);
            for(int nei:adjList[startNode])
            {
                if(!visited[nei])
                {
                    dfs(nei,adjList);
                }
            }
        }

    }
}
   /* This is DFS
        visited 0
        visited 1
        visited 3
        visited 4
        visited 2*/