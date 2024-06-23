package GooglePhoneScreen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entity {

    // Problem Statement
    /* Calculate the size of the Entity is defined as the root directory containing multiple files inside the directory */

    String type;
    String name;
    List<Integer> children;
    int size;

    // constructor for files
    public Entity(String type,String name,int size){
        this.type = type;
        this.name = name;
        this.size = size;
    }

    public Entity(String type,String name,List<Integer> children)
    {
        this.type = type;
        this.name = name;
        this.children = children;
    }

    public static void main(String[] args) {
        Map<Integer,Entity> fileSystem = new HashMap<>();

        fileSystem.put(1,new Entity("dir","dir1",List.of(3,4)));
        fileSystem.put(2,new Entity("dir","root",List.of(1,5)));
        fileSystem.put(3,new Entity("file","file1",200));
        fileSystem.put(4,new Entity("file","file2",100));
        fileSystem.put(5,new Entity("file","file3",300));

        int rootSize = calculateSize(2,fileSystem);
        System.out.println(rootSize);
    }

    public static int calculateSize(int entityId, Map<Integer, Entity> fileSystem) {

        if(!fileSystem.containsKey(entityId))
            return 0;

        Entity entity = fileSystem.get(entityId);

        System.out.println("Started calculating entity size");

        if(entity.size!=0)
            return entity.size;

        int totalSize = 0;

        for(int childDir: entity.children)
        {
            totalSize = totalSize + calculateSize(childDir,fileSystem);
        }
        return totalSize;

    }


}
