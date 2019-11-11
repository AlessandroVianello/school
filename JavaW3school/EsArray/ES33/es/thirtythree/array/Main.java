package es.thirtythree.array;

public class Main {
    public static void main(String[] args) {
        int [] array = {1,1,1,2,2,2,3,3,3,4,4,4,4,4,5,5,5,5,5,5,6,6,6,6,6};
        DuplicateRemover rem = new DuplicateRemover(array);
        int length=rem.removeDuplicate();

        System.out.println(length);

    }
}
