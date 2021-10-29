import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


class TrainTest {

    Train zug = new Train("Testzug");
    Lok lok = new Lok(2000, 20, 2000, 3, 400,"trainguys", 2002, "Dampf");
    Lok lok2 = new Lok(2000, 20, 4000, 3, 400,"trainguys", 2002, "Elektro");
    Wagon schlafwagen = new Wagon(1000, 20, 14, 100, "trainguys", 2001, "Schlaf");
    Wagon speisewagen = new Wagon(400, 20, 3, 50, "trainguys", 2005, "Speise");
    Wagon personenwagen = new Wagon(400, 20, 75, 50, "trainguys", 2005, "Personen");

    @BeforeEach
    void beforeEach(){
        zug.addPart(lok);
        zug.addPart(schlafwagen);
    }



    @Test
    void addPart() {
        zug.addPart(speisewagen);
        assertEquals(3400,zug.getWeight(),"Zuggewicht = Gewicht der hinzugefuegten Lok + schlafwagen + speisewagen");
    }

    @Test
    void removePart() {
        zug.removePart(schlafwagen);
        assertEquals(2000,zug.getWeight(),"Gewicht der Lok alleine");
    }

    @Test
    void printNodes() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        zug.printNodes();
        System.setOut(System.out);
        String output = new String(baos.toByteArray());
        assertTrue(output.contains("DampfLok"),"die hinzugefügte DamfLok wird ausgegeben");
    }

    @Test
    void getWeight() {
        assertEquals(3000,zug.getWeight(),"Lok 2000 + Wagon 1000 = 3000");
    }

    @Test
    void getPassengers() {
        assertEquals(17,zug.getPassengers(),"Lok 3 + Schlafwagen 14 = 17");
    }

    @Test
    void getFreight() {
        assertEquals(500,zug.getFreight(),"Lok 400 + Schlafwagen 100 = 500");
    }

    @Test
    void getMaxPayload() {
        assertEquals(1775,zug.getMaxPayload(),"max Passengers 17 * 75 + max Zuladung 500 = 1775");
    }

    @Test
    void getMaxWeight() {
        assertEquals(4775,zug.getMaxWeight(),"Gewicht 3000 + maxZuladung 1775");
    }

    @Test
    void getLength() {
        assertEquals(40,zug.getLength(),"Zug 20 + Wagen 20 = 40");
    }

    @Test
    void isOperable() {
        assertFalse(zug.isOperable(),"lok zieht 2000 - 4000 mit Eigengewicht - max Gesamtmasse = 4775 ");
        zug.addPart(lok2);
        assertTrue(zug.isOperable(),"neue Zugkraft 10000 - neue max Gesamtmasse = 7400");
    }


    @Test
    void neededConductor() {
        assertEquals(1,zug.neededConductor(),"17 Passagiere - 1 Schaffner");
        zug.addPart(personenwagen);
        assertEquals(2,zug.neededConductor(),"92 Passagiere - 2 Schaffner");
    }
}