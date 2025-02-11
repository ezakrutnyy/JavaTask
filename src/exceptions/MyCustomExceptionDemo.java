package exceptions;


import org.apache.commons.lang3.StringUtils;

import java.io.Serial;


/**
 * Created by Евгений on 06.11.2018.
 */
public class MyCustomExceptionDemo {
    public static void main(String[] args) {
        String text = null;
        try {
            validate(text);
        } catch (Exception ex) {
            System.out.println(ex.getClass());
            System.out.println(ex.getMessage());
        }
    }

    public static void validate(String str) {
        if (StringUtils.isBlank(str)) {
            throw new MyCustomException("Строка не задана");
        }
    }
}

class MyCustomException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 8490290286846860367L;

    MyCustomException(String error) {
        super(error);
    }
}