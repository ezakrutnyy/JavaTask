package io;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


public class FilesDemo {

    public static void main(String[] args) throws IOException {
        /* Directory */
        Path files = Paths.get("src/io/files");
        Path tmp = Paths.get("src/io/tmp/");

        /* File */
        Path input = Paths.get("input.txt");
        Path info = Paths.get("info.txt");
        Path server = Paths.get("server.txt");
        Path ch = Paths.get("ch.txt");

        /* Paths */
        Path inputFull = files.resolve(input);
        Path infoFull = tmp.resolve(info);
        Path serverFull = files.resolve(server);
        Path chFull = tmp.resolve(ch);

        /* delete file */
        Files.deleteIfExists(inputFull);
        Files.deleteIfExists(infoFull);
        Files.deleteIfExists(serverFull);
        Files.deleteIfExists(chFull);


        /* creation directory */
        Files.createDirectories(files);
        Files.createDirectories(tmp);

        /* creation files */
        if (!Files.exists(inputFull)) {
            Files.createFile(inputFull);
        }

        /*
         * Files.newInputStream()
         * Files.newOutputStream()
         * Files.newBufferedReader();
         * Files.newBufferedWriter()
         * readAllBytes()
         * readAllLines()
         * */

        try(PrintWriter writer = new PrintWriter(Files.newBufferedWriter(infoFull))) {
            writer.println("bootstrap.server:127.0.0.1");
        }

        /* copy file*/
        if (!Files.exists(serverFull)) {
            Files.copy(infoFull, serverFull);
        }

        /* move */
        Path files_move = Paths.get("src/io/files_move/");
        Files.createDirectories(files_move);
        Files.list(files).forEach(path -> {
            try {
                Files.move(path, files_move.resolve(path.getFileName()), StandardCopyOption.ATOMIC_MOVE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
