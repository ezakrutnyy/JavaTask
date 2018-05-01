package collections;

import java.util.*;

/**
 * Created by Евгений on 01.05.2018.
 */
public class CollectionsClassBrowseMethod {
    public static void main(String[] args) {

        final List<String> lst1 = new ArrayList<String>(Arrays.asList("Watermelon","Orange","Banana","Apple","Melon"));

        // 1- sorting Collections
        Collections.sort(lst1);
        System.out.println(lst1);

        // 2 - binary search in order collections
        System.out.println(Collections.binarySearch(lst1,"Melon"));

        // 3 reverse sort Collections
        System.out.println();


    }
}
