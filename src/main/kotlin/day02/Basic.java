package day02;

import java.util.List;

public class Basic {

    public static void main(String[] args) {
        String name = null;
        System.out.println(name.charAt(1)); // NPE 발생

        List<String> items = List.of("apple", "banana");
    }
}
