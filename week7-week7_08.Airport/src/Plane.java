public class Plane {
    private String ID;
    private int capacity;

    public Plane(String ID, int capacity){
        this.ID = ID;
        this.capacity = capacity;
    }

    public String getID() {
        return ID;
    }

    public int getCapacity() {
        return capacity;
    }
}