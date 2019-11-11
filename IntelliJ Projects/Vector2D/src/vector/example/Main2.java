package vector.example;

public abstract class Main2 {
    public static void main(String[] args) {
        Vector2D v1 = new Vector2D(10,10);
        Object saveMe = v1;
        saveMe.toString();
        v1= new Vector3D(10,3,12);
        System.out.println(v1.toString());
        ((Vector3D)v1).add(new Vector3D(1,2,3));
        Vector3D v2 = (Vector3D)v1;
        v2.add(v2);
        System.out.println(v2);
        Vector2D test = new Vector3D(1,2,3);
        System.out.println(test.toString());
    }
}
