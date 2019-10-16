package io.jkh;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.BooleanUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

public class JCHDemo {

    private static final Path tariffPath = Paths.get("C:/Users/zakru/Desktop/accounts/tariffs.txt");
    private static final Path pokazPath = Paths.get("C:/Users/zakru/Desktop/accounts/accounts.txt");

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM.yyyy");

    public static void main(String[] args) throws IOException, ParseException {

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
                tariff.setDate(dateFormat.parse(values[0].trim()));
                tariff.setColdWater(new BigDecimal(values[1].trim()));
                tariff.setHotWater(new BigDecimal(values[2].trim()));
                tariff.setDrainageSystem(new BigDecimal(values[3].trim()));
                tariff.setElectricity(new BigDecimal(values[4].trim()));
                tariffs.add(tariff);
            }
        }

        System.out.println(tariffs);
    }
}
