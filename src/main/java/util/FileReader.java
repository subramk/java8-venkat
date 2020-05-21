package util;

import com.google.common.io.Resources;

import java.io.IOException;

import static com.google.common.io.Resources.getResource;
import static java.nio.charset.Charset.defaultCharset;

public class FileReader {

    public static String fromFile(String filePath) {
        try {
            return Resources.toString(getResource(filePath), defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("cannot read file " + filePath);
        }
    }
}
