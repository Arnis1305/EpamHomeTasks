package cleancode;

import cleancode.models.ClassificationLevel;
import cleancode.models.ExperimentalTypes;
import cleancode.models.MilitaryType;
import cleancode.planes.ExperimentalPlane;
import cleancode.planes.MilitaryPlane;
import cleancode.planes.PassengerPlane;
import cleancode.planes.Plane;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;

public class AirportTest {
    private static List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalTypes.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalTypes.VTOL, ClassificationLevel.TOP_SECRET)
    );

    private static PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);

    private Airport airport = new Airport(planes);

    @Test
    public void hasMilitaryTransportPlaneTest() {
        Assert.assertTrue(hasMilitaryTransportPlane());
    }

    @Test
    public void getPassengerPlaneWithMaxCapacityTest() {
        Assert.assertEquals(planeWithMaxPassengerCapacity, airport.getPassengerPlaneWithMaxPassengersCapacity());
    }

    @Test
    public void sortByMaxLoadCapacityPlaneTest() {
        Assert.assertTrue(isSortMaxLoadCapacityPlaneCorrect());
    }

    @Test
    public void hasAtLeastOneBomberInMilitaryPlanesTest() {
        Assert.assertTrue(hasAtLeastOneBomberInMilitaryPlanes());
    }

    @Test
    public void hasExperimentalPlanesClassificationLevelHigherThanUnclassifiedTest(){
       Assert.assertFalse(hasExperimentalPlanesClassificationLevelHigherThanUnclassified());
    }

    public boolean hasMilitaryTransportPlane() {
        for (MilitaryPlane militaryPlane : airport.getTransportMilitaryPlanes()) {
            if (militaryPlane.getMilitaryType() == MilitaryType.TRANSPORT) {
                return true;
            }
        }
        return false;
    }

    public boolean isSortMaxLoadCapacityPlaneCorrect() {
        airport.sortByPlaneMaxLoadCapacity();
        for (int i = 0; i < airport.getPlanes().size() - 1; i++) {
            if (airport.getPlanes().get(i).getPlaneMinLoadCapacity() > airport.getPlanes().get(i + 1).getPlaneMinLoadCapacity()) {
                return false;
            }
        }
        return true;
    }

    public boolean hasAtLeastOneBomberInMilitaryPlanes() {
        for (MilitaryPlane militaryPlane : airport.getBomberMilitaryPlanes()) {
            if (militaryPlane.getMilitaryType() == MilitaryType.BOMBER) {
                return true;
            }
        }
        return false;
    }

    public boolean hasExperimentalPlanesClassificationLevelHigherThanUnclassified() {
        for (ExperimentalPlane experimentalPlane : airport.getExperimentalPlanes()){
            if (experimentalPlane.getClassificationLevel() == ClassificationLevel.UNCLASSIFIED){
                return true;
            }
        }
        return false;
    }
}