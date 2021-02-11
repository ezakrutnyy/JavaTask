package collections.comparator;

import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;

public class GroupBySorter implements Comparator<Transaction> {

    private List<Comparator<Transaction>> comparators;

    public GroupBySorter(Comparator<Transaction>...comparators) {
        this.comparators = Lists.newArrayList(comparators);
    }

    @Override
    public int compare(Transaction t1, Transaction t2) {
        for (Comparator<Transaction> comparator : comparators) {
            int res = comparator.compare(t1, t2);
            if (res != 0) {
                return  res;
            }
        }
        return 0;
    }
}