import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegister {
    private HashMap<RegistrationPlate, String> owners;

    public VehicleRegister() {
        this.owners = new HashMap<RegistrationPlate, String>();
    }

    public boolean add(RegistrationPlate plate, String owner) {
        if(this.get(plate) != owner) {
            owners.put(plate, owner);
            return true;
        }
        return false;
    }

    public String get(RegistrationPlate plate) {
        return owners.get(plate);
    }

    public boolean delete(RegistrationPlate plate) {
        if(get(plate) != null) {
            owners.remove(plate);
            return true;
        }

        return false;
    }

    public void printRegistrationPlates() {
        for (RegistrationPlate registrationPlate : owners.keySet()) {
            System.out.println(registrationPlate);
        }
    }

    public void printOwners() {
        ArrayList<String> uniqueOwners =  new ArrayList<String>();
        for(String owner : owners.values()) {
            if(!uniqueOwners.contains(owner)) uniqueOwners.add(owner);
        }

        for(String o : uniqueOwners) {
            System.out.println(o);
        }
    }
}
