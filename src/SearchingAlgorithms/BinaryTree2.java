package SearchingAlgorithms;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree2 {

    static int id=-1;

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public static void main(String args[])
    {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        Node root = buildTree(nodes);
        System.out.println("Pre Order ");
        printTree(root);
        System.out.println();
        System.out.println("In Order ");
        inorder(root);
        System.out.println();
        System.out.println("Post Order ");
        postOrder(root);
        System.out.println();
        System.out.println("Level Order ");
        levelOrder(root);
        System.out.println("Count of Nodes =  "+countNodes(root));


    }

    private static int countNodes(Node root) {
        if(root==null)
            return 0;
        return 1+countNodes(root.left)+countNodes(root.right);
    }

    private static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();

        if(root==null)
            return;

        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty())
        {
            Node temp = queue.remove();
            if(temp!=null)
            {
                System.out.print("-"+temp.data);
                if(temp.left!=null)
                    queue.add(temp.left);
                if(temp.right!=null)
                    queue.add(temp.right);
            }
            else
            {
                //logic to print new line
                System.out.println("");
                if(queue.isEmpty())
                    break;
                else
                    queue.add(null);
            }

        }
        System.out.println();
    }

    private static void postOrder(Node root) {
        // time complexity O(n) - traversed all nodes
        if(root==null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print("-"+root.data);
    }

    private static void inorder(Node root) {
        // time complexity O(n) - traversed all nodes
        if(root==null)
            return;

        inorder(root.left);
        System.out.print("-"+root.data);
        inorder(root.right);
    }

    private static void printTree(Node root) {
        // time complexity O(n) - traversed all nodes
        if(root==null)
            return;
        System.out.print("-"+root.data);
        printTree(root.left);
        printTree(root.right);
    }

    private static Node buildTree(int[] nodes) {
        id++;
        if(nodes[id]==-1)
            return null;
        Node newnode = new Node(nodes[id]);
        newnode.left = buildTree(nodes);
        newnode.right = buildTree(nodes);

        return newnode;
    }
}
