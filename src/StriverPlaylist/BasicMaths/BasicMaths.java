package StriverPlaylist.BasicMaths;

public class BasicMaths {
    public static void main(String[] args) {
        int n=7789;
        System.out.println("Basic maths by striver");
        System.out.println("Number is "+n);
        extractDigits(n);
        countDigits(n);
        countDigitsUsingLog(n);
        reverseNumber(n);
        reverseNumberString(n);
        int num=121;
        System.out.println("**** Palindrome Number****");
        isPalindromeNumber(num);
        isPalindromeNumber(231);
        System.out.println("**** ArmStrong Number ****");
        isArmstrongNumber(371);
        isArmstrongNumber(271);
        isArmstrongNumber(1634);
        System.out.println("**** Printing all Divisors ****");
        printAllDivisors(36);
        System.out.println();
        System.out.println("**** Printing all Divisors with sqrt method ****");
        printAllDivisorsSqrt(36);
        System.out.println();
        System.out.println(isPrime(19));
        System.out.println("**** Finding GCD of 9 , 12 ****");
        findGCD(20 , 40);
        findGCDEuclidean(9,12);

    }

    private static void findGCDEuclidean(int a, int b ) {
        /*Euclidean Algorithm says
        * gcd(a,b) = gcd(a-b,b) when a>b
        * We can derive another formula ,
        * gcd(a,b) = gcd(a%b, b) when a>b ,
        * instead of subtracting we are taking modulo which is equivalent to Division hence faster than the subtraction
        *     */
        while(a>0 && b>0)
        {
            if(a>b)
                a=a%b;
            else
                b=b%a;
        }

        if(a==0)
            System.out.println("GCD = "+b);
        else
            System.out.println("GCD = "+a);
    }

    private static void findGCD(int num1, int num2) {
        int gcd=1;
        int min = Math.min(num1,num2);
        int max = Math.max(num1,num2);
        int i=max-min;

        for(;i>=2;i--)
        {
            if(num1%i ==0 && num2%i==0)
            {
                gcd=i;
                break;
            }

        }
        System.out.println("GCD of "+num1+" and "+num2+" is "+gcd);
    }

    private static boolean isPrime(int num) {

        for(int i=2;i<=(int)Math.sqrt(num);i++)
        {
            if(num%i==0)
            {
                System.out.print("This Number is not a Prime Number " + num);
                System.out.println();
                return false;

            }
        }

        System.out.println("This Number is a Prime Number "+num);
        System.out.println();

        return true;
    }

    private static void printAllDivisorsSqrt(int num) {
        /*
        * 1 * 36
        * 2 * 18
        * 3 * 12
        * 4 * 12
        * 6 * 6
        * 9 * 4
        * 12 * 3
        * 18 * 2
        * 36 * 1
        * now Until sqrt of 36 that is 6 and after that all factors are repeated
         */
        for(int i=1;i<=(int)Math.sqrt(num);i++)
        {
            if(num%i==0)
            {
                System.out.print(" " + i);
                if (num / i != i)
                    System.out.print(" " + num / i);
            }
        }
    }

    private static void printAllDivisors(int num) {
        for(int i=1;i<=num;i++)
        {
            if(num%i==0)
                System.out.print(" "+i);
        }
    }

    private static void isArmstrongNumber(int num) {
        int ans=0;
        int dup=num;
        while(num>0)
        {
            int rem = num%10;
            ans += Math.pow(rem,3);
            num/=10;
        }
        if(ans==dup)
            System.out.println(dup+" Number is Armstrong");
        else
            System.out.println(dup+" Number is not Armstrong");
    }

    private static void isPalindromeNumber(int num) {
        int ans = reverseNumber(num);
        if(ans==num)
            System.out.println(num+" Number is palindrome");
        else
            System.out.println(num+" Number is not palindrome");
    }

    private static void reverseNumberString(int n) {
        String num = String.valueOf(n);
        StringBuffer sb = new StringBuffer(num);
        System.out.println("Reversed number usig stringBuffer = "+sb.reverse());
    }

    private static int reverseNumber(int n) {
        int ans=0;
        int NoOfDigits = countDigits(n);
        while(n>0)
        {
            int rem = n%10;
            ans += rem * Math.pow(10,NoOfDigits-1);
            n/=10;
            NoOfDigits--;
        }
        System.out.println("Reversed Number = "+ans);
        return ans;
    }

    private static void countDigitsUsingLog(int n) {
        int ans = (int)Math.log10(n)+1;
        System.out.println("No of Digits using Log 10 =  "+ans);
    }

    private static int countDigits(int n) {
        int ans=0;
        while(n>0)
        {
            ans++;
            n/=10;
        }
        System.out.println();
        System.out.println("No of Digits = "+ans);
        return ans;
    }

    private static void extractDigits(int n) {
        System.out.print("Extraction of Digits = ");
        while(n>0)
        {
            System.out.print(" "+n%10);
            n/=10;
        }
    }
}
