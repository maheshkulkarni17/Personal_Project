package demo;

public class Recursion {
    static int fact=1;

    public static void main(String args[])
    {
        /*int ans  = function1(5);
        System.out.println("factorial of 5 = "+ans);
        int sq = squre(squre(4));
        System.out.println(sq);
        printNumbers(1);
        System.out.println();
        System.out.println("Sum of 1 to 10 = ");
        System.out.print(printSumOf1toN(5));
        System.out.println();
        fibonacci(25,0,1);
        System.out.println();
        System.out.println("power of 2,5 "+powerOf(2,5));
        int n = 3;
        System.out.println("Tower of Hanoi");
        towerOfHanoi(n,"S","H","D");
        String str = "ABCDEFGHIAJKA";
        System.out.println(reverse(str,str.length()));
        findFirstAndLastOccur(str,-1,-1,0,"A");
        int []arr = {1,2,4,5,3};
        System.out.println(isSorted(arr,0,false));*/
//        System.out.println(findNth("a1b1c3",12));
        System.out.println(InternPassword(10,25003));

;
    }

    private static int InternPassword(int n, int pass) {


        int rem=pass%5000;
        int temp=0;
        int internDay=0;

        for(int day = 1; day <= 49; day++)
        {
            temp=temp+day;
            if(temp==rem)
            {
                internDay=day;
                break;
            }
        }

        int day0=internDay*5000;
        pass=pass-day0-rem;
        return pass/5000;




       /* for(int i=1;i<=n;i++)
        {
            cp=5000*i;
            for(int j=1;j<=5;j++)
            {
                cp = cp + 5000 + j;
                if(cp==pass)
                {
                    internLabel=i;
                    break;
                }
            }

            if(internLabel!=0)
                break;
        }*/

//        return internLabel;

    }

    private static String findNth(String input1, int input2) {
        StringBuffer b = new StringBuffer();
        int temp=0;
        char c='0';
        for(int i=0;i<input1.length();i++)
        {
            if(i>0 && i%2==1)
            {
                temp= input1.charAt(i)-'0';
                while(temp!=0)
                {
                    temp--;
                    b.append(c);
                }
            }
            else
            {
                c=input1.charAt(i);

            }
        }
        if(input2>b.length())
            return new String("-1");
        return b.substring(input2-1, input2);

    }

    private static boolean isSorted(int[] arr, int i,boolean flag) {
        if(i>arr.length-2)
            return flag;
        if(arr[i]>arr[i+1])
            return false;
        flag=true;
        return isSorted(arr,i+1,flag);
    }

    private static void findFirstAndLastOccur(String str, int first, int last,int len,String ans) {
        if(len==str.length()) {
            System.out.println("First = "+first+" Last = "+last);
            return;
        }

        boolean equals = (str.charAt(len) + "").equals(ans);
        if(equals && first==-1)
            first=len;
        else if(equals)
            last=len;
        findFirstAndLastOccur(str,first,last,len+1,ans);


    }

    private static String reverse(String str,int len) {
        if(len==1)
            return ""+str.charAt(len-1);
        return str.charAt(len-1)+reverse(str,len-1);

    }

    private static void towerOfHanoi(int n, String src, String helper, String dest) {
        if(n==1)
        {
            System.out.println("Transferred "+n+" to "+src+" to "+dest);
            return;
        }
        towerOfHanoi(n-1,src,dest,helper);
        System.out.println("Transferred "+n+" to "+src+" to "+dest);
        towerOfHanoi(n-1,helper,src,dest);
    }

    private static int powerOf(int n, int i) {
        if(i<1)
            return 1;
        return n*powerOf(n,i-1);

    }

    private static void fibonacci(int n,int a,int b) {

        int c = a + b;
        if(c>25)
            return;
        System.out.print(" "+c);
        fibonacci(n,b,c);


    }

    private static int printSumOf1toN(int n) {
        if(n==0)
            return 0;
        return n+printSumOf1toN(n-1);
    }

    private static void printNumbers(int i) {
        if(i==6) //base case
            return;
        System.out.print(i+" "); //actual work
        printNumbers(i+1); //call to recursive function
    }

    private static int squre(int i) {
        return i*i;
    }

    private static int function1(int i) {
        if(i==1)
            return 1;
        return i*function1(i-1);

    }
}
