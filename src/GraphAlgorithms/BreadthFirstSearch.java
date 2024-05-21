package GraphAlgorithms;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

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
        System.out.println("This is BFS");
        Graph graph = new Graph(5);
        graph.vertices=5;
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);

        bfs(0, graph.vertices,graph.adjList);
    }

    private static void bfs(int startNode,int vertices,LinkedList<Integer> [] adjList) {

        Queue<Integer> queue = new LinkedList<>();

        boolean[] visited = new boolean[vertices+1];

        queue.add(startNode);
        visited[startNode] = true;

        while(!queue.isEmpty())
        {
            Integer node = queue.poll();
            System.out.println("Visited "+node);
            for(int nei:adjList[node])
            {
                if(!visited[nei])
                {
                    visited[nei]=true;
                    queue.offer(nei);
                }
            }

        }

    }
}

    /*This is BFS
        Visited 0
        Visited 1
        Visited 2
        Visited 3
        Visited 4*/