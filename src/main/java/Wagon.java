public class Wagon extends TrainBase {


    public Wagon(int weight, int length, int passengers, int freight, String manufacturer, int year, String type) {
        super(weight, length, passengers, freight, manufacturer, year, type);
    }

    @Override
    public void printNodes() {
        //System.out.println(" " + getName() + "-" + getId() + " Gewicht: " + getWeight() + "kg - max Passagiere: " +getPassengers() + " - max Güter: " + getFreight() + "kg - Länge: " + getLength() + "m - Hersteller: " + getManufacturer() + " Baujahr: " + getYear() + " Type: " + getType());
        System.out.print(getName() + "-" + getId() + "  ");
    }


}
