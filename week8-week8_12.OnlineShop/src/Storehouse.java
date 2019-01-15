import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Storehouse {
    private Map<String, Integer> prices;
    private Map<String, Integer> stocks;

    public Storehouse () {
        this.prices = new HashMap<String, Integer>();
        this.stocks = new HashMap<String, Integer>();
    }

    public void addProduct(String product, int price, int stock) {
        this.prices.put(product, price);
        this.stocks.put(product, stock);
    }

    public int price(String product) {
        if(prices.get(product) != null) return prices.get(product);
        return -99;
    }

    public int stock(String product) {
        if(stocks.containsKey(product)) return stocks.get(product);
        return 0;
    }

    public boolean take(String product) {
        int currentStock = stock(product);
        if(currentStock > 0) {
            stocks.put(product, --currentStock );
            return true;
        }

        return false;
    }

    public Set<String> products() {
        return prices.keySet();
    }

}
