package reportservice.strategy;

import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Path;

public interface ReportData {

    byte[] asByteArray();

    byte[] asByteArray(Charset charset);

    OutputStream asOutputStream();

    OutputStream asOutputStream(Charset charset);

    Path asFilePath(String fileName);
}