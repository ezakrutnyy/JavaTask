package example;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in;
        List<Integer> list = Lists.newLinkedList();
        while(!(in = sc.nextLine()).equals("end")) {
            list.add(Integer.parseInt(in));
        }
        System.out.println(getMinimumElement(list));
    }



    static Integer getMinimumElement(List<Integer> list) {
        return list.stream().collect(Collectors.summarizingInt(Integer::intValue)).getMin();
    }

}
