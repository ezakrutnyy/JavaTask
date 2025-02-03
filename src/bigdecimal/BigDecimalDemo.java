package bigdecimal;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Евгений on 05.09.2017.
 */
public class BigDecimalDemo {
    public static void main(String[] args) {
        MathContext mc = new MathContext(2, RoundingMode.HALF_UP);
        BigDecimal test1 = new BigDecimal("45000.232323");
        BigDecimal test2 = new BigDecimal("91999.89898");
        // 0.4891334971
        BigDecimal res = test1.divide(test2, mc);
        System.out.println(res);

        BigDecimal b1 = new BigDecimal("1.0000");
        BigDecimal b2 = BigDecimal.valueOf(1.0000D);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b1.add(b2));

        // Метод equals сравнивает отдельно мантиссу и десятичный порядок, поэтому различные представления одного числа не равны
        BigDecimal eq_1 = new BigDecimal("2.00");
        BigDecimal eq_2 = new BigDecimal("2.0");
        System.out.println("Big decimal eq_1: " + eq_1 + " unscaled value: " + eq_1.unscaledValue() +
                " scale: " + eq_1.scale() + " precision: " + eq_1.precision());
        System.out.println("Big decimal eq_2: " + eq_2 + " unscaled value: " + eq_2.unscaledValue() +
                " scale: " + eq_2.scale() + " precision: " + eq_2.precision());
        System.out.println("Are eq_1 and eq_2 equal ? " + eq_1.equals(eq_2));

        System.out.println("-------------operation stripTrailingZeros-----------------");
        eq_1 = eq_1.stripTrailingZeros();
        System.out.println("Big decimal eq_1: " + eq_1 + " unscaled value: " + eq_1.unscaledValue() +
                " scale: " + eq_1.scale() + " precision: " + eq_1.precision());
        eq_2 = eq_2.stripTrailingZeros();
        System.out.println("Big decimal eq_2: " + eq_2 + " unscaled value: " + eq_2.unscaledValue() +
                " scale: " + eq_2.scale() + " precision: " + eq_2.precision());
        System.out.println("Are eq_1 and eq_2 equal ? " + eq_1.equals(eq_2));

        System.out.println("-------------Equals in HashSet-----------------");
        Set<BigDecimal> st = new HashSet<>();
        st.add(new BigDecimal("2"));
        st.add(new BigDecimal("2.0"));
        st.add(new BigDecimal("2.00"));
        st.add(new BigDecimal("2.000"));
        st.add(new BigDecimal("2.0000"));
        System.out.println("st size: " + st.size());
        System.out.println("st: " + st);

        System.out.println("=============compareTo()====================");
        // Метод сравнения compareTo разные представления одного и того же числа равны
        eq_1 = new BigDecimal("2.00");
        eq_2 = new BigDecimal("2.0");
        System.out.println("Big decimal eq_1: " + eq_1 + " unscaled value: " + eq_1.unscaledValue() +
                " scale: " + eq_1.scale() + " precision: " + eq_1.precision());
        System.out.println("Big decimal eq_2: " + eq_2 + " unscaled value: " + eq_2.unscaledValue() +
                " scale: " + eq_2.scale() + " precision: " + eq_2.precision());
        System.out.println("Are eq_1 and eq_2 equal ? " + (eq_1.compareTo(eq_2) == 0));

        System.out.println("=============TreeSet====================");
        Set<BigDecimal> treeS = new TreeSet<>();
        treeS.add(new BigDecimal("2"));
        treeS.add(new BigDecimal("2.0"));
        treeS.add(new BigDecimal("2.00"));
        treeS.add(new BigDecimal("2.000"));
        System.out.println("TreeSet size: " + treeS.size());
        System.out.println("TreeSet contents: " + treeS);
    }
}