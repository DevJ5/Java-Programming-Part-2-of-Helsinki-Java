import java.util.*;

public class ShoppingBasket {
    private Map<String, Purchase> purchases;

    public ShoppingBasket(){
        this.purchases = new HashMap<String, Purchase>();
    }

    public void add(String product, int price) {
        if(purchases.containsKey(product)) {
            Purchase purchase = purchases.get(product);
            purchase.increaseAmount();
            purchases.put(product, purchase);
        }
        else purchases.put(product, new Purchase(product, 1, price));
    }

    public int price() {
        int total = 0;
        for (String key : purchases.keySet()) {
            total += purchases.get(key).price();
        }

        return total;
    }

    public void print() {
        for (String key : purchases.keySet()) {
            System.out.println(key + ": " + purchases.get(key).getAmount());
        }
    }
}
