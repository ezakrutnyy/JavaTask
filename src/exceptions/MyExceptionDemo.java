package exceptions;

import com.sun.deploy.util.StringUtils;

import java.util.Map;

/**
 * Created by Евгений on 06.11.2018.
 */
public class MyExceptionDemo {
    public static void main(String[] args){
        String a = null;
        try {
            validate(a);
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public  static void validate(String s) {
        if (s==null || s.trim().length()==0) {
            throw new MyError("Строка не задана");
        }

    }
}

class MyError extends  RuntimeException {
    MyError(String error) {
        super(error);
    }
}

