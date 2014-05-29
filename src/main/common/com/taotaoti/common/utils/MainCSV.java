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
	public double[] readCsv(String fileName) throws IOException{
		File file=new File(fileName);
		System.out.println(file.getAbsolutePath());
		reader = new CSVReader(new FileReader(file));  
	    String [] nextLine;  
	    List<Double> contents=new ArrayList<Double>();
	    while ((nextLine = reader.readNext()) != null) { 
	    	if(nextLine!=null&&nextLine[0]!=null){
	    		double temp=Double.valueOf(nextLine[0]);
	    		contents.add(temp);
	    	}
	    }  
	    reader.close();
	    double[] cs=new double[contents.size()]; 
	    for(int i=0;i<contents.size();i++){
	    	cs[i]=contents.get(i);
	    }
	    return cs;
	}
	public List<String[]> readStringCsv(String fileName) throws IOException{
		File file=new File(fileName);
		reader = new CSVReader(new FileReader(file));  
	    String [] nextLine;  
	    List<String[]> contents=new ArrayList<String[]>();
	    while ((nextLine = reader.readNext()) != null) { 
	    	if(nextLine!=null&&nextLine[0]!=null){
	    		contents.add(nextLine);
	    	}
	    }  
	    reader.close();
	    return contents;
	}
	public static void main(String[] args) throws IOException {
		MainCSV mainCSV=new MainCSV();
		double[] csv=mainCSV.readCsv("/Users/liulxiang/sabrina/FlightNo/108.csv");
		System.out.println(csv.length);
		System.out.println(csv[1]);
		System.out.println(ObjToStringUtil.objToString(csv));
	}


}