package com.survivalcoding.day08;

import com.survivalcoding.com.survivalcoding.day03.Hero;

public class InstanceJava {
    public static void main(String[] args) {
        Object obj = new Hero("", 10);

        ClassA a = new ClassA();

        System.out.println(a.equals(obj));
    }
}

class ClassA {

}