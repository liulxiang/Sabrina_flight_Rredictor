package com.taotaoti.common.utils;

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
	public List<String[]> readCsv(String fileName) throws IOException{
		reader = new CSVReader(new FileReader(fileName));  
	    String [] nextLine;  
	    List<String[]> contents=new ArrayList<String[]>();
	    while ((nextLine = reader.readNext()) != null) {  
	    	contents.add(nextLine);
	    }  
	    reader.close();
	    return contents;
	}


}