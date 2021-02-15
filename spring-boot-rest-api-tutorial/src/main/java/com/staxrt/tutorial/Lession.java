package com.staxrt.tutorial;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Lession {
    public static void main(String[] args) {
//        double result = 1.0 - 0.9;
//        BigDecimal a = new BigDecimal(1.0+"");
//        BigDecimal b = new BigDecimal(0.9+"");
//        System.out.println(a.subtract(b));
//        System.out.println(result);
//
//        BigDecimal c = new BigDecimal(1.0);
//        BigDecimal d = new BigDecimal(0.9);
//        System.out.println(c.subtract(d));

        List<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        for (String s : list) {

        }

        list.forEach(str-> System.out.println(str));
        list.stream()
                .filter(str->!str.equals("c"))
                .collect(Collectors.toList())
                .forEach(str-> System.out.println(str));

    }
}
