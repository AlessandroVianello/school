package prova.rectangle;

public class CustomerHeightMeasurator implements Measurator {
    @Override
    public double performMeasure(Object o) {
        return ((Customer)o).getHeight();
    }
}
