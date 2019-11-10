package sorted;

import java.util.Comparator;

public class GroupBySorterMulti {

    private Comparator<Transaction> multiComparator;

    public GroupBySorterMulti(Comparator<Transaction>...comparators) {
        for (Comparator<Transaction> comparator : comparators) {
            if (multiComparator == null) {
                multiComparator = comparator;
                continue;
            }
            multiComparator = multiComparator.thenComparing(comparator);
        }
    }

    public Comparator<Transaction> get() {
        return multiComparator;
    }
}