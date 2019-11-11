package es.twentyone.array;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int[] array={1,2,3,4,5,6,7,8,9,10};
        ArrayList list=new ArrayList();

        for(int i=0;i<array.length;i++)
            list.add(array[i]);

        int size=list.size();

        for (int i=0;i<size;i++)
            System.out.print(list.get(i) + " ");
    }
}
