package com.service.user;

import java.util.Random;

public class LicenseKeyGenerator {
	private static final String CHAR_LIST = 
	        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	    private static final int RANDOM_STRING_LENGTH = 16;	     

	    /**
	     * This method generates random string
	     * @return
	     */
	    public String generateRandomString(){
	        StringBuffer randStr = new StringBuffer();
	        int delimCount = 0;
	        for(int i=0; i<RANDOM_STRING_LENGTH; i++){
	            int number = getRandomNumber();
	            char ch = CHAR_LIST.charAt(number);
	            if (delimCount == 3 && i != RANDOM_STRING_LENGTH-1){
	            	delimCount = 0;
		            randStr.append(ch);
	            	randStr.append("-");
	            }else{
	            	delimCount ++;
		            randStr.append(ch);
	            }
	        }
	        return randStr.toString();
	    }
     
	    /**
	     * This method generates random numbers
	     * @return int
	     */
	    private int getRandomNumber() {
	        int randomInt = 0;
	        Random randomGenerator = new Random();
	        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
	        if (randomInt - 1 == -1) {
	            return randomInt;
	        } else {
	            return randomInt - 1;
	        }
	    }
}
