package indi.wh.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackMain {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public static void main(String[] args) {
    LogbackMain logback = new LogbackMain();
    logback.testLog();
  }

  private void testLog() {
    logger.debug("print debug log.");
    logger.info("print info log.");
    logger.error("print error log.");
  }
}
