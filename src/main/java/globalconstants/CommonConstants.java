package globalconstants;

import java.io.File;

public class CommonConstants {
    static final String BASE_PATH = new File("").getAbsolutePath();
    public static final String EXTENT_REPORT_PATH = BASE_PATH +File.separator+ "reports"+File.separator+"htmlReports"+File.separator;
    public static final Long MAX_TIMEOUT = 3000l * 1000;
}
