import java.util.HashMap;

public class PromisoryNote {
    private HashMap<String, Double> loans;

    public PromisoryNote(){
        this.loans = new HashMap<String, Double>();
    }

    public void setLoan(String toWhom, double value) {
        this.loans.put(stringCleaner(toWhom), value);
    }

    public double howMuchIsTheDebt(String whose){
        if(this.loans.containsKey(whose)) return this.loans.get(whose);
        return 0;
    }

    public String stringCleaner(String str) {
        return str.trim().toLowerCase();
    }
}
