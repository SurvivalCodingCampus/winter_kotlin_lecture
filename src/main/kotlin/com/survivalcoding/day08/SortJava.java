package com.survivalcoding.day08;

import java.util.*;

public class SortJava {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Seth", "Kathy", "Lars"));
        names.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 0 이면 같다
                // 음수 왼쪽게 작다
                // 양수 오른쪽게 작다
                return -o1.compareTo(o2);
            }
        });

        Collections.sort(names);

        System.out.println(names);
    }
}
