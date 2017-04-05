//import cucumber.api.PendingException;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import org.junit.Assert;
//
///**
// * Created by ddmac on 3/29/2017.
// */
//
//public class BuildTotoroSanctuaryAcceptanceTests {
//
//    @Given("^a player does not have a settlement of size (5) or larger with an empty non-volcanic adjacent hex$")
//    public void a_player_does_not_have_a_settlement_of_size_or_larger_with_an_empty_non_volcanic_adjacent_hex(int arg1) throws Throwable {
//
//    }
//
//    @When("^a player tries to place a totoro during the build phase$")
//    public void a_player_tries_to_place_a_totoro_during_the_build_phase() throws Throwable {
//
//    }
//
//    @Then("^they will not be allowed to add a totoro$")
//    public void they_will_not_be_allowed_to_add_a_totoro() throws Throwable {
//        Map m = new Map();
//        Deck d = new Deck();
//
//        Coordinate c = new Coordinate(98, 101);
//        Coordinate c2 = new Coordinate(99, 99);
//        Coordinate c3 = new Coordinate(100, 100);
//
//        Coordinate settlement1Coords = new Coordinate(97, 101);
//        Coordinate settlement2Coords = new Coordinate(98, 100);
//        Coordinate settlement3Coords = new Coordinate(98, 99);
//        Coordinate settlement4Coords = new Coordinate(99, 100);
//
//        d.generateTiles();
//
//        Tile t = d.draw();
//        m.placeTile(t, c, 5);
//
//
//        Player p = new Player("David");
//
//        Assert.assertEquals(0, p.getOwnedSettlementsSize());
//
//        m.foundNewSettlement(settlement1Coords, p);
//
//        Assert.assertEquals(1, p.getOwnedSettlementsSize());
//        Assert.assertEquals(19, p.getNumberOfMeeplesIHave());
//
//        m.foundNewSettlement(settlement2Coords, p);
//        Assert.assertEquals(2, t.getHex2().getSettlement().getLength());
//        Assert.assertEquals(18, p.getNumberOfMeeplesIHave());
//
//        t = d.draw();
//        m.placeTile(t, c2, 6);
//
//        m.foundNewSettlement(settlement3Coords, p);
//        Assert.assertEquals(3, t.getHex2().getSettlement().getLength());
//        Assert.assertEquals(17, p.getNumberOfMeeplesIHave());
//
//        m.PlaceTotoro(settlement4Coords, p);
//        Assert.assertEquals(3, t.getHex2().getSettlement().getLength());
//        Assert.assertEquals(17, p.getNumberOfMeeplesIHave());
//        Assert.assertEquals(3, p.getNumberOfTotorosIHave());
//        Assert.assertFalse(t.getHex2().getSettlement().getTotoroFlag());
//
//    }
//
//    @Given("^a player has a settlement of size (\\d+) or larger with an empty non-volcanic adjacent hex$")
//    public void a_player_has_a_settlement_of_size_or_larger_with_an_empty_non_volcanic_adjacent_hex(int arg1) throws Throwable {
//
//    }
//
//    @When("^a player enters their build phase$")
//    public void a_player_enters_their_build_phase() throws Throwable {
//
//    }
//
//    @Then("^they can add a Totoro to the empty hex$")
//    public void they_can_add_a_Totoro_to_the_empty_hex() throws Throwable {
//        Map m = new Map();
//        Deck d = new Deck();
//
//        Coordinate c = new Coordinate(98, 101);
//        Coordinate c2 = new Coordinate(99, 99);
//        Coordinate c3 = new Coordinate(100, 100);
//
//        Coordinate settlement1Coords = new Coordinate(97, 101);
//        Coordinate settlement2Coords = new Coordinate(98, 100);
//        Coordinate settlement3Coords = new Coordinate(98, 99);
//        Coordinate settlement4Coords = new Coordinate(99, 100);
//        Coordinate settlement5Coords = new Coordinate(99, 101);
//        Coordinate settlement6Coords = new Coordinate(100, 101);
//
//        d.generateTiles();
//
//        Tile t = d.draw();
//        m.placeTile(t, c, 5);
//
//
//        Player p = new Player("David");
//
//        Assert.assertEquals(0, p.getOwnedSettlementsSize());
//
//        m.foundNewSettlement(settlement1Coords, p);
//
//        Assert.assertEquals(1, p.getOwnedSettlementsSize());
//        Assert.assertEquals(19, p.getNumberOfMeeplesIHave());
//
//        m.foundNewSettlement(settlement2Coords, p);
//        Assert.assertEquals(2, t.getHex2().getSettlement().getLength());
//        Assert.assertEquals(18, p.getNumberOfMeeplesIHave());
//
//        t = d.draw();
//        m.placeTile(t, c2, 6);
//
//        m.foundNewSettlement(settlement3Coords, p);
//        Assert.assertEquals(3, t.getHex2().getSettlement().getLength());
//        Assert.assertEquals(17, p.getNumberOfMeeplesIHave());
//
//        m.foundNewSettlement(settlement4Coords, p);
//        Assert.assertEquals(4, t.getHex3().getSettlement().getLength());
//        Assert.assertEquals(16, p.getNumberOfMeeplesIHave());
//
//        t = d.draw();
//        m.placeTile(t, c3, 1);
//
//        m.foundNewSettlement(settlement5Coords, p);
//        Assert.assertEquals(5, t.getHex2().getSettlement().getLength());
//        Assert.assertEquals(15, p.getNumberOfMeeplesIHave());
//
//        m.PlaceTotoro(settlement6Coords, p);
//        Assert.assertEquals(6, t.getHex3().getSettlement().getLength());
//        Assert.assertEquals(15, p.getNumberOfMeeplesIHave());
//        Assert.assertTrue(t.getHex3().getSettlement().getTotoroFlag());
//    }
//
//    @Given("^a player that has a certain amount of totoros,$")
//    public void a_player_that_has_a_certain_amount_of_totoros() throws Throwable {
//
//    }
//
//    @When("^he/she places a totoro on the board,$")
//    public void he_she_places_a_totoro_on_the_board() throws Throwable {
//
//    }
//
//    @Then("^the amount of totoros available to the player decrease by one$")
//    public void the_amount_of_totoros_available_to_the_player_decrease_by_one() throws Throwable {
//        Map m = new Map();
//        Deck d = new Deck();
//
//        Coordinate c = new Coordinate(98, 101);
//        Coordinate c2 = new Coordinate(99, 99);
//        Coordinate c3 = new Coordinate(100, 100);
//
//        Coordinate settlement1Coords = new Coordinate(97, 101);
//        Coordinate settlement2Coords = new Coordinate(98, 100);
//        Coordinate settlement3Coords = new Coordinate(98, 99);
//        Coordinate settlement4Coords = new Coordinate(99, 100);
//        Coordinate settlement5Coords = new Coordinate(99, 101);
//        Coordinate settlement6Coords = new Coordinate(100, 101);
//
//        d.generateTiles();
//
//        Tile t = d.draw();
//
//        m.placeTile(t, c, 5);
//
//
//        Player p = new Player("David");
//
//        Assert.assertEquals(0, p.getOwnedSettlementsSize());
//
//        m.foundNewSettlement(settlement1Coords, p);
//
//        Assert.assertEquals(1, p.getOwnedSettlementsSize());
//        Assert.assertEquals(19, p.getNumberOfMeeplesIHave());
//
//        m.foundNewSettlement(settlement2Coords, p);
//        Assert.assertEquals(2, t.getHex2().getSettlement().getLength());
//        Assert.assertEquals(18, p.getNumberOfMeeplesIHave());
//
//        t = d.draw();
//        m.placeTile(t, c2, 6);
//
//        m.foundNewSettlement(settlement3Coords, p);
//        Assert.assertEquals(3, t.getHex2().getSettlement().getLength());
//        Assert.assertEquals(17, p.getNumberOfMeeplesIHave());
//
//        m.foundNewSettlement(settlement4Coords, p);
//        Assert.assertEquals(4, t.getHex3().getSettlement().getLength());
//        Assert.assertEquals(16, p.getNumberOfMeeplesIHave());
//
//        t = d.draw();
//        m.placeTile(t, c3, 1);
//
//        m.foundNewSettlement(settlement5Coords, p);
//        Assert.assertEquals(5, t.getHex2().getSettlement().getLength());
//        Assert.assertEquals(15, p.getNumberOfMeeplesIHave());
//
//        m.PlaceTotoro(settlement6Coords, p);
//        Assert.assertEquals(6, t.getHex3().getSettlement().getLength());
//        Assert.assertEquals(15, p.getNumberOfMeeplesIHave());
//        Assert.assertEquals(2, p.getNumberOfTotorosIHave());
//
//    }
//
//    @Given("^a player has a settlement with a Totoro$")
//    public void a_player_has_a_settlement_with_a_Totoro() throws Throwable {
//
//    }
//
//    @When("^a player tries to add another Totoro to that settlement$")
//    public void a_player_tries_to_add_another_Totoro_to_that_settlement() throws Throwable {
//
//    }
//
//    @Then("^they are not allowed to place the Totoro$")
//    public void they_are_not_allowed_to_place_the_Totoro() throws Throwable {
//        Map m = new Map();
//        Deck d = new Deck();
//
//        Coordinate c = new Coordinate(98, 101);
//        Coordinate c2 = new Coordinate(99, 99);
//        Coordinate c3 = new Coordinate(100, 100);
//        Coordinate c4 = new Coordinate(97, 100);
//
//        Coordinate settlement1Coords = new Coordinate(97, 101);
//        Coordinate settlement2Coords = new Coordinate(98, 100);
//        Coordinate settlement3Coords = new Coordinate(98, 99);
//        Coordinate settlement4Coords = new Coordinate(99, 100);
//        Coordinate settlement5Coords = new Coordinate(99, 101);
//        Coordinate settlement6Coords = new Coordinate(100, 101);
//        Coordinate settlement7Coords = new Coordinate(97, 99);
//        Coordinate settlement8Coords = new Coordinate(96, 99);
//
//        d.generateTiles();
//
//        Tile t = d.draw();
//
//        m.placeTile(t, c, 5);
//
//
//        Player p = new Player("David");
//
//        Assert.assertEquals(0, p.getOwnedSettlementsSize());
//
//        m.foundNewSettlement(settlement1Coords, p);
//
//        Assert.assertEquals(1, p.getOwnedSettlementsSize());
//        Assert.assertEquals(19, p.getNumberOfMeeplesIHave());
//
//        m.foundNewSettlement(settlement2Coords, p);
//        Assert.assertEquals(2, t.getHex2().getSettlement().getLength());
//        Assert.assertEquals(18, p.getNumberOfMeeplesIHave());
//
//        t = d.draw();
//        m.placeTile(t, c2, 6);
//
//        m.foundNewSettlement(settlement3Coords, p);
//        Assert.assertEquals(3, t.getHex2().getSettlement().getLength());
//        Assert.assertEquals(17, p.getNumberOfMeeplesIHave());
//
//        m.foundNewSettlement(settlement4Coords, p);
//        Assert.assertEquals(4, t.getHex3().getSettlement().getLength());
//        Assert.assertEquals(16, p.getNumberOfMeeplesIHave());
//
//        t = d.draw();
//        m.placeTile(t, c3, 1);
//
//        m.foundNewSettlement(settlement5Coords, p);
//        Assert.assertEquals(5, t.getHex2().getSettlement().getLength());
//        Assert.assertEquals(15, p.getNumberOfMeeplesIHave());
//
//        m.PlaceTotoro(settlement6Coords, p);
//        Assert.assertEquals(6, t.getHex3().getSettlement().getLength());
//        Assert.assertEquals(15, p.getNumberOfMeeplesIHave());
//        Assert.assertEquals(2, p.getNumberOfTotorosIHave());
//        Assert.assertTrue(t.getHex3().getSettlement().getTotoroFlag());
//
//        t = d.draw();
//        m.placeTile(t, c4, 4);
//
//
//        m.foundNewSettlement(settlement7Coords, p);
//        Assert.assertEquals(7, t.getHex2().getSettlement().getLength());
//        Assert.assertEquals(14, p.getNumberOfMeeplesIHave());
//        Assert.assertEquals(2, p.getNumberOfTotorosIHave());
//
//
//        //Not sure if my logic is wrong or something else
//
//        m.PlaceTotoro(settlement8Coords, p);
//        Assert.assertEquals(7, t.getHex3().getSettlement().getLength());
//        Assert.assertFalse(t.getHex2().getSettlement().getTotoroFlag());
//        Assert.assertEquals(14, p.getNumberOfMeeplesIHave());
//        Assert.assertEquals(2, p.getNumberOfTotorosIHave());
//
//    }
//
//}
