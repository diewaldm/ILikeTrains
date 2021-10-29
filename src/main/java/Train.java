import java.util.ArrayList;
import java.util.List;

public class Train {
    private String name;
    private List<TrainBase> childParts;

    public Train(String name) {

            this.name = name;
            this.childParts = new ArrayList<>();
    }

    public void addPart(TrainBase trainpart){

        if (!trainpart.getUsed()) {
            childParts.add(trainpart);
            trainpart.setUsed(true);

        } else {
           System.out.println("Zugteil " + trainpart.getName() + "-" + trainpart.getId() + " bereits in Verwendung - nicht gekoppelt");
        }
    }

    public void removePart(TrainBase trainpart) {
        if (childParts.remove(trainpart)) {
            trainpart.setUsed(false);
        } else {
            System.out.println(trainpart.getName() + "-" + trainpart.getId() + " nicht an " + name + " gekoppelt - nicht entfernt");
        }
    }

    public void printNodes() {
        System.out.println(" ");
        System.out.print("Zug " + name + ": ");
        childParts.forEach(TrainBase::printNodes);
    }

    public double getWeight() {
        if (childParts.size() == 0) {
            return 0;
        }
        double x = 0;
        for (TrainBase child : childParts) {
            x += child.getWeight();
        }
        return x;
    }

    public int getPassengers() {
        if (childParts.size() == 0) {
            return 0;
        }
        int x = 0;
        for (TrainBase child : childParts) {
            x += child.getPassengers();
        }
        return x;
    }

    public double getFreight() {
        if (childParts.size() == 0) {
            return 0;
        }
        double x = 0;
        for (TrainBase child : childParts) {
            x += child.getFreight();
        }
        return x;
    }

    public double getMaxPayload() {
        return (getPassengers() * 75 + getFreight());
    }

    public double getMaxWeight() {
        return (getWeight() + getMaxPayload());
    }

    public double getLength() {
        if (childParts.size() == 0) {
            return 0;
        }
        double x = 0;
        for (TrainBase child : childParts) {
            x += child.getLength();
        }
        return x;
    }

    public boolean isOperable() {
        double x = 0;
    //    boolean atLeastoneLok = false;
        for (TrainBase child : childParts) {
    //        if(child.getClass().getSimpleName().equalsIgnoreCase("Lok"))atLeastoneLok=true ;
            // Mein Versuch umzusetzen, dass ein Zug mindestens eine Lok haben muss - ist keine vorhanden ist die Zugkraft aber 0 und der Zug ohnehin nicht fahrtauglich
            x += child.getDrag();
        }
        return (x >= getMaxWeight()); // &&atLeastOneLok
    }

    public int neededConductor() {
        return (getPassengers() > 0 && getPassengers() < 50) ? 1 : (int) Math.ceil(getPassengers() / 50.0);
    }
}
