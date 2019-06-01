package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by Евгений on 15.08.2018.
 */
public class MyFileFilterSearch {
    public static void main(String[] args) {
        String[] listFile;
        final File path = new File("./test_folder/");
        if (args.length == 0) {
            listFile = path.list();
        } else {
            listFile = path.list(new MyNameFilter(args[0]));
        }
        System.out.println(Arrays.toString(listFile));
    }
}

class MyNameFilter implements FilenameFilter {

     private Pattern pattern;

    MyNameFilter(String regex) {
        pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
