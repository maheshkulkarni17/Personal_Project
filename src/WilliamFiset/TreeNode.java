package WilliamFiset;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val)
    {
        this.val=val;
        this.left=null;
        this.right=null;
    }

    public TreeNode(int val,TreeNode left,TreeNode right)
    {
        this.val=val;
        this.left=left;
        this.right=right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode l0 = new TreeNode(0);
        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(2);
        TreeNode l4 = new TreeNode(4);
        TreeNode l5 = new TreeNode(5);
        TreeNode l6 = new TreeNode(6);
        TreeNode l7 = new TreeNode(7);
        TreeNode l8 = new TreeNode(8);



        root.left=l5;
        root.right=l1;
        l5.left=l6;
        l5.right=l2;
        l2.left=l7;
        l2.right=l4;

        l1.left=l0;
        l1.right=l8;
        boolean visited[] = new boolean[9];
        int level[] = new int[9];

        printBTree(root);
        dfs(root,visited);
        bfs(root,visited);
//        System.out.println(getLevel(root,1,0));
        for(int i=0;i<9;i++)
        {
            level[i]=getLevel(root,i,0);
            System.out.println(level[i]);
        }

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(7);
        root1.right.left.right = new TreeNode(8);
        printBTree(root1);
        for (int i=0;i<12;i++)
        {
            System.out.println("Euler "+euler[i]);
        }
    }

    public static int getLevel(TreeNode root, int val,int level) {
        if(root==null)
            return 0;
        if(root.val== val)
            return level;

        int left = getLevel(root.left,val,level+1);
        if(left!=0)
            return left;

        int right = getLevel(root.right,val,level+1);
        return right;

    }

    public static void bfs(TreeNode root, boolean[] visited) {
        Queue<TreeNode> queue = new LinkedList<>();

        visited[root.val]=true;
        queue.add(root);
        int level=0;
        while(!queue.isEmpty())
        {
            System.out.println("BFS "+queue.peek().val);
            if (queue.peek().left!=null) {

                queue.add(queue.peek().left);
            }
            if (queue.peek().right!=null) {
                queue.add(queue.peek().right);
            }
            queue.poll();


        }
    }

    private static void dfs(TreeNode root,boolean []visited) {
        if(root==null)
            return;
        int l=0;
        visited[root.val]=true;
        System.out.println("DFS "+root.val);
        if(root.left!=null && !visited[root.left.val])
            dfs(root.left,visited);
        if(root.right!=null && !visited[root.right.val])
            dfs(root.right,visited);

    }
    static int []euler = new int[100];
    static int c=0;

    private static void printBTree(TreeNode root) {

        if(root==null)
            return;
        System.out.println("Euler Tree");
        System.out.println(root.val);
        euler[c]=root.val;
        c++;
        if(root.left!=null) {
            printBTree(root.left);
            System.out.println(root.val);
            euler[c]=root.val;
            c++;
        }

        if(root.right!=null)
        {   printBTree(root.right);
            System.out.println(root.val);
            euler[c]=root.val;
            c++;
        }
    }
}
