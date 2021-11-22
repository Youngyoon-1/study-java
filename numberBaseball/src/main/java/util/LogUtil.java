package util;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class LogUtil {
    public static final String ERROR_LOG = "log.txt";

    public static final Logger logger = Logger.getLogger("MyLog");
    public static Handler textHandler;

    {
        try {
            textHandler = new FileHandler(ERROR_LOG,true);
            logger.addHandler(textHandler);
        } catch (IOException e) {
            logger.severe("로그 텍스트 파일의 핸들러를 얻을 수 없습니다.");
        }
    }
}
