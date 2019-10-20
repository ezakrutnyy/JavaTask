package parsers;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;

public class DecimalTest {

        private static final BigDecimal expectedDecimal = new BigDecimal(1000);

        private static final String expectedStr = "1 000.00";

        @Test
        public void parseFromStr() throws ParseException {

            String amount1 = "1000";
            String amount2 = "1000.0";
            String amount3 = "1000.00";
            String amount4 = "1 000";
            String amount5 = "1 000.0";
            String amount6 = "1 000.00";

            Assert.assertEquals(0, compareTo(Decimals.convertStrToDecimal(amount1)));
            Assert.assertEquals(0, compareTo(Decimals.convertStrToDecimal(amount2)));
            Assert.assertEquals(0, compareTo(Decimals.convertStrToDecimal(amount3)));
            Assert.assertEquals(0, compareTo(Decimals.convertStrToDecimal(amount4)));
            Assert.assertEquals(0, compareTo(Decimals.convertStrToDecimal(amount5)));
            Assert.assertEquals(0, compareTo(Decimals.convertStrToDecimal(amount6)));
        }



        @Test
        public void parseFromDecimal() {

            BigDecimal decimal1 = new BigDecimal(1000);
            BigDecimal decimal2 = new BigDecimal(1000.0);
            BigDecimal decimal3 = new BigDecimal("1000");
            BigDecimal decimal4 = new BigDecimal("1000.0");
            BigDecimal decimal5 = new BigDecimal("1000.00");

            Assert.assertEquals(expectedStr, Decimals.convertDecimalToStr(decimal1));
            Assert.assertEquals(expectedStr, Decimals.convertDecimalToStr(decimal2));
            Assert.assertEquals(expectedStr, Decimals.convertDecimalToStr(decimal3));
            Assert.assertEquals(expectedStr, Decimals.convertDecimalToStr(decimal4));
            Assert.assertEquals(expectedStr, Decimals.convertDecimalToStr(decimal5));
        }

        private int compareTo(BigDecimal actual) {
            return expectedDecimal.compareTo(actual);
        }

}
