package GooglePhoneScreen;

import java.util.Stack;
import java.util.TreeSet;

public class FloatStream {
    public int D;
    public TreeSet<Integer> set;

    public void init(int D)
    {
        set = new TreeSet<>();
        this.D=D;
    }
    public static void main(String[] args) {
        FloatStream floatStream = new FloatStream();
        floatStream.init(5);
/*
        floatStream.set.add(5);
        floatStream.set.add(6);
        floatStream.set.add(7);
        System.out.println(floatStream.set.lower(7));
        System.out.println(floatStream.set.higher(5));
//        System.out.println(floatStream.set.remove(6));
        System.out.println(floatStream.set.lower(7));
        System.out.println(floatStream.set.toArray());
        System.out.println(floatStream.set);*/
        String s = "(abcd)";
        String s1 = "(u(love)i)";
        String s2 = "(ed(et(oc))el)";
        System.out.println(reverseParentheses(s));
    }

    public static String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c:s.toCharArray())
        {
            if(c==')')
            {

                StringBuffer stringbuffer = new StringBuffer();
                while(stack.peek()!='(')
                {
                    stringbuffer.append(stack.pop());
                }
                stack.pop();
//                stringbuffer.reverse();
                for(char p:stringbuffer.toString().toCharArray())
                {
                    stack.push(p);
                }
            }
            else
                stack.push(c);
        }

        StringBuffer ans = new StringBuffer();

        for(int i=0;i<stack.size();i++)
        {
            ans.append(stack.get(i));
        }

        return ans.toString();
    }

}
