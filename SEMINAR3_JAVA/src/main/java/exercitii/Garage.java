package exercitii;

public class Garage {
    private Vehicle[] fleet;
    private int size;

    public Garage(int capacity) {
        this.fleet = new Vehicle[capacity];
        this.size = 0;
    }

    public void add(Vehicle v) {
        if (size >= fleet.length) {
            System.out.println("Garajul este plin!");
            return;
        }
        for (int i = 0; i < size; i++) {
            if (fleet[i].getId().equals(v.getId())) {
                System.out.println("ID duplicat: " + v.getId());
                return;
            }
        }
        fleet[size++] = v;
    }

    public Vehicle findById(String id) {
        for (int i = 0; i < size; i++) {
            if (fleet[i].getId().equals(id)) return fleet[i];
        }
        return null;
    }

    public void rentById(String id) {
        Vehicle v = findById(id);
        if (v != null) v.rent();
    }

    public void returnById(String id, int drivenKm) {
        Vehicle v = findById(id);
        if (v != null) v.returnVehicle(drivenKm);
    }

    public void printAvailable() {
        for (int i = 0; i < size; i++) {
            if (!fleet[i].isRented()) System.out.println("Disponibil: " + fleet[i].getId());
        }
    }

    public void printNeedsService() {
        for (int i = 0; i < size; i++) {
            if (fleet[i].needsService()) System.out.println("Service necesar: " + fleet[i].getId());
        }
    }
}