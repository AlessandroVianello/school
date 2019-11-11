package vector.example;

public class Main {
    public static void main(String[] args) {

        Vector2D v1 = new Vector2D(10,10);
        Vector2D v2 = new Vector2D(4,3);
        Vector2D v6 = new Vector2D(new Vector2D.PolarCoords(Math.PI,10));
        double l2=v2.length();
        double l1=v1.length();
        Vector3D v3 = new Vector3D(3,4,5);
        Vector3D v4 = new Vector3D(1,2,3);
        Vector2D v5 = new Vector3D(7,8,9);

        v1=v3;

        v3.add(v4);
    }
}
