package DesignPatterns.SingletonDP;

public class SingletonDesignPattern {
    // static object is created
    private static SingletonDesignPattern singletonDesignPattern;
    //make the constructor private because no one will create the object
    private SingletonDesignPattern()
    {

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
    public static void main(String[] args) {
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
        * Using the reflection API - This works at runtime
        * This will change the access modifier private to public and this will
        * break the singleton design patter*/
    }
}
