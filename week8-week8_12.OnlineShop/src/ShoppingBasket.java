import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingBasket {
    // private List<Purchase> purchases;
    private Map<String, Purchase> purchases;

    public ShoppingBasket() {
        // this.purchases = new ArrayList<Purchase>();
        this.purchases = new HashMap<String, Purchase>();
    }

    public void add(String product, int price) {
        if(purchases.containsKey(product)) {
            Purchase existingProduct = purchases.get(product);
            existingProduct.increaseAmount();
        } else {
            Purchase purchase = new Purchase(product, 1, price);
            purchases.put(product, purchase);
        }
    }

    public int price() {
        int total = 0;
        for (Purchase purchase : purchases.values()) {
            total += purchase.price();
        }

        return total;
    }

    public void print() {
        for (Purchase purchase : purchases.values()) {
            System.out.println(purchase);
        }
    }
}
