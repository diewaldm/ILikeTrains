public class Lok extends TrainBase {

    private double drag;

    public Lok(int weight, int length, double drag, int passengers, int freight, String manufacturer, int year, String type) {
        super(weight, length, passengers, freight, manufacturer, year, type);
        this.drag = drag;
    }

    public double getDrag() {
        return drag + getWeight();
    }

    @Override
    public void printNodes() {
        // System.out.println(" " + getName() + "-" + getId() + " Gewicht: " + getWeight() + "kg - max Passagiere: " +getPassengers() + " - max Güter: " + getFreight() + "kg - Länge: " + getLength() + "m - Zugkraft: " + getZugkraft() + " kg - Hersteller: " + getManufacturer() + " Baujahr: " + getYear()+ " Type: " + getType());
        System.out.print(getName() + "-" + getId() + "  ");

    }


}
