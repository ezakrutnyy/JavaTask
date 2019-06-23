package abstractAndInterfaces.functional;

import java.util.function.BinaryOperator;

public class BinaryOperatorDemo {

    public static BinaryOperator<String> getCityString = (str1, str2) -> {

        if (!str1.contains(str2)) {
            return str1+"_"+str2;
        }

        return str1;
    };
}
