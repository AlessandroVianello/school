package pizzeria;

public class Node <E>{
	public E element;
	public Node parent;
	public Node leftChild;
	public Node rightChild;
	
	public Node(E element){
		this.element=element;
	}
}
