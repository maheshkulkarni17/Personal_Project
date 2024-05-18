package SortingAlgorithms;


import java.util.ArrayList;

public class BinarySearchTree {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data)
        {
            this.data=data;
        }
    }

    public static Node insertRec(Node root,int val)
    {
        if(root==null)
        {
            root = new Node(val);
            return root;
        }
        if(val<root.data)
            root.left=insertRec(root.left,val);
        else
            root.right=insertRec(root.right,val);

        return root;
    }
    public static void printTreeInOrder(Node root)
    {
        if(root==null)
            return;
        printTreeInOrder(root.left);
        System.out.print(" "+root.data);
        printTreeInOrder(root.right);
    }
    public static void main(String []args)
    {
        System.out.println("This is Binary Search Tree");
        int[] arr = {8,5,3,1,4,6,10,11,14};
        Node root=null;
        for(int val:arr)
        {
            root = insert(root,val);
        }
        printTreeInOrder(root);
//        System.out.println();
//        System.out.println(search(root,15));
//
////        root=delete(root,4);
////        root=delete(root,10);
////        root=delete(root,5);
//        printTreeInOrder(root);
//        System.out.println("In range : ");
//        printInRage(root,3,12);
//        System.out.println("Leaf to root : ");
//        printPathFromRootToLeaf(root,new ArrayList<>());




    }

    private static void printPathFromRootToLeaf(Node root, ArrayList<Integer> path) {
        if(root==null)
            return;
        path.add(root.data);
        if(root.left==null && root.right==null)
        {
            for(int i:path)
            {
                System.out.print(i+"->");
            }
            System.out.println();
        }
        else {
        printPathFromRootToLeaf(root.left,path);
        printPathFromRootToLeaf(root.right,path);
        }
        path.remove(path.size()-1);

    }

    private static void printInRage(Node root, int low, int high) {
        if(root==null)
            return;

        if(root.data>=low && root.data<=high)
        {

            printInRage(root.left,low,high);
            System.out.print(" "+root.data);
            printInRage(root.right,low,high);

        }
        if(root.data<low)
        {
            printInRage(root.right,low,high);

        }
        if(root.data>high)
        {
            printInRage(root.left,low,high);
        }
    }

    private static Node delete(Node root, int val) {
        if(val<root.data)
        {
            root.left=delete(root.left,val);
        } else if (val>root.data) {
            root.right=delete(root.right,val);
        }
        else
        {
            //case1
            if(root.left==null && root.right==null)
                return null;
            //case 2 - Node with only 1 child - find the 1 child and attach it to the node to be deleted/replace
            if(root.left==null || root.right==null)
            {
                if(root.left==null)
                    return root.right;
                else return root.left;
            }

            //case 3 - Node with 2 children - find inorder successor a nd replace with node to be deleted and then delete the inorder successor
            Node is = InorderSuccessor(root.right);
            root.data=is.data;
            root.right=delete(root.right,is.data);
        }

        return root;
    }

    private static Node InorderSuccessor(Node root) {
        while(root.left!=null)
            root= root.left;

        return root;
    }

    private static boolean search(Node root, int key) {
        if(root==null)
            return false;
        if(root.data==key)
            return true;

        if(key<root.data)
            return search(root.left,key);
        else return search(root.right,key);


    }

    private static Node insert(Node root, int val) {
        if(root==null)
        {
            root=new Node(val);
            return root;
        }

        Node curr = root;

        while(curr!=null)
        {
            if(val< curr.data)
            {
                if(curr.left==null)
                {
                    curr.left = new Node(val);
                    return root;
                }
                else
                    curr=curr.left;
            }
            else {
                if(curr.right==null)
                {
                    curr.right=new Node(val);
                    return root;
                }
                else
                    curr=curr.right;
            }
        }
    return root;
    }
}
