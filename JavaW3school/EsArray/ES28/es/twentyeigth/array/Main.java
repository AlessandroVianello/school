package es.twentyeigth.array;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[10];
        int max = 0;
        int min;

        for (int i=0;i<array.length;i++) {
            array[i] = (int) (Math.random() * 10);
            while (array[i]==0)
                array[i]=(int)(Math.random()*10);
        }

        min=array[0];

        for (int i=0;i<array.length;i++){
            if(max<array[i])
                max=array[i];
            if(min>array[i])
                min=array[i];
        }

        System.out.println("Differenza tra MAX e min dell'array: "+(max-min));

    }
}
