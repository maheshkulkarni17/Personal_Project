package GooglePhoneScreen;

import java.util.Iterator;

public class DynamicArray <T> implements Iterable<T> {
    private T arr[];
    private int len;
    private int capacity;

    public DynamicArray() {
            this(4);
    }
    public DynamicArray(int capacity) {
        if(capacity<0)
            throw new IllegalArgumentException("Illegal Capacity"+capacity);
        this.capacity=capacity;
        arr = (T[]) new Object[capacity];
    }
    public int size() {
        return len;
    }

    public boolean isEmpty(){
        return size()==0;
    }

    public T get(int index){
        return arr[index];
    }

    public void set(int index, T ele)
    {
        arr[index]=ele;
    }

    public void clear()
    {
        for(int i=0;i<capacity;i++)
        {
            arr[i]=null;
        }
        len = 0 ;
    }

    public void add(T ele)
    {
        if(len+1>=capacity)
            if(capacity==0)
                capacity=1;
            else
            {
                capacity*=2;
                T[] new_arr = (T[]) new Object[capacity];
                for(int i=0;i<len;i++)
                {
                    new_arr[i]=arr[i];
                }
                arr = new_arr;
            }

            arr[len++]=ele;

    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }

    public static void main(String[] args) {
        DynamicArray<Integer> array = new DynamicArray<>();
        array.add(10);
        array.add(20);
        array.add(30);
        System.out.println(array.capacity);
        System.out.println(array.size());
        array.add(40);
        array.add(50);
        array.add(60);
        System.out.println(array.capacity);
        System.out.println(array.size());
        array.add(70);
    }
}
