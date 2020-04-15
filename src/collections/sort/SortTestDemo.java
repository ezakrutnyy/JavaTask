package collections.sort;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.builder.CompareToBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTestDemo {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public static void main(String[] args) throws ParseException {

        // sorting  by comparable, support Comparison Chain
        System.out.println("************************sortWithComparibleChain()*****************************");
        sortWithComparableChain();
        System.out.println("*******************************************************************************");

        // sorting  by comparator, support Java 8
        System.out.println("************************sortWithJava8()****************************************");
        sortWithJava8();
        System.out.println("*******************************************************************************");

        // sorting  by comparator, support  commons-lang
        System.out.println("************************sortWithCommonsLang()**********************************");
        sortWithCommonsLang();
        System.out.println("*******************************************************************************");

        // sorting  by list comparators, support  GroupBySorter class
        System.out.println("************************sortByGroupBySorter()**********************************");
        sortByGroupBySorter();
        System.out.println("*******************************************************************************");

        // sorting  by list comparators, support  GroupBySorter class
        System.out.println("************************sortByMultiGroupBySorter()*****************************");
        sortByMultiGroupBySorter();
        System.out.println("*******************************************************************************");



    }

    private static void sortWithJava8() throws ParseException {
        List<Transaction> lists = Lists.newArrayList();
        Transaction trx1 = new Transaction("100","100", dateFormat.parse("01.01.2019"));
        lists.add(trx1);

        Transaction trx2 = new Transaction("200","200", dateFormat.parse("01.03.2019"));
        lists.add(trx2);

        Transaction trx3 = new Transaction("300","100", dateFormat.parse("14.01.2019"));
        lists.add(trx3);

        Transaction trx4 = new Transaction("100","200", dateFormat.parse("01.01.2019"));
        lists.add(trx4);

        Transaction trx5 = new Transaction("100","330", dateFormat.parse("18.01.2019"));
        lists.add(trx5);

        Transaction trx6 = new Transaction("100","200", dateFormat.parse("07.01.2019"));
        lists.add(trx6);

        Transaction trx7 = new Transaction("100","200", dateFormat.parse("01.01.2018"));
        lists.add(trx7);

        Transaction trx8 = new Transaction("100","210", dateFormat.parse("09.12.2019"));
        lists.add(trx8);

        Transaction trx9 = new Transaction("200","200", dateFormat.parse("22.02.2019"));
        lists.add(trx9);

        Transaction trx10 = new Transaction("200","200", dateFormat.parse("20.01.2019"));
        lists.add(trx10);

        Collections.sort(lists, new SortedByMids()
                .thenComparing(new SortedByTids())
                .thenComparing(new SortedByDate()));

        lists.forEach(System.out::println);
    }

    private static void sortWithComparableChain() throws ParseException {
        List<TransactionComparable> lists = Lists.newArrayList();
        TransactionComparable trx1 = new TransactionComparable("100","100", dateFormat.parse("01.01.2019"));
        lists.add(trx1);

        TransactionComparable trx2 = new TransactionComparable("200","200", dateFormat.parse("01.03.2019"));
        lists.add(trx2);

        TransactionComparable trx3 = new TransactionComparable("300","100", dateFormat.parse("14.01.2019"));
        lists.add(trx3);

        TransactionComparable trx4 = new TransactionComparable("100","200", dateFormat.parse("01.01.2019"));
        lists.add(trx4);


        TransactionComparable trx5 = new TransactionComparable("100","330", dateFormat.parse("18.01.2019"));
        lists.add(trx5);


        TransactionComparable trx6 = new TransactionComparable("100","200", dateFormat.parse("07.01.2019"));
        lists.add(trx6);

        TransactionComparable trx7 = new TransactionComparable("100","200", dateFormat.parse("01.01.2018"));
        lists.add(trx7);

        TransactionComparable trx8 = new TransactionComparable("100","210", dateFormat.parse("09.12.2019"));
        lists.add(trx8);

        TransactionComparable trx9 = new TransactionComparable("200","200", dateFormat.parse("22.02.2019"));
        lists.add(trx9);

        TransactionComparable trx10 = new TransactionComparable("200","200", dateFormat.parse("20.01.2019"));
        lists.add(trx10);

        Collections.sort(lists);

        lists.forEach(System.out::println);
    }

    private static class SortedByMids implements Comparator<Transaction> {
        @Override
        public int compare(Transaction t1, Transaction t2) {
            return t1.getMid().compareTo(t2.getMid());
        }
    }

    private static class SortedByTids implements Comparator<Transaction> {
        @Override
        public int compare(Transaction t1, Transaction t2) {
            return t1.getTid().compareTo(t2.getTid());
        }
    }

    private static class SortedByDate implements Comparator<Transaction> {
        @Override
        public int compare(Transaction t1, Transaction t2) {
            return t1.getTransactionDate().compareTo(t2.getTransactionDate());
        }
    }


    private static void sortWithCommonsLang() throws ParseException {

        List<Transaction> lists = Lists.newArrayList();
        Transaction trx1 = new Transaction("100","100", dateFormat.parse("01.01.2019"));
        lists.add(trx1);

        Transaction trx2 = new Transaction("200","200", dateFormat.parse("01.03.2019"));
        lists.add(trx2);

        Transaction trx3 = new Transaction("300","100", dateFormat.parse("14.01.2019"));
        lists.add(trx3);

        Transaction trx4 = new Transaction("100","200", dateFormat.parse("01.01.2019"));
        lists.add(trx4);

        Transaction trx5 = new Transaction("100","330", dateFormat.parse("18.01.2019"));
        lists.add(trx5);

        Transaction trx6 = new Transaction("100","200", dateFormat.parse("07.01.2019"));
        lists.add(trx6);

        Transaction trx7 = new Transaction("100","200", dateFormat.parse("01.01.2018"));
        lists.add(trx7);

        Transaction trx8 = new Transaction("100","210", dateFormat.parse("09.12.2019"));
        lists.add(trx8);

        Transaction trx9 = new Transaction("200","200", dateFormat.parse("22.02.2019"));
        lists.add(trx9);

        Transaction trx10 = new Transaction("200","200", dateFormat.parse("20.01.2019"));
        lists.add(trx10);

        Collections.sort(lists, (t1, t2) ->
                new CompareToBuilder().append(t1.getMid(), t2.getMid())
                        .append(t1.getTid(), t2.getTid())
                        .append(t1.getTransactionDate(), t2.getTransactionDate()).toComparison());

        lists.forEach(System.out::println);
    }

    private static void sortByGroupBySorter() throws ParseException {
        List<Transaction> lists = Lists.newArrayList();
        Transaction trx1 = new Transaction("100","100", dateFormat.parse("01.01.2019"));
        lists.add(trx1);

        Transaction trx2 = new Transaction("200","200", dateFormat.parse("01.03.2019"));
        lists.add(trx2);

        Transaction trx3 = new Transaction("300","100", dateFormat.parse("14.01.2019"));
        lists.add(trx3);

        Transaction trx4 = new Transaction("100","200", dateFormat.parse("01.01.2019"));
        lists.add(trx4);

        Transaction trx5 = new Transaction("100","330", dateFormat.parse("18.01.2019"));
        lists.add(trx5);

        Transaction trx6 = new Transaction("100","200", dateFormat.parse("07.01.2019"));
        lists.add(trx6);

        Transaction trx7 = new Transaction("100","200", dateFormat.parse("01.01.2018"));
        lists.add(trx7);

        Transaction trx8 = new Transaction("100","210", dateFormat.parse("09.12.2019"));
        lists.add(trx8);

        Transaction trx9 = new Transaction("200","200", dateFormat.parse("22.02.2019"));
        lists.add(trx9);

        Transaction trx10 = new Transaction("200","200", dateFormat.parse("20.01.2019"));
        lists.add(trx10);

        Collections.sort(lists, new GroupBySorter(new SortedByMids(), new SortedByTids(), new SortedByDate()));
        lists.forEach(System.out::println);
    }

    private static void sortByMultiGroupBySorter() throws ParseException {
        List<Transaction> lists = Lists.newArrayList();
        Transaction trx1 = new Transaction("100","100", dateFormat.parse("01.01.2019"));
        lists.add(trx1);

        Transaction trx2 = new Transaction("200","200", dateFormat.parse("01.03.2019"));
        lists.add(trx2);

        Transaction trx3 = new Transaction("300","100", dateFormat.parse("14.01.2019"));
        lists.add(trx3);

        Transaction trx4 = new Transaction("100","200", dateFormat.parse("01.01.2019"));
        lists.add(trx4);

        Transaction trx5 = new Transaction("100","330", dateFormat.parse("18.01.2019"));
        lists.add(trx5);

        Transaction trx6 = new Transaction("100","200", dateFormat.parse("07.01.2019"));
        lists.add(trx6);

        Transaction trx7 = new Transaction("100","200", dateFormat.parse("01.01.2018"));
        lists.add(trx7);

        Transaction trx8 = new Transaction("100","210", dateFormat.parse("09.12.2019"));
        lists.add(trx8);

        Transaction trx9 = new Transaction("200","200", dateFormat.parse("22.02.2019"));
        lists.add(trx9);

        Transaction trx10 = new Transaction("200","200", dateFormat.parse("20.01.2019"));
        lists.add(trx10);

        GroupBySorterMulti multiSorted =
                new GroupBySorterMulti(new SortedByMids(), new SortedByTids(), new SortedByDate());
        Collections.sort(lists, multiSorted.get());
        lists.forEach(System.out::println);
    }
}