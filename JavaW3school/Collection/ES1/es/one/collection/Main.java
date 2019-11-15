package es.one.collection;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList <String> colors = new ArrayList<>();
        colors.add("white");
        colors.add("black");
        colors.add("red");

        for (String color : colors) System.out.println(color);
    }
}
