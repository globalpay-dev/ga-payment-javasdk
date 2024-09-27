package com.lianpay.globalpay.utils;

import com.lianpay.globalpay.reader.MerchantPropertyReader;
import org.apache.log4j.Logger;

public class LoggerUtil {

    public static void error(Logger LOGGER, Boolean openLog, String message, Throwable t) {
        if (openLog) {
            LOGGER.error(message, t);
        }
    }

    public static void error(Logger LOGGER, Boolean openLog, String message) {
        if (openLog) {
            LOGGER.error(message);
        }
    }

    public static void info(Logger LOGGER, Boolean openLog, String message) {
        if (openLog) {
            LOGGER.info(message);
        }
    }

    public static void error(Logger LOGGER, MerchantPropertyReader merchantPropertyReader, String message) {
        error(LOGGER, merchantPropertyReader.openDebuggerLog(), message);
    }

    public static void info(Logger LOGGER, MerchantPropertyReader merchantPropertyReader, String message) {
        info(LOGGER, merchantPropertyReader.openDebuggerLog(), message);
    }
}
