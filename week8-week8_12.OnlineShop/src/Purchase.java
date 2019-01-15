public class Purchase {
    private String product;
    private int amount;
    private int unitPrice;

    public Purchase(String product, int amount, int unitPrice) {
        this.product = product;
        this.amount = amount;
        this.unitPrice = unitPrice;
    }

    public int price() {
        return unitPrice * amount;
    }

    public void increaseAmount() {
        this.amount += 1;
    }

    @Override
    public String toString() {
        return product + ": " + amount;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;

        if(this.getClass() != obj.getClass()) return false;

        Purchase compared = (Purchase) obj;

        if(this.product == null || !this.product.equals(compared.product)) return false;
        if(this.amount != compared.amount) return false;
        if(this.unitPrice != compared.unitPrice) return false;

        return true;
    }

    public int hashCode() {
        if(this.product == null) return 7;
        return this.product.hashCode() + this.amount + this.unitPrice;
    }
}
