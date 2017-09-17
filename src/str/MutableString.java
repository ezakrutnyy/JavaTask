package str;

/**
 * Created by Евгений on 14.08.2017.
 */
public class MutableString {
    public static void main(String[] args) {

        //StringBuffer потокобезопасный StringBuilder работает в однопоточной системе.
        StringBuilder str = new StringBuilder("Romeo");

        //append() добавление вконец строки
        str.append(" and ").append("Julieta!");
        System.out.println(str);

        //insert() добавление подстрочки в строку
        str.insert(5," and Fox!");
        System.out.println(str);

        //replace() замена части строки на подстроку
        str.replace(14,30,"");
        System.out.println(str);

        //delete() части  строки
        str.delete(6,30);
        System.out.println(str);

    }

}
