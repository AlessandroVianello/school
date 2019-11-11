package es.thirtythree.array;

import java.util.ArrayList;

public class DuplicateRemover {

    private ArrayList<Integer> arrayList;
    private int[] array;

    public DuplicateRemover(int[] array){
        arrayList = new ArrayList<>();
        this.array=array; }

    public int removeDuplicate(){
        int num;
        int i=0;
        boolean end = false;
        num=array[i];
        arrayList.add(num);
        while (!end){
            for (int k=i+1;k<array.length;k++){
                if(num!=array[k]){
                    i=k;
                    num=array[i];
                    arrayList.add(num);
                }
            }
            end = true;
        }
        return arrayList.size();
    }

}
