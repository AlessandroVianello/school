package es.ten.array;

public class Main {

    public static int findMin(int[] array){
        int ris=array[0];
        for(int i=1;i<array.length;i++)
            if(ris>=array[i])
                ris=array[i];
        return ris;
    }

    public static int findMax(int[] array){
        int ris=array[0];
        for(int i=1;i<array.length;i++)
            if(ris<=array[i])
                ris=array[i];
        return ris;
    }

    public static void main(String[] args) {
        int[] array= new int[10];
        for(int i=0;i<array.length;i++){
            array[i]=(int)(Math.random()*10);
        }
        System.out.println("num min: "+findMin(array));
        System.out.println("num max: "+findMax(array));
    }
}
