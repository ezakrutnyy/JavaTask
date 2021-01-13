package xlsx;


import com.google.common.collect.Maps;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.*;

import java.io.*;
import java.util.List;
import java.util.Map;

public class AirlineDocxPoiDemo {


    public static void main(String[] args) throws IOException, InvalidFormatException {

        final Map<String, String> variables = Maps.newHashMap();
        variables.put("organizationName", "John Zak");
        variables.put("operationDate", "10 January");
        variables.put("amount", "12 000.00");
        variables.put("myNewVacancy", "Programmer");
        variables.put("totalAmount", "560 000.00");


        SDPOIDocxView document = new SDPOIDocxView("docx/template-poi.docx");
        document.replace(variables);
        document.writeAndClose("resources/docx/template-poi-output.docx");


//        try (InputStream is = new FileInputStream(new File("resources/docx/template-poi.docx"));
//             OutputStream os = new FileOutputStream(new File("resources/docx/template-poi-output.docx"))) {
//            XWPFDocument document = new XWPFDocument(is);
//            replaceParagraphs(document.getParagraphs());
//            replaceTables(document.getTables());
//            document.write(os);
//        }

    }

    private static void replaceTables(List<XWPFTable> tables) {
        for (XWPFTable table : tables) {
            for (XWPFTableRow row : table.getRows()) {
                for (XWPFTableCell cell : row.getTableCells()) {
                    replaceParagraphs(cell.getParagraphs());
                }
            }
        }
    }

    private static void replaceParagraphs(List<XWPFParagraph> paragraphs) {
        for (XWPFParagraph paragraph : paragraphs) {
            for (XWPFRun run : paragraph.getRuns()) {
                String text = run.getText(0);
                text = text.replace("${organizationName}", "John Zak")
                        .replace("${operationDate}", "January")
                        .replace("${amount}", "12 000.00")
                        .replace("${totalAmount}", "560 000.00");
                run.setText(text, 0);
            }
        }
    }
}
