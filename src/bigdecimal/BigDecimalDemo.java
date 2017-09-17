package bigdecimal;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Евгений on 05.09.2017.
 */
public class BigDecimalDemo {
    public static void main(String[] args) {

        // Представление числа BigDecimal
        BigDecimal b = new BigDecimal("200");

        System.out.println("Big Decimal: "+b);
        System.out.println("Value: "+b.unscaledValue());
        System.out.println("Scale: "+b.scale());
        System.out.println("Precision: "+b.precision());

        b = b.setScale(2);

        System.out.println("Big Decimal: "+b);
        System.out.println("Value: "+b.unscaledValue());
        System.out.println("Scale: "+b.scale());
        System.out.println("Precision: "+b.precision());

        b = b.setScale(-2);
        System.out.println("Big Decimal: "+b);
        System.out.println("Value: "+b.unscaledValue());
        System.out.println("Scale: "+b.scale());
        System.out.println("Precision: "+b.precision());

        System.out.println("=========================================");

        // Метод equals сравнивает отдельно мантиссу и десятичный порядок, поэтому различные представления одного числа не равны
        BigDecimal eq_1 = new BigDecimal("2.00");
        BigDecimal eq_2 = new BigDecimal("2.0");
        System.out.println("Big decimal eq_1: " + eq_1 + " unscaled value: " + eq_1.unscaledValue() +
                " scale: " + eq_1.scale() + " precision: " + eq_1.precision());

        System.out.println("Big decimal eq_2: " + eq_2 + " unscaled value: " + eq_2.unscaledValue() +
                " scale: " + eq_2.scale() + " precision: " + eq_2.precision());

        System.out.println("Are eq_1 and eq_2 equal ? " + eq_1.equals(eq_2));

        eq_1 = eq_1.stripTrailingZeros();
        System.out.println("Big decimal eq_1: " + eq_1 + " unscaled value: " + eq_1.unscaledValue() +
                " scale: " + eq_1.scale() + " precision: " + eq_1.precision());

        eq_2 = eq_2.stripTrailingZeros();
        System.out.println("Big decimal eq_2: " + eq_2 + " unscaled value: " + eq_2.unscaledValue() +
                " scale: " + eq_2.scale() + " precision: " + eq_2.precision());

        System.out.println("Are eq_1 and eq_2 equal ? " + eq_1.equals(eq_2));
        System.out.println("Equal references? " + (eq_1 == eq_2));

        Set<BigDecimal> st = new HashSet<BigDecimal>();
        st.add(new BigDecimal("2"));
        st.add(new BigDecimal("2.0"));
        st.add(new BigDecimal("2.00"));
        st.add(new BigDecimal("2.000"));
        st.add(new BigDecimal("2.0000"));
        System.out.println("st size: "+st.size());
        System.out.println("st: "+st);

        System.out.println("=========================================");

        // Метод сравнения compareTo разные представления одного и того же числа равны
        eq_1 = new BigDecimal("2.00");
        eq_2 = new BigDecimal("2.0");

        System.out.println("Big decimal eq_1: " + eq_1 + " unscaled value: " + eq_1.unscaledValue() +
                " scale: " + eq_1.scale() + " precision: " + eq_1.precision());

        System.out.println("Big decimal eq_2: " + eq_2 + " unscaled value: " + eq_2.unscaledValue() +
                " scale: " + eq_2.scale() + " precision: " + eq_2.precision());

        System.out.println("Are eq_1 and eq_2 equal ? " + (eq_1.compareTo(eq_2) == 0));

        Set<BigDecimal> treeS = new TreeSet<BigDecimal>();
        treeS.add(new BigDecimal("2"));
        treeS.add(new BigDecimal("2.0"));
        treeS.add(new BigDecimal("2.00"));
        treeS.add(new BigDecimal("2.000"));
        System.out.println("TreeSet size: " + treeS.size());
        System.out.println("TreeSet contents: " + treeS);



    }
}
