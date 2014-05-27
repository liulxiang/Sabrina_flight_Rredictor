package com.taotaoti.common.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class MainCSV {
	private CSVReader reader;
	/**
	 * 
	 * @param fileName "yourfile.csv"
	 * @return
	 * @throws IOException 
	 */
	public Double[] readCsv(String fileName) throws IOException{
		File file=new File(fileName);
		System.out.println(file.getAbsolutePath());
		reader = new CSVReader(new FileReader(file));  
	    String [] nextLine;  
	    List<Double> contents=new ArrayList<Double>();
	    while ((nextLine = reader.readNext()) != null) { 
	    	if(nextLine!=null&&nextLine[0]!=null){
	    		Double temp=Double.valueOf(nextLine[0]);
	    		contents.add(temp);
	    	}
	    }  
	    reader.close();
	    Double[] cs=new Double[contents.size()]; 
	    for(int i=0;i<contents.size();i++){
	    	cs[i]=contents.get(i);
	    }
	    return cs;
	}
	public static void main(String[] args) throws IOException {
		MainCSV mainCSV=new MainCSV();
		Double[] csv=mainCSV.readCsv("FlightNo/108.csv");
		System.out.println(ObjToStringUtil.objToString(csv));
	}


}