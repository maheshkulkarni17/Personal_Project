package DesignPatterns.SingletonDP;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonDesignPattern {
    // static object is created
    private static SingletonDesignPattern singletonDesignPattern;
    //make the constructor private because no one will create the object
    private SingletonDesignPattern()
    {
        if(singletonDesignPattern!=null)
            throw new RuntimeException("You are trying to break singleton DP");
    }
    // create one static method so that we can call method directly using class name.
    //method will create the object

    public static synchronized SingletonDesignPattern getSingletonDesignObject()
    {
        // made the whole method thread safe so many threads will not access different objects
        if(singletonDesignPattern==null)
        {
            singletonDesignPattern = new SingletonDesignPattern();
        }

        // we can use the synchronised block as well



        return singletonDesignPattern;
    }

    public static  SingletonDesignPattern getSyncSingletonDesignObject()
    {
        // made the whole method thread safe so many threads will not access different objects
       synchronized (SingletonDesignPattern.class) {
           if (singletonDesignPattern == null) {
               singletonDesignPattern = new SingletonDesignPattern();
           }
       }
        // we can use the synchronised block as well



        return singletonDesignPattern;
    }


}

class Demo
{
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        this is not possible as constructor is private
//        SingletonDesignPattern singletonDesignPattern1 = new SingletonDesignPattern();
        System.out.println("Hello");

        SingletonDesignPattern singletonDesignPattern = SingletonDesignPattern.getSingletonDesignObject();
        SingletonDesignPattern singletonDesignPattern1 = SingletonDesignPattern.getSingletonDesignObject();

        System.out.println(singletonDesignPattern.hashCode());
        System.out.println(singletonDesignPattern1.hashCode());
        SingletonDesignPattern singletonDesignPattern3 = SingletonDesignPattern.getSyncSingletonDesignObject();
        SingletonDesignPattern singletonDesignPattern4 = SingletonDesignPattern.getSyncSingletonDesignObject();

        System.out.println(singletonDesignPattern3.hashCode());
        System.out.println(singletonDesignPattern4.hashCode());
        // both the hashcode will be same


        /*  there is way to break the singleton pattern
        * 1] Using the reflection API - This works at runtime
        * This will change the access modifier private to public and this will
        * break the singleton design patter
        * 2] */

        Constructor<SingletonDesignPattern> constructor = SingletonDesignPattern.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingletonDesignPattern singletonDesignPattern2 = constructor.newInstance();
        System.out.println(
                singletonDesignPattern2.hashCode()
        );

        /*using ENUM or private constructor
        * we can save our Singleton property, at this point of time added the exception in private constructor
        *
        * Exception = Exception in thread "main" java.lang.reflect.InvocationTargetException
	at java.base/jdk.internal.reflect.DirectConstructorHandleAccessor.newInstance(DirectConstructorHandleAccessor.java:74)
	at java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:502)
	at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:486)
	at DesignPatterns.SingletonDP.Demo.main(SingletonDesignPattern.java:79)
Caused by: java.lang.RuntimeException: You are trying to break singleton DP
	at DesignPatterns.SingletonDP.SingletonDesignPattern.<init>(SingletonDesignPattern.java:13)
	at java.base/jdk.internal.reflect.DirectConstructorHandleAccessor.newInstance(DirectConstructorHandleAccessor.java:62)
	... 3 more  */
    }
}
