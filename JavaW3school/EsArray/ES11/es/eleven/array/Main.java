package es.eleven.array;

public class Main {
    public static int[] reverse(int[] array){
        int[] ris=new int[array.length];
        int k=0;
        for(int i=array.length-1;i>=0;i--){
            ris[k]=array[i];
            k++;
        }
        return ris;
    }
    public static void main(String[] args) {
        int[] array={1,2,3,4,5,6,7,8,9,10};
        array=reverse(array);
        for (int i=0;i<array.length;i++)
            System.out.print(array[i]+" ");
    }
}
