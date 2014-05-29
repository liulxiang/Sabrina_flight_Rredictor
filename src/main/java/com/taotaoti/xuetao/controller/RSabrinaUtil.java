package com.taotaoti.xuetao.controller;
import java.io.File;
import java.io.IOException;
import java.util.List;

import com.taotaoti.common.utils.MainCSV;

import rcaller.RCaller;
import rcaller.RCode;
public class RSabrinaUtil {
	
	public static final String path="/Users/liulxiang/sabrina/";
	
	public static boolean dealDataByFilghtNo(String fightNo){
		MainCSV mainCSV=new MainCSV();
		double[] csv = null;
		try {
			csv = mainCSV.readCsv(path+"FlightNo/"+fightNo+".csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dealDataByR(csv);
	}
	
	public static boolean dealDataByR(double[] data){
		boolean flag=false;
	      RCaller caller = new RCaller();
	      RCode code = new RCode();
	      caller.setRscriptExecutable("/usr/bin/Rscript");
	      code.addDoubleArray("x", data);
	      code.addRCode("n<-1:length(x)");
	      code.addRCode("sp<-smooth.spline(n,x)");
	      code.addRCode("  size1<-length(x)+1");
	      code.addRCode(" size2<-size1+2");
	      code.addRCode(" xx<-c(size1:size2)");
	      code.addRCode(" prediction<-predict(sp,xx)");
	      File file;
		try {
			   file = code.startPlot();
			   System.out.println("Plot will be saved to : " + file);
		      code.addRCode(" plot(x,type=\"l\",xlim=c(1,size2),xlab=\"Day\",ylab=\"Estimation delay/minutes\")");
		      code.addRCode(" lines(sp,col=\"red\",lwd=2)");
		      code.addRCode(" lines(prediction,col=\"blue\",lwd=2)");
		      code.addRCode(" write.table(prediction$y, file = \""+path+"predictionairline.csv\", sep = \",\", col.names = NA,\n" + 
		      		"            qmethod = \"double\")");
		      code.endPlot();
		      caller.setRCode(code);
		      caller.runOnly();
		      code.showPlot(file);
		      flag=true;
		} catch (IOException e) {
           
			e.printStackTrace();
		}
	     return flag;
	}
	public static float getRResult(){
		String todayData=null;
		MainCSV mainCSV=new MainCSV();
		try {
			List<String[]> dates=mainCSV.readStringCsv(path+"predictionairline.csv");
			if(dates!=null){
				String[] tempData=dates.get(1);
				todayData=tempData[1];
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return Float.valueOf(todayData);
	}
	public static void main(String[] args) {
		System.out.println(RSabrinaUtil.getRResult());
	}
	
}
	