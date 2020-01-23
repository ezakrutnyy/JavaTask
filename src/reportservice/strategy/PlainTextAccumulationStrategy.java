package reportservice.strategy;

import reportservice.specification.ReportBlockSpecification;
import reportservice.specification.mappers.Mappers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Formatter;

public class PlainTextAccumulationStrategy<T> implements ReportingDataAccumulation<T> {

    private StringBuilder reportData;

    private Formatter rowFormatter;

    public static final String SEPARATOR = "|";

    private static final String NEW_LINE = "\n";

    public PlainTextAccumulationStrategy() {
        this.reportData = new StringBuilder();
        rowFormatter = new Formatter(reportData);
    }

    @Override
    public void add(ReportBlockSpecification<T> block) {
        Object[] values = Mappers.map(block.getMappers()).toArray();
        rowFormatter.format(withTemplate(values.length), values);
    }

    @Override
    public void add(ReportBlockSpecification<T> block, T entity) {
        Object[] values = Mappers.map(block.getMappers(), entity).toArray();
        rowFormatter.format(withTemplate(values.length),values);
    }

    @Override
    public ReportData get() {
        return new ReportData() {
            @Override
            public byte[] asByteArray() {
                return asOutputStream(Charset.defaultCharset()).toByteArray();
            }

            @Override
            public byte[] asByteArray(Charset charset) {
                return asOutputStream(charset).toByteArray();
            }

            @Override
            public OutputStream asOutputStream() {
                return asOutputStream(Charset.defaultCharset());
            }

            @Override
            public ByteArrayOutputStream asOutputStream(Charset charset) {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream(reportData.length());
                try {
                    outputStream.write(reportData.toString().getBytes());
                    outputStream.flush();
                } catch (IOException ex) {
                    System.out.println("Could not convert RTS data to byte array due to error {}"+ex);
                }
                return outputStream;
            }

            @Override
            public Path asFilePath(String fileName) {
                try {
                    Path tmpPath = Files.createTempFile(fileName, "");
                    OutputStream outputStream = Files.newOutputStream(tmpPath);
                    outputStream.write(reportData.toString().getBytes());
                    outputStream.flush();
                    return tmpPath;
                } catch (IOException ex) {
                    System.out.println("Could not convert RTS data to byte array due to error {}"+ex);
                    return null;
                }
            }
        };

    }

    private String withTemplate(int numberOfColumns) {
        StringBuilder sb = new StringBuilder();
        int ids = 0;
        while (ids < numberOfColumns) {
            sb.append("%s");
            sb.append(SEPARATOR);
            ids++;
        }
        sb.setLength(sb.length()-1);
        sb.append(NEW_LINE);
        return sb.toString();
    }
}