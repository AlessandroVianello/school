package prova.rectangle;

public class CustomerMeasuredOnWeight extends Customer{

    public CustomerMeasuredOnWeight(double height, double weight, int shoeSize) {
        super(height, weight, shoeSize);

    }

    @Override
    public double getMeasure() {
        return this.getWeight();
    }

}
