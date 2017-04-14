/**
 * Created by chandlergriffin on 3/26/17.
 * The coordinate class creates an x y z object to represent a hexagonal coordinate on the map. It contains getters and setters
 *  and a function that prints the x, y, and z coordinates.
 */

public class Coordinate {
    private int x;
    private int y;
    private int z;

    public Coordinate(int z, int x, int y) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void coordinateToString()  {
        System.out.println("(X: " + x + ", Y: " + y + ", Z: " + z + ")");
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() { return z; }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setZ(int z) { this.z = z; }
}
