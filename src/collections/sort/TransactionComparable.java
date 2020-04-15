package collections.sort;

import com.google.common.collect.ComparisonChain;

import java.util.Date;

public class TransactionComparable implements Comparable<TransactionComparable> {

    final private String mid;

    final private String tid;

    final private Date transactionDate;

    public TransactionComparable(String mid, String tid, Date transactionDate) {
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

    public int compareTo(TransactionComparable that) {
        return ComparisonChain.start().compare(this.mid, that.mid)
                .compare(this.tid, that.tid)
                .compare(this.transactionDate, that.transactionDate)
                .result();
    }
}