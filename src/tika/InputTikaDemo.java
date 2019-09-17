package tika;


import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InputTikaDemo {


    public static void main(String[] args) throws IOException, TikaException {

        Tika tika = new Tika();
        /*
         * Detect type file
         * */
        File file = new File("src/tika/1.xlsx");
        String fileType = tika.detect(file);
        System.out.println("FileType: "+fileType);

        /*
         * Проверка содержимого файлов
         * */
        String[] expectedFileContent = tika.parseToString(Files.newInputStream(Paths.get("src/tika/1.xlsx"))).split("\n");
        String[] actualFileContent = tika.parseToString(Files.newInputStream(Paths.get("src/tika/2.xlsx"))).split("\n");
        TikaParser.assertData(expectedFileContent, actualFileContent, false);
    }


}
