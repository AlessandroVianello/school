package exp.collection;

public class Collection<T>{

    private T[] data;
    private int length;

    public Collection(){
        this(10);
    }

    public Collection(int initialSize){
        data = (T[])new Object[initialSize];
        length=0;
    }

    public Collection add(T o){
        if(length >= data.length){
            T[] newData = (T[])new Object[data.length*2];
            for (int i=0 ; i<data.length; i++)
                newData[i]=data[i];
            data = newData;
        }
        data[length++]=o;
        return this;
    }

    public int size(){
        return length;
    }

    public T elementAt(int i){
        if(i<0 || i>=length)
            throw new IllegalArgumentException("Index: "+i+" is invalid");
        return data[i];
    }

}
