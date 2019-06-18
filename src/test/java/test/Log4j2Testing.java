package test;
 
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
 
public class Log4j2Testing {
 
    private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    
	public static void main(String[] args) {
 
		for(int i=0; i<10; i++){
	        logger.trace("===root trace");
	        logger.debug("===root debug");
	        logger.info("===root info");
	        logger.warn("===root warn");
	        logger.error("===root error");
	        logger.fatal("===root fatal");
	        
	        try {
				Thread.sleep(10000);//等10秒钟
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
 
}
