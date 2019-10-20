package io.jkh;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import parsers.Decimals;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JCHDemo {

    private static final Path tariffPath = Paths.get("C:/Users/zakru/Desktop/accounts/tariffs.txt");
    private static final Path accountPath = Paths.get("C:/Users/zakru/Desktop/accounts/accounts.txt");
    private static final Path file = Paths.get("C:/Users/zakru/Desktop/accounts/pokazanye.xlsx");

    public static void main(String[] args) throws IOException {

        List<String> dates = Lists.newArrayList();

        // Соберем список тарифов
        List<Tariff> tariffs = Lists.newArrayList();
        boolean isTitle = true;
        try(BufferedReader reader = Files.newBufferedReader(tariffPath)) {
            while (reader.ready()) {
                String line = reader.readLine();
                if (BooleanUtils.isTrue(isTitle)) {
                    isTitle = false;
                    continue;
                }
                Tariff tariff = new Tariff();
                String[] values = line.split("\\|");
                tariff.setMonthYear(values[0].trim());
                dates.add(values[0].trim());
                tariff.setColdWater(new BigDecimal(values[1].trim()));
                tariff.setHotWater(new BigDecimal(values[2].trim()));
                tariff.setDrainageSystem(new BigDecimal(values[3].trim()));
                tariff.setElectricity(new BigDecimal(values[4].trim()));
                tariffs.add(tariff);
            }
        }

        isTitle = true;
        // Соберем показания
        List<Account> accounts = Lists.newArrayList();
        try(BufferedReader reader = Files.newBufferedReader(accountPath)) {
            while (reader.ready()) {
                String line = reader.readLine();
                if (BooleanUtils.isTrue(isTitle)) {
                    isTitle = false;
                    continue;
                }
                Account account = new Account();
                String[] values = line.split("\\|");
                account.setMonthYear(values[0].trim());
                account.setColdWater(Integer.parseInt(values[1].trim()));
                account.setHotWater(Integer.parseInt(values[2].trim()));
                account.setDrainageSystem(account.getColdWater()+account.getHotWater());
                account.setElectricity(Integer.parseInt(values[3].trim()));
                accounts.add(account);
            }
        }

        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet("2019");

        Font font = book.createFont();
        font.setBold(true);
        font.setColor(IndexedColors.WHITE.index);
        font.setFontName("Arial");
        font.setItalic(false);
        font.setFontHeightInPoints((short)10);

        Row row = sheet.createRow(0);
        CellStyle titleStyle = book.createCellStyle();
        titleStyle.setFont(font);
        titleStyle.setFillForegroundColor(IndexedColors.GREEN.index);
        titleStyle.setAlignment(HorizontalAlignment.CENTER);
        titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        titleStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        titleStyle.setBorderBottom(BorderStyle.DASHED);
        titleStyle.setBorderTop(BorderStyle.DASHED);
        titleStyle.setBorderRight(BorderStyle.DASHED);
        titleStyle.setBorderLeft(BorderStyle.DASHED);
        titleStyle.setLeftBorderColor(IndexedColors.WHITE.index);
        titleStyle.setTopBorderColor(IndexedColors.WHITE.index);
        titleStyle.setRightBorderColor(IndexedColors.WHITE.index);
        titleStyle.setBottomBorderColor(IndexedColors.WHITE.index);

        Cell cell = row.createCell(0);
        cell.setCellValue("Месяц");
        cell.setCellStyle(titleStyle);

        CellRangeAddress mergedRegion = new CellRangeAddress(0,1,0,0);
        sheet.addMergedRegion(mergedRegion);

        cell = row.createCell(1);
        cell.setCellValue("Тарифы");
        cell.setCellStyle(titleStyle);

        mergedRegion = new CellRangeAddress(0,0,1,4);
        sheet.addMergedRegion(mergedRegion);

        cell = row.createCell(5);
        cell.setCellValue("Показания счетчиков");
        cell.setCellStyle(titleStyle);
        mergedRegion = new CellRangeAddress(0,0,5,7);
        sheet.addMergedRegion(mergedRegion);

        cell = row.createCell(8);
        cell.setCellValue("Потребление");
        cell.setCellStyle(titleStyle);
        mergedRegion = new CellRangeAddress(0,0,8,10);
        sheet.addMergedRegion(mergedRegion);

        cell = row.createCell(11);
        cell.setCellValue("Сумма за воду");
        cell.setCellStyle(titleStyle);
        mergedRegion = new CellRangeAddress(0,0,11,14);
        sheet.addMergedRegion(mergedRegion);

        cell = row.createCell(15);
        cell.setCellValue("Сумма за эл-во");
        cell.setCellStyle(titleStyle);

        cell = row.createCell(16);
        cell.setCellValue("Всего");
        cell.setCellStyle(titleStyle);
        mergedRegion = new CellRangeAddress(0,1,16,16);
        sheet.addMergedRegion(mergedRegion);

        // 2 строка
        row = sheet.createRow(1);

        cell = row.createCell(1);
        cell.setCellValue("Хол. вод");
        cell.setCellStyle(titleStyle);

        cell = row.createCell(2);
        cell.setCellValue("Гор. вод");
        cell.setCellStyle(titleStyle);

        cell = row.createCell(3);
        cell.setCellValue("Водо-отв");
        cell.setCellStyle(titleStyle);

        cell = row.createCell(4);
        cell.setCellValue("Эл -во");
        cell.setCellStyle(titleStyle);

        cell = row.createCell(5);
        cell.setCellValue("Хол. вод");
        cell.setCellStyle(titleStyle);

        cell = row.createCell(6);
        cell.setCellValue("Гор. вод");
        cell.setCellStyle(titleStyle);

        cell = row.createCell(7);
        cell.setCellValue("Эл -во");
        cell.setCellStyle(titleStyle);

        cell = row.createCell(8);
        cell.setCellValue("Хол. вод");
        cell.setCellStyle(titleStyle);

        cell = row.createCell(9);
        cell.setCellValue("Гор. вод");
        cell.setCellStyle(titleStyle);

        cell = row.createCell(10);
        cell.setCellValue("Эл -во");
        cell.setCellStyle(titleStyle);

        cell = row.createCell(11);
        cell.setCellValue("Хол. вод");
        cell.setCellStyle(titleStyle);

        cell = row.createCell(12);
        cell.setCellValue("Гор. вод");
        cell.setCellStyle(titleStyle);

        cell = row.createCell(13);
        cell.setCellValue("Водо-отв");
        cell.setCellStyle(titleStyle);

        cell = row.createCell(14);
        cell.setCellValue("Вода всего");
        cell.setCellStyle(titleStyle);

        cell = row.createCell(15);
        cell.setCellValue("Эл -во");
        cell.setCellStyle(titleStyle);

        //Auto size all the columns
        for (int x = 0; x < sheet.getRow(1).getLastCellNum(); x++) {
            sheet.autoSizeColumn(x);
        }

        // all rows
        CellStyle bodyStyle = book.createCellStyle();
        bodyStyle.setAlignment(HorizontalAlignment.CENTER);
        bodyStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        // сгруппируем по дате тарифа и показания , ключ - месяц
        Map<String, List<Tariff>> tariffByDate = tariffs.stream()
                .collect(Collectors.groupingBy(Tariff::getMonthYear));

        Map<String, List<Account>> accountByDate = accounts.stream()
                .collect(Collectors.groupingBy(Account::getMonthYear));

        int rowNum = 2;


        Integer prevColdWater = 0;
        Integer prevHotWater = 0;
        Integer prevElect = 0;

        for (String date : dates) {

            row = sheet.createRow(rowNum++);

            cell = row.createCell(0);
            cell.setCellValue(date);
            cell.setCellStyle(bodyStyle);


            List<Tariff> tariffRows = tariffByDate.get(date);
            List<Account> accountRows = accountByDate.get(date);

            if (CollectionUtils.isEmpty(tariffRows) || CollectionUtils.isEmpty(accountRows))
                continue;

            Integer currentColdWater = accountRows.get(0).getColdWater();
            Integer currentHotWater = accountRows.get(0).getHotWater();
            Integer currentElect = accountRows.get(0).getElectricity();

            BigDecimal tariffColdWater = tariffRows.get(0).getColdWater();
            BigDecimal tariffHotWater  = tariffRows.get(0).getHotWater();
            BigDecimal tariffDrainageSystem = tariffRows.get(0).getDrainageSystem();
            BigDecimal tariffElect = tariffRows.get(0).getElectricity();


            cell = row.createCell(1);
            cell.setCellValue(String.valueOf(tariffColdWater));
            cell.setCellStyle(bodyStyle);

            cell = row.createCell(2);
            cell.setCellValue(String.valueOf(tariffHotWater));
            cell.setCellStyle(bodyStyle);

            cell = row.createCell(3);
            cell.setCellValue(String.valueOf(tariffDrainageSystem));
            cell.setCellStyle(bodyStyle);

            cell = row.createCell(4);
            cell.setCellValue(String.valueOf(tariffElect));
            cell.setCellStyle(bodyStyle);


            cell = row.createCell(5);
            cell.setCellValue(String.valueOf(currentColdWater));
            cell.setCellStyle(bodyStyle);

            cell = row.createCell(6);
            cell.setCellValue(String.valueOf(currentHotWater));
            cell.setCellStyle(bodyStyle);

            cell = row.createCell(7);
            cell.setCellValue(String.valueOf(currentElect));
            cell.setCellStyle(bodyStyle);


            Integer diffColdWater = currentColdWater-prevColdWater;
            Integer diffHotWater = currentHotWater-prevHotWater;
            Integer diffElect = currentElect-prevElect;

            cell = row.createCell(8);
            cell.setCellValue(String.valueOf(diffColdWater));
            cell.setCellStyle(bodyStyle);

            cell = row.createCell(9);
            cell.setCellValue(String.valueOf(diffHotWater));
            cell.setCellStyle(bodyStyle);

            cell = row.createCell(10);
            cell.setCellValue(String.valueOf(diffElect));
            cell.setCellStyle(bodyStyle);

            // 1 - 8

            BigDecimal coldWaterAmount = tariffColdWater.multiply(BigDecimal.valueOf(diffColdWater));
            cell = row.createCell(11);
            cell.setCellValue(Decimals.convertDecimalToStr(coldWaterAmount));
            cell.setCellStyle(bodyStyle);

            BigDecimal hotWaterAmount = tariffHotWater.multiply(BigDecimal.valueOf(diffHotWater));
            cell = row.createCell(12);
            cell.setCellValue(Decimals.convertDecimalToStr(hotWaterAmount));
            cell.setCellStyle(bodyStyle);

            BigDecimal drainageSystemAmount = tariffDrainageSystem.multiply(BigDecimal.valueOf(diffColdWater+diffHotWater));
            cell = row.createCell(13);
            cell.setCellValue(Decimals.convertDecimalToStr(drainageSystemAmount));
            cell.setCellStyle(bodyStyle);

            BigDecimal allWater = coldWaterAmount.add(hotWaterAmount).add(drainageSystemAmount);
            cell = row.createCell(14);
            cell.setCellValue(Decimals.convertDecimalToStr(allWater));
            cell.setCellStyle(bodyStyle);

            BigDecimal allElect = tariffElect.multiply(BigDecimal.valueOf(diffElect));
            cell = row.createCell(15);
            cell.setCellValue(Decimals.convertDecimalToStr(allElect));
            cell.setCellStyle(bodyStyle);

            BigDecimal allAmount = allWater.add(allElect);
            cell = row.createCell(16);
            cell.setCellValue(Decimals.convertDecimalToStr(allAmount));
            cell.setCellStyle(bodyStyle);


            prevColdWater = currentColdWater;
            prevHotWater = currentHotWater;
            prevElect = currentElect;

        }

        try(OutputStream out = Files.newOutputStream(file)) {
            book.write(out);
        }

    }
}
