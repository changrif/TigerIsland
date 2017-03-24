import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Michelle on 3/21/2017.
 */
public class DeckTest {
    Deck deck;
    Tile t;
    private int tileID;
    Hex h1, h2, h3;

    @Before
    public void createDeck(){
        deck = new Deck();
        deck.generateTiles();
    }

    @Test
    public void deckDecreasesByOneWhenTileIsDrawn(){
        deck.draw();
        Assert.assertEquals(47, deck.getCurrentSizeOfDeck());
    }

    @Test
    public void deckSizeShouldBeFortyEightBeforeDrawingAnyTiles(){
        Assert.assertEquals(48, deck.getCurrentSizeOfDeck());
    }
    @Test
    public void deckSizeShouldBeZeroWhenAllTilesAreDrawn(){
        for(int i = 0; i < 48; i++){
            deck.draw();
        }
        Assert.assertEquals(0, deck.getCurrentSizeOfDeck());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void ExceptionShouldBeThrownWhenMoreThanFortyEightTilesAreDrawn(){
        for(int i = 0; i < 49; i++){
            deck.draw();
        }
    }

    @Test
    public void checkThatAll48TilesWereCreatedWithCorrectHexForVolcanoTerrain(){
        /*h1 = new Hex(Terrain.typesOfTerrain.VOLCANO);
        h2 = new Hex(Terrain.typesOfTerrain.JUNGLE);
        h3 = new Hex(Terrain.typesOfTerrain.JUNGLE);

        Tile JJ_1 = new Tile(h1,h2,h3, tileID);*/

        int volcanoCount = 0;
        for(int i = 0; i < 47; i++){
            t = deck.draw();
            Assert.assertEquals(Terrain.typesOfTerrain.VOLCANO, t.getHex1().getTerrainType());

            if(Terrain.typesOfTerrain.VOLCANO == t.getHex1().getTerrainType()){
                volcanoCount++;
            }
        }
        Assert.assertEquals(47, volcanoCount);
        /*Tile tile = new Tile(hex1, hex2, hex3, 0);
        Assert.assertEquals(true,deck.contains(tile));*/

    }

    @Test
    public void checkThatAll48TilesWereCreatedWithCorrectCombinationOfTerrains(){
        /*h1 = new Hex(Terrain.typesOfTerrain.VOLCANO);
        h2 = new Hex(Terrain.typesOfTerrain.JUNGLE);
        h3 = new Hex(Terrain.typesOfTerrain.JUNGLE);

        Tile JJ_1 = new Tile(h1,h2,h3, tileID);*/

        int LakeAndRockyTile = 0, LakeAndGrasslandTile = 0, LakeAndLakeTile = 0, LakeAndJungleTile = 0;
        int RockyAndLakeTile = 0, GrasslandAndLakeTile = 0, JungleAndLakeTile = 0, RockyAndJungleTile = 0;
        int RockyAndRockyTile = 0, RockyAndGrasslandTile = 0, JungleAndRockyTile = 0, GrasslandAndRockyTile = 0;
        int GrasslandAndJungleTile = 0, GrasslandAndGrasslandTile = 0, JungleAndJungleTile = 0, JungleAndGrasslandTile = 0;

        for(int i = 0; i < 48; i++){
            t = deck.draw();
            if(Terrain.typesOfTerrain.VOLCANO == t.getHex1().getTerrainType() && Terrain.typesOfTerrain.LAKE == t.getHex2().getTerrainType() && Terrain.typesOfTerrain.ROCKY == t.getHex3().getTerrainType()){
                LakeAndRockyTile++;
            }
            else if(Terrain.typesOfTerrain.VOLCANO == t.getHex1().getTerrainType() && Terrain.typesOfTerrain.LAKE == t.getHex2().getTerrainType() && Terrain.typesOfTerrain.GRASSLANDS == t.getHex3().getTerrainType()){
                LakeAndGrasslandTile++;
            }
            else if(Terrain.typesOfTerrain.VOLCANO == t.getHex1().getTerrainType() && Terrain.typesOfTerrain.LAKE == t.getHex2().getTerrainType() && Terrain.typesOfTerrain.LAKE == t.getHex3().getTerrainType()){
                LakeAndLakeTile++;
            }
            else if(Terrain.typesOfTerrain.VOLCANO == t.getHex1().getTerrainType() && Terrain.typesOfTerrain.LAKE == t.getHex2().getTerrainType() && Terrain.typesOfTerrain.JUNGLE == t.getHex3().getTerrainType()){
                LakeAndJungleTile++;
            }
            else if(Terrain.typesOfTerrain.VOLCANO == t.getHex1().getTerrainType() && Terrain.typesOfTerrain.ROCKY == t.getHex2().getTerrainType() && Terrain.typesOfTerrain.LAKE == t.getHex3().getTerrainType()){
                RockyAndLakeTile++;
            }
            else if(Terrain.typesOfTerrain.VOLCANO == t.getHex1().getTerrainType() && Terrain.typesOfTerrain.GRASSLANDS == t.getHex2().getTerrainType() && Terrain.typesOfTerrain.LAKE == t.getHex3().getTerrainType()){
                GrasslandAndLakeTile++;
            }
            else if(Terrain.typesOfTerrain.VOLCANO == t.getHex1().getTerrainType() && Terrain.typesOfTerrain.JUNGLE == t.getHex2().getTerrainType() && Terrain.typesOfTerrain.LAKE == t.getHex3().getTerrainType()){
                JungleAndLakeTile++;
            }
            else if(Terrain.typesOfTerrain.VOLCANO == t.getHex1().getTerrainType() && Terrain.typesOfTerrain.ROCKY == t.getHex2().getTerrainType() && Terrain.typesOfTerrain.JUNGLE == t.getHex3().getTerrainType()){
                RockyAndJungleTile++;
            }
            else if(Terrain.typesOfTerrain.VOLCANO == t.getHex1().getTerrainType() && Terrain.typesOfTerrain.ROCKY == t.getHex2().getTerrainType() && Terrain.typesOfTerrain.ROCKY == t.getHex3().getTerrainType()){
                RockyAndRockyTile++;
            }
            else if(Terrain.typesOfTerrain.VOLCANO == t.getHex1().getTerrainType() && Terrain.typesOfTerrain.ROCKY == t.getHex2().getTerrainType() && Terrain.typesOfTerrain.GRASSLANDS == t.getHex3().getTerrainType()){
                RockyAndGrasslandTile++;
            }
            else if(Terrain.typesOfTerrain.VOLCANO == t.getHex1().getTerrainType() && Terrain.typesOfTerrain.GRASSLANDS == t.getHex2().getTerrainType() && Terrain.typesOfTerrain.ROCKY == t.getHex3().getTerrainType()){
                GrasslandAndRockyTile++;
            }
            else if(Terrain.typesOfTerrain.VOLCANO == t.getHex1().getTerrainType() && Terrain.typesOfTerrain.JUNGLE == t.getHex2().getTerrainType() && Terrain.typesOfTerrain.ROCKY == t.getHex3().getTerrainType()){
                JungleAndRockyTile++;
            }
            else if(Terrain.typesOfTerrain.VOLCANO == t.getHex1().getTerrainType() && Terrain.typesOfTerrain.JUNGLE == t.getHex2().getTerrainType() && Terrain.typesOfTerrain.JUNGLE == t.getHex3().getTerrainType()){
                JungleAndJungleTile++;
            }
            else if(Terrain.typesOfTerrain.VOLCANO == t.getHex1().getTerrainType() && Terrain.typesOfTerrain.JUNGLE == t.getHex2().getTerrainType() && Terrain.typesOfTerrain.GRASSLANDS == t.getHex3().getTerrainType()){
                JungleAndGrasslandTile++;
            }
            else if(Terrain.typesOfTerrain.VOLCANO == t.getHex1().getTerrainType() && Terrain.typesOfTerrain.GRASSLANDS == t.getHex2().getTerrainType() && Terrain.typesOfTerrain.JUNGLE == t.getHex3().getTerrainType()){
                GrasslandAndJungleTile++;
            }
            else if(Terrain.typesOfTerrain.VOLCANO == t.getHex1().getTerrainType() && Terrain.typesOfTerrain.GRASSLANDS == t.getHex2().getTerrainType() && Terrain.typesOfTerrain.GRASSLANDS == t.getHex3().getTerrainType()){
                GrasslandAndGrasslandTile++;
            }

        }
        Assert.assertEquals(3, LakeAndGrasslandTile);
        Assert.assertEquals(3, LakeAndJungleTile);
        Assert.assertEquals(3, LakeAndLakeTile);
        Assert.assertEquals(3, LakeAndRockyTile);
        Assert.assertEquals(3, JungleAndLakeTile);
        Assert.assertEquals(3, GrasslandAndLakeTile);
        Assert.assertEquals(3, RockyAndLakeTile);
        Assert.assertEquals(3, RockyAndGrasslandTile);
        Assert.assertEquals(3, RockyAndJungleTile);
        Assert.assertEquals(3, RockyAndRockyTile);
        Assert.assertEquals(3, GrasslandAndRockyTile);
        Assert.assertEquals(3, JungleAndRockyTile);
        Assert.assertEquals(3, GrasslandAndGrasslandTile);
        Assert.assertEquals(3, GrasslandAndJungleTile);
        Assert.assertEquals(3, JungleAndGrasslandTile);
        Assert.assertEquals(3, JungleAndJungleTile);

        /*Tile tile = new Tile(hex1, hex2, hex3, 0);
        Assert.assertEquals(true,deck.contains(tile));*/

    }

    @Test
    public void WhenDrawingTileFromDeckThenItShouldBeValid(){
        t = deck.draw();
        Assert.assertEquals(Terrain.typesOfTerrain.VOLCANO, t.getHex1().getTerrainType());
        Assert.assertNotEquals(null, t.getHex2().getTerrainType());
        Assert.assertNotEquals(null, t.getHex3().getTerrainType());
    }
};
