package org.example;

import tdas.ArrayList;

import java.util.Iterator;
import java.util.LinkedList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ArrayList<String> arrayPrueba = new ArrayList<>();
        ArrayList<String> arrayPrueba2 = new ArrayList<>();
        arrayPrueba.addFirst("H");
        arrayPrueba.addFirst("A");
        arrayPrueba.addFirst("C");
        arrayPrueba.addFirst("D");
        arrayPrueba.add("Z",1);
        arrayPrueba.addLast("R");
        arrayPrueba2.addLast("M");
        arrayPrueba2.addLast("N");
        arrayPrueba2.addLast("T");
        System.out.println(arrayPrueba);
//        arrayPrueba.addAll(arrayPrueba2);
        ArrayList<String> arrayPrueba3 = arrayPrueba.concact(arrayPrueba2);
        System.out.println(arrayPrueba3);
        System.out.println(arrayPrueba);


    }
}