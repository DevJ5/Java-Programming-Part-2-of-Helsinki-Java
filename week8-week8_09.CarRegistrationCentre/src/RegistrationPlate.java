import java.util.Objects;

public class RegistrationPlate {
    // don't change the code which is already given to you

    // ATTENTION: the object variable types are final, meaning that their value cannot be changed!
    private final String regCode;
    private final String country;

    public RegistrationPlate(String country, String regCode) {
        this.regCode = regCode;
        this.country = country;
    }

    @Override
    public String toString() {
        return country + " " + regCode;
    }

    @Override
    public boolean equals(Object obj) {
        if(this ==  obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        RegistrationPlate compared = (RegistrationPlate) obj;

        return Objects.equals(regCode, compared.regCode) &&
                Objects.equals(country, compared.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regCode, country);
    }
}
