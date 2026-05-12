package exercitii;

public class Main {
    public static void main(String[] args) {
        Garage myGarage = new Garage(10);

        myGarage.add(new Car("Audi", 220, "C01", 4));
        myGarage.add(new Motorcycle("Honda", 180, "M01", false));
        myGarage.add(new Truck("Volvo", 100, "T01", 5000));
        myGarage.add(new Car("BMW", 250, "C02", 2));
        myGarage.add(new Motorcycle("Yamaha", 200, "M02", true));

        // Demonstratie Polimorfism
        Vehicle[] demoArray = new Vehicle[]{
                new Car("Dacia", 150, "C03", 4),
                new Motorcycle("BMW-Moto", 190, "M03", false)
        };
        for(Vehicle v : demoArray) v.move();

        // Inchiriere
        myGarage.rentById("C01");
        myGarage.rentById("T01");

        System.out.println("--- Vehicule disponibile ---");
        myGarage.printAvailable();
    }
}