package vector.example;

public class Vector2D {
    private double x,y;

    public static class PolarCoords{
        private double theta, len;

        public PolarCoords(double theta,double len){
            if(len<0)
                throw new IllegalArgumentException("Length can't be negative");
            if(theta>2*Math.PI || len < 0)
                throw new IllegalArgumentException("Theta must be between 0 and 2");
            this.theta=theta;
            this.len=len;
        }

        public double getTheta() {
            return theta;
        }

        public double getLen() {
            return len;
        }
    }

    public Vector2D(){
        x=0;
        y=0;
    }

    public Vector2D(double x, double y){
        this.x=x;
        this.y=y;
    }

    public Vector2D(Vector2D.PolarCoords coords){
        this.x=Math.cos(coords.getTheta())*coords.getLen();
        this.y=Math.sin(coords.getTheta())*coords.getLen();
    }

    public void setValue(double x, double y){
        this.x=x;
        this.y=y;
    }

    public void setValuePolar(double theta, double len){
        this.x=Math.cos(theta)*len;
        this.y=Math.sin(theta)*len;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double length(){
        return Math.sqrt(x*x+y*y);
    }

    public void add(Vector2D other){
        this.x += other.x;
        this.y += other.y;
    }

    public void scale(double x){
        this.x *= x;
        this.y *= x;
    }

    @Override
    public String toString(){
        return "Vector2D ["+x+", "+y+"]";
    }
}
