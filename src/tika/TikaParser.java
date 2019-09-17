package tika;

import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;

import java.util.Set;
import java.util.logging.Logger;

public class TikaParser {

    public static void assertData(String[] expectedData, String[] actualData, boolean sorted) {

        if (expectedData.length != actualData.length) {
            System.out.println("Actual file data lines count != Expected file data lines count");
            System.out.println("Expected file content lines: " + expectedData.length);
            System.out.println("Actual   file content lines: " + actualData.length);
        }

        if (sorted) {
            assertSortedData(expectedData, actualData);
        } else {
            assertUnsortedData(expectedData, actualData);
        }

    }

    private static void assertSortedData(String[] expectedData, String[] actualData) {

        Set<Integer> ignoredLineNumbers = extractIgnoredLineNumbers();

        for (int i = 0; i < expectedData.length; i++) {

            if (ignoredLineNumbers.contains(i)) {
                System.out.println("Ignoring line: " + (expectedData[i]));
                continue;
            }

            if (expectedData[i].equals(actualData[i]))
                continue;

            int index = StringUtils.indexOfDifference(expectedData[i], actualData[i]);

            System.out.println("Expected and actual data not equals. Line: " + i + "\tIndex: " + index);
            System.out.println("Expected file content:" + expectedData[i]);
            System.out.println("Actual file content:" + actualData[i]);
            System.out.println("Different");
            return;
        }

        System.out.println("The same");
    }

    private static void assertUnsortedData(String[] expectedData, String[] actualData) {
        Set<Integer> ignoredLineNumbers = extractIgnoredLineNumbers();
        for (int i = 0; i < expectedData.length; i++) {

            if (ignoredLineNumbers.contains(i)) {
                System.out.println("Ignoring line: " + (actualData[i]));
                continue;
            }

            boolean found = false;
            String expectedLine = expectedData[i];
            for (String actualLine : actualData) {
                if (expectedLine.equals(actualLine)) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Unable found line in actual file data");
                System.out.println("Line: ");
                System.out.println(expectedLine);
                System.out.println("Actual data");
                for (String actualLine : actualData) {
                    System.out.println(actualLine);
                }

                System.out.println("Different");
            }
        }

        System.out.println("The Same");
    }

    private static Set<Integer> extractIgnoredLineNumbers() {
        return Sets.newHashSet();
    }

}