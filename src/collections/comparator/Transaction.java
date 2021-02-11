package collections.comparator;

import java.util.Date;

public class Transaction {

    final private String mid;

    final private String tid;

    final private Date transactionDate;

    public Transaction(String mid, String tid, Date transactionDate) {
        this.mid = mid;
        this.tid = tid;
        this.transactionDate = transactionDate;
    }

    public String getMid() {
        return mid;
    }

    public String getTid() {
        return tid;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    @Override
    public String toString() {
        return "TransactionComparable{" +
                "mid='" + mid + '\'' +
                ", tid='" + tid + '\'' +
                ", transactionDate=" + transactionDate +
                '}';
    }
}