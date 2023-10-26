package org.example;

import tdas.LinkedList;
import tdas.List;

import java.util.Comparator;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//        LinkedList<Persona> personas = new LinkedList<Persona>();
//        personas.addLast(new Persona("Juan","Computacion",21));
//        personas.addLast(new Persona("Marcos","Computacion",26));
//        personas.addLast(new Persona("Juan","Mecanica",34));
//        personas.addLast(new Persona("Maria","Mecanica",38));
//        personas.addLast(new Persona("Daniel","Mecanica",20));
//
//        LinkedList<Persona> filtrados = personas.entre(Main.getByEdad(),
//                new Persona("","",26),
//                new Persona("","",39));
//        System.out.println(filtrados);
        LinkedList<String> elements = new LinkedList<>();
        elements.addLast("123");
        elements.addLast("11");
        elements.addLast("22");
        elements.addLast("1");
        elements.addLast("321");

        System.out.println(Main.getStringsShorterThan(elements,1));
    }

    public static Comparator<Persona> getByName(){
        Comparator<Persona> cmp = new Comparator<Persona>() {
            @Override
            public int compare(Persona o1, Persona o2) {
                return o1.getNombre().compareTo(o2.getNombre());
            }
        };
        return cmp;
    }

    public static Comparator<Persona> getByEdad(){
        Comparator<Persona> cmp = new Comparator<Persona>() {
            @Override
            public int compare(Persona o1, Persona o2) {
                return o1.getEdad() - o2.getEdad();
            }
        };
        return cmp;
    }

    public static List<String> getStringsShorterThan(List<String> inputList, int k){
        List<String> resultados = new LinkedList<>();
        for (String elemento: inputList) {
            if (elemento.length() < k){
                resultados.addLast(elemento);
            }
        }
        return resultados;
    }
}