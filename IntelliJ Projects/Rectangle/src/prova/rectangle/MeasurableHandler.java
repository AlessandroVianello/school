package prova.rectangle;

import java.util.Vector;

public class MeasurableHandler implements Measurable{

    private Vector<Measurable> data;

    public MeasurableHandler(){
        this.data=new Vector<Measurable>();
    }

    public MeasurableHandler add(Measurable m){
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


    @Override
    public double getMeasure() {
        return 0;
    }
}
