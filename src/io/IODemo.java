package io;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IODemo {
    public static void main(String[] args) throws IOException {

        /**ЧТЕНИЕ ИЗ ФАЙЛА*/

        Path absolutePath = Paths.get("C:/Users/zakru/IdeaProjects/JavaTask/src/io/input.txt");

        Path relativePathInp = Paths.get("src/io/input.txt");
        Path relativePathOut = Paths.get("src/io/output.txt");
        Path relativePathForStringOut = Paths.get("src/io/toFile.txt");

        System.out.println("*****************Files.newInputStream()*************************************");

        /* чтение байтов из файла в массив */
        try (InputStream inputStream = Files.newInputStream(relativePathInp)) {

            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            System.out.println(Arrays.toString(bytes));
        }

        /* чтение байтов из файла по байтово */
        try (InputStream inputStream = Files.newInputStream(relativePathInp)) {
            try (OutputStream outputStream = Files.newOutputStream(relativePathOut)) {
                while (inputStream.available() > 0) {
                    outputStream.write(inputStream.read());
                }
            }
        }

        /* чтение по символьно из файла */
        System.out.println("*****************Reader***************************");
        try (Reader reader = new InputStreamReader(Files.newInputStream(relativePathInp))) {
            while (reader.ready()) {
                System.out.println(reader.read());
            }
        }

        /* чтение по строчно из файла */
        System.out.println("*****************BufferedReader*************************************");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(relativePathInp)))) {
            while (reader.ready()) {
                System.out.println(reader.readLine());
            }
        }

        /* чтение по строчно из файла с применение Files */
        System.out.println("*****************Files.newBufferedReader(path)*************************************");
        try (BufferedReader br = Files.newBufferedReader(relativePathInp)) {
            while (br.ready()) {
                System.out.println(br.readLine());
            }
        }

        /* получение всех строк с применением Files */
        System.out.println("*****************Files.readAllLines()*************************************");
        List<String> inputs = Files.readAllLines(relativePathInp);
        System.out.println("*****************PrintWriter*************************************");
        try (PrintWriter out = new PrintWriter(Files.newOutputStream(relativePathForStringOut))) {
            for (String s : inputs) {
                out.println(s);
            }
            System.out.println(inputs);
        }

        System.out.println("*****************Stream<String> = Files.lines(path)*************************************");
        try (Stream<String> data = Files.lines(relativePathInp)) {
            List<String> lists = data.collect(Collectors.toList());
            System.out.println(lists);
        }

        /**ЧТЕНИЕ ПО  СЕТИ*/
        /* чтение из потока URI */
        URL url = new URL("https://lenta.ru/");
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {
            System.out.println(in.readLine());
        }

        /**ЧТЕНИЕ ИЗ ПОТОКА ВВОДА*/
        /* прочитаем поток по - байтово */
        try (BufferedInputStream bufIn = new BufferedInputStream(System.in)) {
            System.out.println(bufIn.read());
        }

        /* прочитаем поток по - строчно */
        try (BufferedReader bufIn = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(bufIn.readLine());
        }
    }
}