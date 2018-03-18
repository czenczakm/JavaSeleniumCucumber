package utils;

import org.apache.log4j.Logger;

public class Log {
    private static final Logger log = Logger.getLogger(Log.class.getName());

    public static void startTestCase(String scenarioName) {
        Log.info("\n---------------------------BEGIN------------------------------------");
        Log.info("|                                                                     |");
        Log.info("    Starting - " + scenarioName);
        Log.info("|                                                                     |");
        Log.info("--------------------------------------------------------------------");
    }

    public static void endTestCase(String scenarioName, String result) {
        Log.info("-----------------------------------------------------------------------");
        Log.info("    " + scenarioName + " Status - " + result);
        Log.info("|                                                                     |");
        Log.info("------------------------------END-----------------------------------\n");
    }

    public static void info(String message) {
        log.info(message);
    }

    public static void warn(String message) {
        log.warn(message);
    }

    public static void error(String message) {
        log.error(message);
    }

    public static void fatal(String message) {
        log.fatal(message);
    }

    public static void debug(String message) {
        log.debug(message);
    }
}
