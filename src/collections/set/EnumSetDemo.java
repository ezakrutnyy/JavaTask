package collections.set;

import java.util.EnumSet;
import java.util.Set;

public class EnumSetDemo {

    public static void main(String[] args) {

        // create set with full list elements enum
        Set<MOSCOW_CLUB> enumAllSet = EnumSet.allOf(MOSCOW_CLUB.class);
        System.out.println(enumAllSet);

        // create set with empty list elements enum
        Set<MOSCOW_CLUB> enumNoneSet = EnumSet.noneOf(MOSCOW_CLUB.class);
        System.out.println(enumNoneSet);
        enumNoneSet.add(MOSCOW_CLUB.CSKA);

        // create set with define count elements
        Set<MOSCOW_CLUB> enumDefineSet = EnumSet.of(MOSCOW_CLUB.SPARTAK, MOSCOW_CLUB.DYNAMO);
        System.out.println(enumDefineSet);

        // create set with Range elements enum
        Set<MOSCOW_CLUB> enumRangeSet = EnumSet.range(MOSCOW_CLUB.TORPEDO, MOSCOW_CLUB.ZIL);
        System.out.println(enumRangeSet);

        // create set with passed elements
        Set<MOSCOW_CLUB> enumPassedSet = EnumSet.complementOf(EnumSet.of(MOSCOW_CLUB.CSKA));
        System.out.println(enumPassedSet);

        // create set way copy from other list
        EnumSet<MOSCOW_CLUB> enumCopySet = EnumSet.copyOf(enumPassedSet);
        enumCopySet.add(MOSCOW_CLUB.CSKA);
        System.out.println(enumCopySet);
    }
}

enum  MOSCOW_CLUB {

    SPARTAK,

    DYNAMO,

    CSKA,

    TORPEDO,

    LOKOMOTIV,

    ZIL
}
