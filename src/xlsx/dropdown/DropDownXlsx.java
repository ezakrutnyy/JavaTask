package xlsx.dropdown;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DropDownXlsx {

    public static void main(String[] args) throws IOException {
        /* Create Workbook and Worksheet */
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("Safekeeping");


        XSSFFont font = wb.createFont();
        font.setFontHeightInPoints((short) 10);
        font.setFontName("Arial");
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setBold(true);
        font.setItalic(false);


        XSSFRow title = sheet.createRow(0);

        XSSFColor color0 = new XSSFColor();
        color0.setRGB(new byte[]{(byte) 22, (byte) 54, (byte) 92});

        XSSFCellStyle titleStyle = wb.createCellStyle();
        titleStyle.setFillForegroundColor(color0);
        titleStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        titleStyle.setFont(font);


        XSSFCell questionTitle = title.createCell(0);
        questionTitle.setCellValue("Question");
        questionTitle.setCellStyle(titleStyle);
        sheet.autoSizeColumn(0);

        XSSFCell answerTitle = title.createCell(1);
        answerTitle.setCellValue("Answer");
        answerTitle.setCellStyle(titleStyle);
        sheet.autoSizeColumn(1);


        XSSFColor color1 = new XSSFColor();
        color1.setRGB(new byte[]{ -35, -21, -9});

        XSSFColor color2 = new XSSFColor();
        color2.setRGB(new byte[]{-67, -41, -18});

        XSSFCellStyle evenCellStyle = wb.createCellStyle();
        evenCellStyle.setFillForegroundColor(color1);
        evenCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        evenCellStyle.setBorderBottom(BorderStyle.THIN);
        evenCellStyle.setBorderTop(BorderStyle.THIN);
        evenCellStyle.setBorderLeft(BorderStyle.THIN);
        evenCellStyle.setBorderRight(BorderStyle.THIN);
        evenCellStyle.setBottomBorderColor(IndexedColors.WHITE.index);
        evenCellStyle.setTopBorderColor(IndexedColors.WHITE.index);
        evenCellStyle.setLeftBorderColor(IndexedColors.WHITE.index);
        evenCellStyle.setRightBorderColor(IndexedColors.WHITE.index);
        //evenCellStyle.setFont(font);

        XSSFCellStyle oddCellStyle = wb.createCellStyle();
        oddCellStyle.setFillForegroundColor(color2);
        oddCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        oddCellStyle.setBorderBottom(BorderStyle.THIN);
        oddCellStyle.setBorderTop(BorderStyle.THIN);
        oddCellStyle.setBorderLeft(BorderStyle.THIN);
        oddCellStyle.setBorderRight(BorderStyle.THIN);
        oddCellStyle.setBottomBorderColor(IndexedColors.WHITE.index);
        oddCellStyle.setTopBorderColor(IndexedColors.WHITE.index);
        oddCellStyle.setLeftBorderColor(IndexedColors.WHITE.index);
        oddCellStyle.setRightBorderColor(IndexedColors.WHITE.index);
        //oddCellStyle.setFont(font);

        for (int i = 1; i < 10; i++) {
            CellStyle cellStyle = (i % 2 == 1) ? oddCellStyle : evenCellStyle;

            XSSFRow row = sheet.createRow(i);
            XSSFCell question = row.createCell(0);
            question.setCellValue("Question " + i);
            question.setCellStyle(cellStyle);
            sheet.autoSizeColumn(0);

            XSSFCell answer = row.createCell(1);
            answer.setCellValue("Answer " + i);
            answer.setCellStyle(cellStyle);
            sheet.autoSizeColumn(1);
        }


        /* Write changes to the workbook */
        FileOutputStream out = new FileOutputStream(new File("resources/xlsx/dropdown.xlsx"));
        wb.write(out);
        wb.close();
        out.close();
    }
}


