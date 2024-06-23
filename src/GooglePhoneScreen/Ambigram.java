package GooglePhoneScreen;

import java.util.HashMap;

public class Ambigram {
    public static HashMap<Character,Character> dict = new HashMap<>();

    public static void main(String[] args) {

        dict.put('b','g');
        String str = "bg";

        System.out.println(isAmbigram(str));
    }

    private static boolean isAmbigram(String str) {
        int i=0;
        int j=str.length()-1;

        while(i<=j)
        {
            if((dict.get(str.charAt(i))!=null && dict.get(str.charAt(i))!=str.charAt(j)))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
