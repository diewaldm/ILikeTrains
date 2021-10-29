abstract class TrainBase {
    private static int idCounter = 1000;  // zur Erzeugung von unique ID's
    private int id;
    private String name; // Typenbezeichnung
    private double weight; // Leergewicht
    private double length; // Länge
    private int passengers; // Passagiere 0 +
    private double freight; // Güter 0+
    private String manufacturer; // Hersteller
    private int year; // Baujahr
    private String type; // Diesel, Dampf, Elektrisch | Personen, Schlaf, Speise, Güter
    private boolean used; // bereits Teil eines Zuges?

    public TrainBase(int weight, int length, int passengers, int freight, String manufacturer, int year, String type) {
        id = getUniqueId();
        this.name = type+getClass().getSimpleName();
        this.weight = weight;
        this.length = length;
        this.passengers = passengers;
        this.freight = freight;
        this.manufacturer = manufacturer;
        this.year = year;
        this.type = type;
        this.used = false;
    }

    protected static final int getUniqueId() {
        return ++idCounter;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getLength() {
        return length;
    }

    public int getPassengers() {
        return passengers;
    }

    public double getFreight() {
        return freight;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getYear() {
        return year;
    }

    public String getType() {
        return type;
    }

    public void printNodes() {
    }

    public boolean getUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public double getDrag() {
        return 0;
    }
}
