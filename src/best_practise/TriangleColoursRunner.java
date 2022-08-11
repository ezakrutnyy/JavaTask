package best_practise;

import com.google.common.collect.Maps;

import java.util.Map;

public class TriangleColoursRunner {

    private static Map<String, Character> colourTable = Maps.newHashMap();

    static {
        colourTable.put("GB", 'R');
        colourTable.put("BG", 'R');
        colourTable.put("GR", 'B');
        colourTable.put("RG", 'B');
        colourTable.put("RB", 'G');
        colourTable.put("BR", 'G');
    }

    public static void main(String[] args) {
        System.out.println(triangle("R"));
        System.out.println(triangle("B"));
        System.out.println(triangle("RB"));
        System.out.println(triangle("RRBB"));
    }

    private static char triangle(final String row) {

        if (row.length() == 1) return row.charAt(0);

        char[] arrays = row.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < arrays.length; i++) {
            final String find = new String(new char[] {arrays[i - 1], arrays[i]});
            if (colourTable.get(find) != null) {
                sb.append(colourTable.get(find));
            } else {
                sb.append(find.charAt(0));
            }
        }
        return triangle(sb.toString());
    }
}


