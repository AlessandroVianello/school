package prova.rectangle;

public abstract class StatisticalMeasures {

    public static double average(Measurable[] data){
        double average = 0;
        for (Measurable m:data){
            average+=m.getMeasure();
        }
        return average/data.length;
    }

}
