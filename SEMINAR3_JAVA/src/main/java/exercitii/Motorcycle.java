package exercitii;

public class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(String brand, double speed, String id, boolean hasSidecar) {
        super(brand, speed, id);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public boolean needsService() {
        return getMileage() >= 6000;
    }

    @Override
    public double rentalPrice(int days) {
        double price = 30 * days;
        if (hasSidecar) price += (15 * days);
        return price;
    }
}