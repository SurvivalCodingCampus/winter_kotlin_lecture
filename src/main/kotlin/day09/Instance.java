package day09;

import day03.Hero;

public class Instance {
    public static void main(String[] args) {
        Object obj = new Hero("",10);

        ClassA a = new ClassA();

        System.out.println(a.equals(obj));

    }
}

class ClassA {

}