package prova.rectangle;

import java.util.Vector;

public class TypedMeasurableHandler <E extends Measurable> {

    private Vector<Measurable> data;

    public TypedMeasurableHandler(){
        this.data=new Vector<Measurable>();
    }

    public TypedMeasurableHandler add(E m){
        data.add(m);
        return this;
    }

    public double average(){
        double average = 0;
        for (Measurable m:data){
            average+=m.getMeasure();
        }
        return average/data.size();
    }

    public double average(Measurator tool){
        double average = 0;
        for (Object m:data){
            average+=tool.performMeasure(m);
        }
        return average/data.size();
    }

    public double getMeasure() {
        return 0;
    }
}