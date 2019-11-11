package es.thirtyfour.array;

import java.util.ArrayList;

public class ConsecutiveCount {

    private ArrayList <Integer> list;
    private int[] array;

    public ConsecutiveCount(int [] array){
        list = new ArrayList<>();
        this.array=array;
    }

    public int length(){

        int num=0;
        for (int i=0;i<array.length;i++){
            num=array[i];
            for (int k=0;k<array.length;k++){
                if(num>array[k])
                    num = array[k];
            }
        }

        list.add(num);

        for(int i=0;i<array.length;i++)
            if (array[i]==num+1){
                num=array[i];
                list.add(num);
                i=0;
            }

        return list.size();
    }

    public int[] getNewArray(){
        int[] newArray=new int[list.size()];
        for (int i=0;i<list.size();i++)
            newArray[i]=list.get(i);

        return newArray;
    }

}
