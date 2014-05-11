/**
 * beidou-core#com.baidu.beidou.common.utils.FileUtils.java
 */
package com.taotaoti.common.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

import org.springframework.util.FileCopyUtils;

/**
 * 文件操作的方法集
 */
public class FileUtils extends FileCopyUtils{

	/**
	 * 关闭文件流
	 * @param w
	 */
	public final static void closeWriter(Writer w) {
		if(w != null)
			try{
				w.close();
			}catch(Exception e){
			}
	}
	
	/**
	 * 关闭文件流
	 * @param r
	 */
	public final static void closeReader(Reader r) {
		if(r != null)
			try{
				r.close();
			}catch(Exception e){
			}
	}
	
	/**
	 * 关闭文件流
	 * @param os
	 */
	public final static void closeOutputStream(OutputStream os) {
		if(os != null)
			try{
				os.close();
			}catch(Exception e){
			}
	}
	
	/**
	 * 关闭文件流
	 * @param is
	 */
	public final static void closeInputStream(InputStream is) {
		if(is != null)
			try{
				is.close();
			}catch(Exception e){
			}
	}
	  public final static void SaveFileFromInputStream(InputStream stream,String pathAndFileName) {      
			FileOutputStream fs;
			try {
				fs = new FileOutputStream(pathAndFileName);
				byte[] buffer = new byte[1024 * 1024];
				int byteread = 0;
				while ((byteread = stream.read(buffer)) != -1) {
					fs.write(buffer, 0, byteread);
					fs.flush();
				}
				fs.close();
				stream.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }  
}
