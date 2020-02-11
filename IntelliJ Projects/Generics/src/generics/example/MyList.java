package generics.example;

public class MyList <T>{

    public static class Node <E>{
        public E data;
        public Node next;

        public Node(E data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    private Node <T> head;

    public MyList () {
        head = null;
    }

    public void add(T data){
        head = new Node<>(data,head);
    }

    public T get(int pos) throws OutOfBoundsException{
        Node <T> n = head;
        for (;pos> 0; --pos)
            if ((n=n.next)==null)throw new OutOfBoundsException();
            return n.data;
    }

    public static class OutOfBoundsException extends Exception{

    }

    public static class NotFoundException extends Exception{

    }

    public void remove(T e)throws NotFoundException{

    }

    public static void main(String[] args) throws OutOfBoundsException{
        MyList<Integer> l = new MyList<>();
        l.add(7);
        l.add(89);
        l.add(23);

        Object o = l.get(0);
        int y = (Integer)o;
        System.out.println(y);

    }

}
