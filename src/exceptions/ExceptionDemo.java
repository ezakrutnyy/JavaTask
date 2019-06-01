package exceptions;

/**
 * Created by Евгений on 18.05.2018.
 */
public class ExceptionDemo {

    public static void main(String[] args) {
        try {
            lastError();
        } catch (RuntimeException e) {
            System.err.println("Метод mai "+e.getCause());
        }

    }


    static void  lastError() {
        try {
            System.err.println("Пытаемся что то сделать!!!");
            throw new RuntimeException("Ошибка из try");
        } catch(RuntimeException e) {
            System.err.println("Перехватили ошибку в catch - "+e);
            throw new RuntimeException("Ошибка в Catch");
        } finally {
            System.err.println("Перешли в finally");
            RuntimeException e = new RuntimeException("Ошибка в Finale");
            e.initCause(new ArithmeticException("Ошибка деления на ноль"));
            throw e;
        }
    }

}
