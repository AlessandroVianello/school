package es.twentysix.array;

public class Main {
    public static void main(String[] args) {
        int [] array = {1,0,2,0,0,3,0,4,5,0,0,0,6,7,8,9,0,10};

        int i=0;
        while (i<array.length) {
            if (array[i] == 0) {
                for (int k = i + 1; k < array.length; k++) {
                    if (array[k] != 0) {
                        array[i] = array[k];
                        array[k] = 0;
                        i++;
                    }
                }
            }
            i++;
        }

        for(i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }

    }
}
