package org.example;

import tdas.ArrayList;
import tdas.LinkedList;

import java.util.Iterator;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();
        ll.addLast("A");
        ll.addLast("B");
        ll.addLast("C");
        System.out.println(ll);
        ll.add("Z",3);
        System.out.println(ll);
    }
}