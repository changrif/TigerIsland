/**
 * Created by chandlergriffin on 3/26/17.
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
        System.out.println("(Z: " + z + ", X: " + x + ", Y: " + y + ")");
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
