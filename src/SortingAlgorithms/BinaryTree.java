package SortingAlgorithms;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    static int idx=-1;

    public static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }


        public static void main(String args[]) {
            int nodes[] = {3,9,20,-1,-1,15,7};
            System.out.println("This is Binary Tree");
            Node root = buildTree(nodes);
//            printTree(root);
            printLevelOrder(root);
            System.out.println();
//            System.out.println("No of Nodes = "+countNodes(root));
            System.out.println("Sum of Nodes = "+sumOfNodes(root));
//            System.out.println("Height of tree = "+heightOfTree(root));
//            System.out.println("Diameter of tree via root = "+diameterViaRoot(root));

        }

        private static int diameterViaRoot(Node root) {

            if(root==null)
                return 0;

            int ls = 1 + diameterViaRoot(root.left);
            int rs = 1 + diameterViaRoot(root.right);

            int lh = heightOfTree(root.left);
            int rh = heightOfTree(root.right);

            return Math.max(Math.max(ls,rs),lh+rh+1);
        }

        private static int heightOfTree(Node root) {
            if(root==null)
                return 0;

            int l = heightOfTree(root.left);
            int r = heightOfTree(root.right);

            return Math.max(l,r)+1;
        }

        private static int sumOfNodes(Node root) {
            if(root==null)
                return 0;

            if(root.left==null && root.right==null)
                return root.data;

            return sumOfNodes(root.left)+sumOfNodes(root.right);
        }

        private static int countNodes(Node root) {
            if(root==null)
                return 0;
            return 1 + countNodes(root.left) + countNodes(root.right);

        }

        private static void printLevelOrder(Node root) {
            if(root==null)
                return;
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty())
            {
                Node temp = q.remove();
                if(temp==null)
                    return;
                System.out.print(temp.data+" ");
                if(temp.left!=null) {
                    q.add(temp.left);
                }
                if(temp.right!=null)
                    q.add(temp.right);


            }
        }

        private static void printTree(Node root) {
            if(root==null)
                return;

            printTree(root.left);
            System.out.print(root.data+" ");
            printTree(root.right);
        }

        private static Node buildTree(int[] nodes) {
            idx++;
            if(idx>=nodes.length)
                return null;
            if(nodes[idx]==-1)
                return null;
            Node root = new Node(nodes[idx]);
            root.left = buildTree(nodes);
            root.right= buildTree(nodes);
            return root;
        }
    }
}
