package com.sapo.ex7_RestfullAPI_Spring.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidData extends Exception {
     Logger logger = LoggerFactory.getLogger(InvalidData.class);
     public InvalidData(String message) {
    	 super(message);
    	 logger.info(message);
     }
     
}
