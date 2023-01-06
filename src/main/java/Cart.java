import java.util.Arrays;
import java.util.Locale;
import java.util.Map;

public class Cart {
    protected Purchase[] purchases;
    protected Map<String, Integer> items;

    public Cart(Map<String, Integer> items) {
        this.items = items;
        purchases = new Purchase[items.size()];
    }

    public void addPurchase(String title, int count) {
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) {
                purchases[i] = new Purchase(title, count);
                return;
            }
            if (purchases[i].title.equals(title)) {
                purchases[i].count += count;
                return;
            }
        }
    }

    public long sum() {
        long sum = 0;
        System.out.println("КОРЗИНА:");
        for (int i = 0; i < purchases.length; i++) {
            Purchase purchase = purchases[i];
            if (purchase == null) continue;
            System.out.println("\t" + purchase.title + " " + purchase.count + " шт. в сумме " + (purchase.count * items.get(purchase.title)) + " руб.");
            sum += purchase.count * items.get(purchase.title);
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "purchases=" + Arrays.toString(purchases) +
                '}';
    }
}
