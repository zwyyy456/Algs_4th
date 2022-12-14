package book.example.ch2;
import java.util.Comparator;
import java.util.Date;
public class Transaction {
    private final String who;
    private final Date when;
    private final double amount;

    public static class WhoOrder implements Comparator<Transaction> {
        public int compare(Transaction v, Transaction w) {
            return v.who.compareTo(w.who);
        }
    }
    public static class WhenOrder implements Comparator<Transaction> {
        public int compare(Transaction v, Transaction w) {
            return v.when.compareTo(w.when);
        }
    }
    public static class HowMuchOrder implements Comparator<Transaction> {
        public int compare(Transaction v, Transaction w) {
            if (v.amount < w.amount) return -1;
            if (v.amount > w.amount) return 1;
            return 0;
        }
    }
}
