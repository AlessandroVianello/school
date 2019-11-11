package prova.rectangle;

public class Customer implements Measurable{

    private double height;
    private double weight;
    private int shoeSize;

    public Customer(double height, double weight, int shoeSize){
        this.height=height;
        this.weight=weight;
        this.shoeSize=shoeSize;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public int getShoeSize() {
        return shoeSize;
    }

    @Override
    public double getMeasure() {
        return shoeSize;
    }
}


