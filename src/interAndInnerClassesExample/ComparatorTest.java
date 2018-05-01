package interAndInnerClassesExample;

import java.util.*;

/**
 * Created by Евгений on 21.10.2017.
 */
public class ComparatorTest{
    public static void main(String[] args) {

        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();

        Map<String,Object> mp1 = new HashMap<String,Object>();
        mp1.put("Name","Brandon");
        mp1.put("Family","Stock");
        list.add(mp1);

        Map<String,Object> mp2 = new HashMap<String,Object>();
        mp2.put("Name","Adam");
        mp2.put("Family","Cook");
        list.add(mp2);

        Map<String,Object> mp3 = new HashMap<String,Object>();
        mp3.put("Name","Walter");
        mp3.put("Family","Took");
        list.add(mp3);

         class comp implements Comparator<Map<String,Object>>   {

            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                String s1 = (String) o1.get("Family");
                String s2 = (String) o2.get("Family");
                return s1.compareTo(s2);

            }
        }

        System.out.println(list);

        Collections.sort(list, new comp());

        System.out.println(list);
    }

}





