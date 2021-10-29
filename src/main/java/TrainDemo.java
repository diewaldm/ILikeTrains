public class TrainDemo {
    public static void main(String args[]) throws Exception {
        Wagon schlafwagen1 = new Wagon(500, 200, 3, 20, "trainguys", 1999, "Schlaf");
        Wagon schlafwagen2 = new Wagon(500, 200, 3, 20, "trainguys", 1998, "Schlaf");
        Wagon speisewagen1 = new Wagon(400, 200, 3, 50, "trainguys", 2005, "Speise");
        Wagon speisewagen2 = new Wagon(400, 200, 50, 50, "trainguys", 2004, "Speise");
        Wagon personenwagen1 = new Wagon(200, 200, 100, 20, "trainguys", 2007, "Personen");
        Wagon personenwagen2 = new Wagon(250, 200, 150, 20, "trainguys", 2007, "Personen");
        Wagon gueterwagen1 = new Wagon(100, 200, 2, 1000, "trainguys", 2004, "Gueter");
        Wagon gueterwagen2 = new Wagon( 100, 200, 2, 1000, "trainguys", 2010, "Gueter");
        Lok lok = new Lok( 100, 200, 2000, 3, 20, "trainguys", 2020, "Dampf");
        Lok lok2 = new Lok( 100, 200, 2000, 3, 20, "trainguys", 1999, "Diesel");
        Lok lok3 = new Lok( 100, 200, 2000, 3, 20, "trainguys", 1999, "Elektro");
        Train zug1 = new Train("Intercity1");
        Train zug2 = new Train("Intercity2");



        zug1.addPart(lok);
        zug1.addPart(schlafwagen1);
        zug1.addPart(schlafwagen1);
        zug1.addPart(schlafwagen2);
        zug1.addPart(speisewagen1);
        zug1.addPart(personenwagen1);
        zug1.addPart(gueterwagen1);

        zug1.printNodes();
        zug1.removePart(schlafwagen2);
        zug1.printNodes();

        zug2.addPart(lok2);
        zug2.addPart(speisewagen2);
        zug2.addPart(personenwagen2);
        zug2.addPart(gueterwagen2);
        zug2.addPart(schlafwagen2);
        zug2.printNodes();
        zug2.printNodes();

/*        System.out.println();
        System.out.println("Gesamtgewicht: " + zug1.getWeight() + " kg");
        System.out.println("Gesamtpassagiere: " + zug1.getPassengers());
        System.out.println("Gesamt max Zuladungsgewicht für Güter: " + zug1.getFreight() + " kg");
        System.out.println("Maximale Zuladung: " + zug1.getMaxPayload() + " kg");
        System.out.println("Maximales Gesamtgewicht: " + zug1.getMaxWeight() + " kg");
        System.out.println("Zuglänge: " + zug1.getLength() + " m");
        System.out.println("Zug fahrtauglich? " + zug1.isOperable());
        System.out.println("Benötigte Schaffner: " + zug1.neededConductor());*/


    }

}
