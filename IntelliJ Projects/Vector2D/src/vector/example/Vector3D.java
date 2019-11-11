package vector.example;

public class Vector3D extends Vector2D {
    private double z;

    public Vector3D(){
        super();
        z=0;
    }

    public Vector3D(double x, double y, double z){
        super(x,y);
        this.z=z;
    }

    public double length() {
        return Math.sqrt(z*z+super.length()*super.length());
    }

    public void scale(double s){
        z*=s;
        super.scale(s);
    }

    public void add(Vector3D other){
        this.z += other.z;
        super.add(other);
    }

    @Override
    public String toString(){
        return "Vector3D ["+super.getX()+", "+super.getY()+", "+z+"]";
    }
}
