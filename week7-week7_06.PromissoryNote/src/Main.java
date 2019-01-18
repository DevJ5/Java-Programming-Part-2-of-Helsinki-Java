import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Test your program here
        PromissoryNote pn = new PromissoryNote();

        pn.setLoan("bert", 100);
        System.out.println(pn.howMuchIsTheDebt("ok"));
    }
}
