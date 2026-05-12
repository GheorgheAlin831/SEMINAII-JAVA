package exercitii;

public abstract class Vehicle {
    private String brand;
    private double speed;
    private String id;
    private int mileage;
    private boolean rented;

    public Vehicle(String brand, double speed, String id) {
        this.brand = brand;
        this.speed = speed;
        this.id = id;
        this.mileage = 0;
        this.rented = false;
    }

    // Getters și Setters
    public String getBrand() { return brand; }
    public double getSpeed() { return speed; }
    public String getId() { return id; }
    public int getMileage() { return mileage; }
    public boolean isRented() { return rented; }

    public void rent() {
        if (rented) throw new RuntimeException("Vehiculul este deja inchiriat!");
        this.rented = true;
    }

    public void returnVehicle(int drivenKm) {
        if (!rented) throw new RuntimeException("Vehiculul nu este inchiriat!");
        if (drivenKm <= 0) throw new RuntimeException("Kilometrii parcursi trebuie sa fie > 0!");
        this.mileage += drivenKm;
        this.rented = false;
    }

    public void move() {
        System.out.println(brand + " se deplaseaza cu " + speed + " km/h.");
    }

    public abstract boolean needsService();
    public abstract double rentalPrice(int days);
}