package prova.rectangle;

public class CustomerWeightMeasurator implements Measurator {



    @Override
    public double performMeasure(Object o) {
        return ((Customer)o).getWeight();
    }
}
