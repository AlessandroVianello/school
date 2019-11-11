package prova.rectangle;

public class Rectangle implements Measurable{

    private double x,y,w,h,currentArea;
    private boolean areaComputed;

    public Rectangle(double x,double y,double w,double h){
        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
        currentArea=0;
        areaComputed=false;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getW() {
        return w;
    }

    public double getH() {
        return h;
    }

    public double computeArea() {

        if (!areaComputed){
            currentArea=getW()*getH();
            areaComputed=true;
        }
        return currentArea;
    }

    public void addRectangle(Rectangle other) {
        double endX=(x+w>other.x+other.w)?x+w:other.x+other.w;
        double endY=(y+h>other.y+other.h)?y+h:other.y+other.h;
        x=x<other.x?x:other.x;
        y=y<other.y?y:other.y;
        w=endX-x;
        h=endY-y;
    }

    public String toString(){
        return "prova.rectangle.Rectangle [x: "+getX()+" "+getY()+" "+getW()+" "+getH()+"]";
    }

    @Override
    public double getMeasure() {
        return computeArea();
    }
}
