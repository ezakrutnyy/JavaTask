package io;

import org.hibernate.boot.model.source.spi.SingularAttributeSourceToOne;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UsingRandomAccessFile {

    static final Path path2  = Paths.get("C:/Users/zakru/IdeaProjects/JavaTask/src/io/file.txt");

    public static void main(String[] args) throws IOException {

        Files.deleteIfExists(path2);

        try(RandomAccessFile raf =
                    new RandomAccessFile(path2.toString(), "rw")) {
            raf.writeInt(3);
            raf.writeInt(7);
            raf.writeInt(10);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        System.out.println("==========================================");

        try(RandomAccessFile raf =
                    new RandomAccessFile(path2.toString(), "rw")) {
            System.out.println(raf.readInt());
            System.out.println(raf.readInt());
            System.out.println(raf.readInt());
        } catch (Exception ex) {
            System.err.println(ex);
        }

        try(RandomAccessFile raf =
                    new RandomAccessFile(path2.toString(), "rw")) {
            raf.seek(4);
            raf.writeInt(6);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        System.out.println("==========================================");

        try(RandomAccessFile raf =
                    new RandomAccessFile(path2.toString(), "rw")) {
            System.out.println(raf.readInt());
            System.out.println(raf.readInt());
            System.out.println(raf.readInt());
        } catch (Exception ex) {
            System.err.println(ex);
        }

    }
}
