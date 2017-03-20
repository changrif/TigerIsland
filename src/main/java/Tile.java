package generic;

/**
 * Created by Kyle on 3/14/2017.
 */
public class Tile {

    private Hex Hex1;
    private Hex Hex2;
    private Hex Hex3;
    private int TileID;

    public Tile(Hex Hex1, Hex Hex2, Hex Hex3, int TileID){
        this.Hex1 = Hex1;
        this.Hex2 = Hex2;
        this.Hex3 = Hex3;

        this.TileID = TileID;
    }

    public int getTileID(){
        return TileID;
    }

    public Hex getHex1(){
        return Hex1;
    }

    public Hex getHex2(){
        return Hex2;
    }

    public Hex getHex3(){
        return Hex3;
    }

    //odd-r horizontal layout
    public void addTile(int x, int y, int TilePos, Hex Map[][]){
        Map[x][y] = getHex1();
        getHex1().setX(x);
        getHex1().setY(y);

        if (TilePos == 1){
            Map[x][y+1] = getHex2();
            getHex2().setX(x);
            getHex2().setY(y+1);

            Map[x+1][y+1] = getHex3();
            getHex3().setX(x+1);
            getHex3().setY(y+1);
        }
        else if (TilePos == 2){
            Map[x+1][y+1] = getHex2();
            getHex2().setX(x+1);
            getHex2().setY(y+1);

            Map[x+1][y] = getHex3();
            getHex3().setX(x+1);
            getHex3().setY(y);
        }

        else if (TilePos == 3){
            Map[x+1][y] = getHex2();
            getHex2().setX(x+1);
            getHex2().setY(y);

            Map[x+1][y-1] = getHex3();
            getHex3().setX(x+1);
            getHex3().setY(y-1);
        }

        else if (TilePos == 4) {
            Map[x + 1][y - 1] = getHex2();
            getHex2().setX(x + 1);
            getHex2().setY(y - 1);

            Map[x][y - 1] = getHex3();
            getHex3().setX(x);
            getHex3().setY(y - 1);
        }

        else if (TilePos == 5){
            Map[x][y-1] = getHex2();
            getHex2().setX(x);
            getHex2().setY(y-1);

            Map[x-1][y] = getHex3();
            getHex3().setX(x-1);
            getHex3().setY(y);
        }

        else if (TilePos == 6){
            Map[x-1][y] = getHex2();
            getHex2().setX(x-1);
            getHex2().setY(y);

            Map[x][y+1] = getHex3();
            getHex3().setX(x);
            getHex3().setY(y+1);
        }
    }

    public static void main(String [] args) {

        String TerrainTypes[] = {"Jungle", "Lake", "Grassland", "Rocky"};
        Tile TileArray[] = new Tile[48];
        int TileIndex = 0;

        for (int i = 0; i < 3; i++){
            for (String terrain: TerrainTypes){
                Hex hex1 = new Hex("Volcano");
                Hex hex2 = new Hex(terrain);
                Hex hex3 = new Hex("Jungle");
                TileArray[TileIndex] = new Tile(hex1, hex2, hex3, TileIndex);
                TileIndex++;
            }

            for (String terrain: TerrainTypes){
                Hex hex1 = new Hex("Volcano");
                Hex hex2 = new Hex(terrain);
                Hex hex3 = new Hex("Lake");
                TileArray[TileIndex] = new Tile(hex1, hex2, hex3, TileIndex);
                TileIndex++;
            }

            for (String terrain: TerrainTypes){
                Hex hex1 = new Hex("Volcano");
                Hex hex2 = new Hex(terrain);
                Hex hex3 = new Hex("Grassland");
                TileArray[TileIndex] = new Tile(hex1, hex2, hex3, TileIndex);
                TileIndex++;
            }

            for (String terrain: TerrainTypes){
                Hex hex1 = new Hex("Volcano");
                Hex hex2 = new Hex(terrain);
                Hex hex3 = new Hex("Rocky");
                TileArray[TileIndex] = new Tile(hex1, hex2, hex3, TileIndex);
                TileIndex++;
            }

        }

        for (int i = 0; i < 1; i++) {
            Hex hex1 = TileArray[i].getHex1();
            Hex hex2 = TileArray[i].getHex2();
            Hex hex3 = TileArray[i].getHex3();

            System.out.println(hex1.getTerrainType());
            System.out.println(hex2.getTerrainType());
            System.out.println(hex3.getTerrainType());

            System.out.println("TileID: " + TileArray[i].getTileID());

            System.out.println();

        }

    }

}
