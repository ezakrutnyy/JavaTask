package io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NioWriteReadFileRunner {

    private final Path path = Paths.get("resources\\decoder\\mess.txt");

    public void writeDataChar(String message) {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(message);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String readDataChar() {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            return reader.readLine();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public void writeDataByte(byte[] bytes) {
        try (OutputStream writer = new BufferedOutputStream(Files.newOutputStream(path))) {
            writer.write(bytes);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public byte[] readData() {
        try (BufferedInputStream reader = new BufferedInputStream(Files.newInputStream(path))) {
            byte[] bytes = new byte[reader.available()];
            reader.read(bytes);
            return bytes;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
