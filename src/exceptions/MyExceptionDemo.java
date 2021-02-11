package exceptions;


import org.apache.commons.lang3.StringUtils;

/**
 * Created by Евгений on 06.11.2018.
 */
public class MyExceptionDemo {
    public static void main(String[] args) {
        String a = null;
        try {
            validate(a);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void validate(String str) {
        if (StringUtils.isBlank(str)) {
            throw new MyError("Строка не задана");
        }

    }
}

class MyError extends RuntimeException {
    MyError(String error) {
        super(error);
    }
}

