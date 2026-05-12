package exercitii;

import java.util.Objects;

public class Car extends Vehicle {
    private int doors;

    public Car(String brand, double speed, String id, int doors) {
        super(brand, speed, id);
        this.doors = doors;
    }

    @Override
    public boolean needsService() {
        return getMileage() >= 10000;
    }

    @Override
    public double rentalPrice(int days) {
        double price = 50 * days;
        if (doors >= 4) price *= 1.10;
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(getId(), car.getId());
    }
}