package io;

import java.io.*;

public class DataInputAndOutputStream {

    private static final String path = "src/io/output.txt";

    public static void main(String[] args) {
        try (DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(path)))) {
            out.writeBoolean(false);
            out.writeByte(100);
            out.writeChar('c');
            out.writeDouble(22.11);
            out.writeFloat(10.11F);
            out.writeInt(500);
            out.writeLong(1000L);
            out.writeShort(1200);
            out.writeUTF("yellow");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        try (DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(path)))) {
            System.out.println(in.readBoolean());
            System.out.println(in.readByte());
            System.out.println(in.readChar());
            System.out.println(in.readDouble());
            System.out.println(in.readFloat());
            System.out.println(in.readInt());
            System.out.println(in.readLong());
            System.out.println(in.readShort());
            System.out.println(in.readUTF());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }


    }
}