package GooglePhoneScreen;

import java.util.*;

public class TreePrinter {
/* Problem statement:  Write a java function ,PrintTree() which prints given tree to screen
*                       1. Argument for the print tree is stream of relations
*                       2. Each String is unique code
*                       3. Each parent can have many children
*                       4. Input string contains relations in any order (parent -> child)
*                       5. Order of the relation is given or determined according to the entry
*                       6.   */

    /*Expected output:
    *   Life:
    *       Animal
    *           Mammal
    *               Cat
    *                   Lion
    *           Bird
    *           Fish        */

    static HashMap<String, List<String>> dict = new HashMap<>();
    public static void printTree(List<Relation> input)
    {
        /* Adjacency list
        * Animal -> mammal,bird,fish
        * mammal -> cat
        * life -> animal
        *
        * 1. Loop through relations and put all parents as keys and child as values
        * 2. Find the root, add all the children in set and compare that with the all keys of hashmap, if key is not present
        * in the set that means the key is root
        *
        * Time Complexity : O(n)
        * Space Complexity : O(n) */
        Set<String> children = new HashSet<>();
        for(Relation relation:input)
        {
            children.add(relation.child);
            if(dict.containsKey(relation.parent))
            {
                dict.get(relation.parent).add(relation.child);
            }
            else
            {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(relation.child);
                dict.put(relation.parent, arrayList);
            }
        }
        String root="";
        for(String key:dict.keySet())
        {
            if(!children.contains(key))
            {
                root=key;
                break;
            }
        }

        System.out.println("Root = "+root);

        dfs(root,0);

    }

    public static void dfs(String root,int level)
    {
        for(int i=0;i<level;i++)
        {
            System.out.print("\t");
        }

        System.out.println(root);

        List<String> children;

        if(dict.containsKey(root))
            children = dict.get(root);
        else
            return;

        for(String child:children)
        {
            dfs(child,level+1);
        }

    }

    public static void main(String[] args) {

        List<Relation> input = new ArrayList<>();
        input.add(new Relation("animal","mammal"));
        input.add(new Relation("animal","bird"));
        input.add(new Relation("life","animal"));
        input.add(new Relation("cat","lion"));
        input.add(new Relation("mammal","cat"));
        input.add(new Relation("animal","fish"));

        printTree(input);
    }
}
class Relation {
    String parent;
    String child;

    public Relation(String parent,String child)
    {
        this.parent = parent;
        this.child = child;
    }
}


