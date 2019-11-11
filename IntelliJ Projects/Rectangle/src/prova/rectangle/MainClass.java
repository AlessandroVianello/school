package prova.rectangle;

import javax.swing.*;
import java.awt.*;

public class MainClass {
    public static void main(String[] args) {
        Rectangle a,b;
        a=new Rectangle(10,10,100,100);
        b=new Rectangle(5,20,50,70);
        double area_a=a.computeArea();
        double area_b=b.computeArea();

        MeasurableHandler mh=new MeasurableHandler();
        mh.add(a);
        mh.add(b);
        mh.add(new Country("Italia",300000));
        mh.add(new Country("Francia",400000));
        System.out.println(mh.average());

        Measurable m1 = new Rectangle(10,10,300,400);
        Measurable m2 = new Country("San Marino",30);
        TypedMeasurableHandler<Rectangle> mhrect= new TypedMeasurableHandler<>();
        mhrect.add(b);
        mhrect.add(a);

        StatisticalMeasures.average(new Measurable[]{a,b,new Country("a",1)});

        MeasurableHandler customerHandler = new MeasurableHandler();
        customerHandler.add(new Customer(180.5,70,42));
        customerHandler.add(new Customer(170.5,60,40));
        customerHandler.add(new Customer(190.5,80,44));
        System.out.println(customerHandler.average());
        Measurator myTool = new CustomerWeightMeasurator();
        System.out.println(customerHandler.average(myTool));

        Measurator weightInPounds = new Measurator() {
            public double performMeasure(Object o) {
                return ((Customer)o).getWeight()*2.2;
            }
        };

        System.out.println(customerHandler.average(weightInPounds));

        //Measurator weightInGrams = (o) -> ((Customer)o).getWeight()*1000;
        System.out.println(customerHandler.average((o) -> ((Customer)o).getWeight()*1000));

        /*System.out.println("Area rettangolo a: "+area_a);
        System.out.println("Area rettangolo b: "+area_b);

        a.addRectangle(b);
        area_a=a.computeArea();
        System.out.println("Nuova x: "+a.getX());
        System.out.println("Nuova y: "+a.getY());
        System.out.println("Nuova base: "+a.getW());
        System.out.println("Nuova altezza: "+a.getH());
        System.out.println("Nuova area: "+area_a);
        System.out.println(a.toString());

        JFrame window = new JFrame("Test window");
        window.setSize(new Dimension (640,320));
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //JButton button = new JButton("cyka blyat");
        //button.setVisible(true);
        //window.add(button);
        Rectangle t = new Rectangle(10,10,50,100);
        RectangleDisplay display=new RectangleDisplay(t);
        window.add(display);*/

    }
}
