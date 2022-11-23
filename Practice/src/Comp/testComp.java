package Comp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//Input: { {"abc", 3}, {"a", 4}, {"bc", 5}, {"a", 2} }
//
//Output: { {"a", 2}, {"a", 4}, {"abc", 3}, {"bc", 5} }
public class testComp {

    public static void main(String[] args) {
        Element el1 = new Element("abc", 3);
        Element el2 = new Element("a", 4);
        Element el3 = new Element("bc", 5);
        Element el4 = new Element("a", 2);

        Element[] array = {el1,el2,el3,el4};

        List<Element> testList = new ArrayList<>(List.of((array)));

        System.out.println(testList);

        Collections.sort(testList);

        System.out.println(testList);
    }
}
