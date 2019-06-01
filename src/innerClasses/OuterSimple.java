package innerClasses;

/**
 * Created by Евгений on 04.05.2018.
 */

interface InnerInterface {
    String getName();
}

public class OuterSimple {

    final private String description = "Описание объекта - ";

    class Inner implements InnerInterface {
        private String name;
        public Inner(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }

        String getDescriptionInner() {
            return description+" INNER";
        }

        OuterSimple getOuter() {
            return OuterSimple.this;
        }
    }

    String getDescriptionOuter() {
        return description+" OUTER";
    }

    Inner getElem(String name) {
        return new Inner(name);
    }

    // Создание класса внутри метода
    InnerInterface getInnerClassMethod(final String str) {
        class InnerClassMethod implements  InnerInterface{

            private String localStr = str;

            public String getName() {
                return localStr;
            }
        }

        return  new InnerClassMethod();
    }

    // Создание анонимного класса
    InnerInterface getInnerClassAnonymous(final String str) {
        return new InnerInterface() {

            private String anonStr = str;

            @Override
            public String getName() {
                return anonStr;
            }
        };
    }


    public static void main(String[] args) {
        OuterSimple outer = new OuterSimple();
        OuterSimple.Inner inner = outer.getElem("Lyoha Tchar");
        System.out.println(inner.getName());
        System.out.println(inner.getDescriptionInner());

        System.out.println("==========================================");

        OuterSimple.Inner inner2 = outer.new Inner("Новое имя");
        System.out.println(inner2.getName());
        System.out.println(inner2.getDescriptionInner());

        System.out.println("==========================================");

        OuterSimple outer2 = inner2.getOuter();
        System.out.println(outer2.getDescriptionOuter());

        System.out.println("===========Local Inner Class========================");

        OuterSimple outer3 = new OuterSimple();

        InnerInterface inner3 = outer3.getInnerClassMethod("Локальный внутренний класс");
        System.out.println(inner3.getName());

        System.out.println("===========Anonimus Inner Class========================");
        InnerInterface inner4 = outer3.getInnerClassAnonymous("Анонимный внутренний класс");
        System.out.println(inner4.getName());

    }


}
