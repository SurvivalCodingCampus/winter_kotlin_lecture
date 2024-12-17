package day02;

import java.util.ArrayList;
import java.util.List;

public class Basic {
    public static void main(String[] args) {
        //String name = null;
        //System.out.println(name.toUpperCase()); //에러 발생
        List<String> items = new ArrayList<>(); //리스트 변경가능
        items.add("apple");
        items.add("banana");
    }
}
