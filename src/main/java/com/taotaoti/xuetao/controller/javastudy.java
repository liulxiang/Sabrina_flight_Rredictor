package com.taotaoti.xuetao.controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;

import au.com.bytecode.opencsv.CSVReader;

import rcaller.RCaller;
import rcaller.RCode;
public class javastudy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {

		      /*
		       * Creating Java's random number generator
		       */
		      Random random = new Random();

		      /*
		       * Creating RCaller
		       */
		      RCaller caller = new RCaller();
		      RCode code = new RCode();
		      /*
		       * Full path of the Rscript. Rscript is an executable file shipped with R.
		       * It is something like C:\\Program File\\R\\bin.... in Windows
		       */
		      caller.setRscriptExecutable("/usr/bin/Rscript");

		      /*
		       *  We are creating a random data from a normal distribution
		       * with zero mean and unit variance with size of 100
		       */
		      double[] data = new double[100];
		      
		      for (int i = 0; i < data.length; i++) {
		        data[i] = random.nextGaussian();
		      }

		      /*
		       * We are transferring the double array to R
		       */
		      code.addDoubleArray("x", data);

		      /*
		       * Adding R Code
		       */
		      code.addRCode("n<-1:length(x)");
		      code.addRCode("sp<-smooth.spline(n,x)");
		      code.addRCode("  size1<-length(x)+1");
		   
		    

		      code.addRCode(" size2<-size1+2");
		      code.addRCode(" xx<-c(size1:size2)");
		      code.addRCode(" prediction<-predict(sp,xx)");
		      

		   
		      
		      File file = code.startPlot();
		      System.out.println("Plot will be saved to : " + file);
		      code.addRCode(" plot(x,type=\"l\",xlim=c(1,size2),xlab=\"Day\",ylab=\"Estimation delay/minutes\")");
		      
		      code.addRCode(" lines(sp,col=\"red\",lwd=2)");
		      code.addRCode(" lines(prediction,col=\"blue\",lwd=2)");
		      code.addRCode(" write.table(prediction$y, file = \"/Users/sabrina/Downloads/eclipse/predictionairline.csv\", sep = \",\", col.names = NA,\n" + 
		      		"            qmethod = \"double\")");
		  
		      code.endPlot();

		      caller.setRCode(code);
		      caller.runOnly();
		      code.showPlot(file);

		      /*
		       * We want to handle the list 'my.all'
		       */
		     
		      //caller.runAndReturnResult("my.all");
		
		    }  catch (Exception e) {
		        System.out.println(e.toString());
		    }
			    
	}
}
	