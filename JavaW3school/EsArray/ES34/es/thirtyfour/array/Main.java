package es.thirtyfour.array;

public class Main {
    public static void main(String[] args) {
        int[] array= {49, 1, 3, 200, 2, 4, 70, 5};
        ConsecutiveCount c = new ConsecutiveCount(array);
        int length = c.length();
        int[] newArray=c.getNewArray();

        System.out.println(length);
        for (int i=0;i<newArray.length;i++){
            System.out.print(newArray[i]+" ");
        }

    }
}
