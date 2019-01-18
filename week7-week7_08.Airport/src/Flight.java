public class Flight {
    // Flights have a plane, a departure code and a destination code.
    private Plane plane;
    private String departureCode;
    private String destinationCode;

    public Flight(Plane plane, String departureCode, String destinationCode) {
        this.plane = plane;
        this.departureCode = departureCode;
        this.destinationCode = destinationCode;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public String getDepartureCode() {
        return departureCode;
    }

    public void setDepartureCode(String departureCode) {
        this.departureCode = departureCode;
    }

    public String getDestinationCode() {
        return destinationCode;
    }

    public void setDestinationCode(String destinationCode) {
        this.destinationCode = destinationCode;
    }

    @Override
    public String toString() {
       return plane.toString() + " (" + departureCode + "-" + destinationCode + ")";
    }
}
