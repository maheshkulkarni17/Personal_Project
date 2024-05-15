import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
class Pair<U,V>
{
    U first;
    V second;
    public Pair(U first,V second)
    {
     this.first = first;
     this.second = second;
    }
}

class Bucket{
    private List<Pair<Integer,Integer>> bucket;

    public Bucket(){
        this.bucket = new LinkedList<Pair<Integer,Integer>>();
    }

    public Integer get(Integer key)
    {
        for(Pair<Integer,Integer> pair:this.bucket)
        {
            if(pair.first.equals(key))
                return pair.second;
        }
        return -1;
    }

    public void update(Integer key, Integer value)
    {
        boolean found = false;
        for(Pair<Integer,Integer> pair:this.bucket)
        {
            if(pair.first.equals(key))
            {
             found=true;
             pair.second = value;
            }
        }
        if(!found)
            this.bucket.add(new Pair<Integer,Integer>(key,value));

    }

    public void remove(Integer key)
    {
        for(Pair<Integer,Integer> pair:this.bucket)
        {
            if(pair.first.equals(key))
            {
                this.bucket.remove(pair);
                break;
            }
        }
    }
}
public class MyHashMap {

    public int hash_space;
    public List<Bucket> hash_table;

    public MyHashMap()
    {
        this.hash_space = 7;
        this.hash_table = new ArrayList<Bucket>();
        for(int i=0;i<this.hash_space;i++)
        {
            this.hash_table.add(new Bucket());
        }
    }

    public void put(int key, int value)
    {
        int hash = key % this.hash_space;
        this.hash_table.get(hash).update(key,value);
    }

    public int get(int key)
    {
        int hash = key % this.hash_space;
        return this.hash_table.get(hash).get(key);
    }

    public void remove(int key)
    {
        int hash = key % this.hash_space;
        this.hash_table.get(hash).remove(key);
    }

    public static void main(String[] args) {

        MyHashMap hashMap  = new MyHashMap();
        hashMap.put(3,10);
        hashMap.put(4,12);
        hashMap.put(5,15);
        hashMap.remove(4);
        System.out.println(hashMap.get(3));
        System.out.println(hashMap.get(4));
        System.out.println(hashMap.get(5));


    }
}
