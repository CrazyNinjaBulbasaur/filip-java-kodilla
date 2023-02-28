package world;


import com.kodilla.sand.Africa;
import com.kodilla.sand.Asia;
import com.kodilla.sand.Europe;
import com.kodilla.sand.SandStorage;
import com.kodilla.world.Continent;
import com.kodilla.world.Country;
import com.kodilla.world.World;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {
        //Given
        World world = prepareTestData();

        //When

        //Then
        BigDecimal expectedSand = new BigDecimal("488");
        assertEquals(expectedSand, world.getPeopleQuantity());
    }

    private World prepareTestData(){
        //countries
        Country russia = new Country("Russia", new BigDecimal("340"));
        Country germany = new Country("Germany", new BigDecimal("79"));

        Country egypt = new Country("Egypt", new BigDecimal("54"));
        Country zimbabwe = new Country("Zimbabwe", new BigDecimal("15"));


        //continents
        Continent europe = new Continent("Europe");
        europe.addCountry(russia);
        europe.addCountry(germany);

        Continent africa = new Continent("Africa");
        africa.addCountry(egypt);
        africa.addCountry(zimbabwe);

        //world
        World world = new World();
        world.addContinent(europe);
        world.addContinent(africa);


        return world;
    }
}
