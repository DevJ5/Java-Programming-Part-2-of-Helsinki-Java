import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class VehicleRegister {
    private HashMap<RegistrationPlate, String> register;

    public VehicleRegister(){
        this.register = new HashMap<RegistrationPlate, String>();
    }

    public boolean add(RegistrationPlate plate, String owner) {
        if(register.get(plate) != null) return false;
        register.put(plate, owner);
        return true;
    }

    public String get(RegistrationPlate plate) {
        return register.get(plate);
    }

    public boolean delete(RegistrationPlate plate) {
        if(register.containsKey(plate)) {
            register.remove(plate);
            return true;
        }

        return false;
    }

    public void printRegistrationPlates() {
        for (RegistrationPlate key : register.keySet()) {
            System.out.println(key);
        }
    }

    public void printOwners(){
//        ArrayList<String> owners = new ArrayList<String>();
//        for (String owner : register.values()) {
//            if(!owners.contains(owner)) {
//                System.out.println(owner);
//                owners.add(owner);
//            }
//        }

        for (String owner : new HashSet<String>(register.values())) {
            System.out.println(owner);
        }
    }
}
