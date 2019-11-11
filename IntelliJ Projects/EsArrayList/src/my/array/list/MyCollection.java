package my.array.list;

public class MyCollection {

    private Object[] list;
    private int counter;

    public MyCollection(){
        /*list=new Object[5];
        counter=0;*/
        this(5);
    }

    public MyCollection(int initialSize){
        list=new Object[initialSize];
        counter=0;
    }

    public int getLenght(){
        return counter;
    }

    public MyCollection add(Object o){
        if(list.length < counter+1){
            Object[] newList = new Object[list.length*2];
            for (int i =0;i<list.length;i++)
                newList[i]=list[i];
            list=newList;
        }
        list[counter++]=o;
        return this;
        //counter++;
    }

    public Object get(int index){
        if(index >= counter || index < 0)
            throw new IllegalArgumentException("index out of bounds");
        return list[index];
    }

    public String toString(){
        String out = "MyCollection";
        for(int i=0;i<counter;i++)
            out += " : "+list[i].toString();
        return out;
    }

}
