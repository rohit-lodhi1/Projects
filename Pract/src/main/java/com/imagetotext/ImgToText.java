package com.imagetotext;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.helpers.FileWatchdog;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ImgToText {
	
	private final static String IMG_file="C:\\WEB\\ImgData\\test1.png";
	private final static String OUT_FIle="C:\\WEB\\ImgData\\imgtext.txt";
	
	
public static void main(String[] args) throws TesseractException, IOException {
	Tesseract ts = new Tesseract();
	
	File f = new File(OUT_FIle);
	
	FileWriter fw = new FileWriter(f,true);
	
  String s=  ts.doOCR(new File(IMG_file));
  
  System.out.println("\n"+s+"\n");
  
}
public static void makeFile() {
	 Tesseract ts = new Tesseract();
	 File f = new File("C:\\WEB\\ImgData\\operator.txt");
	 try {
		 FileWriter fw = new FileWriter(f,true);
		 
		 for(int i=0;i<2;i++) {	 
	String s=  ts.doOCR(new File("C:\\WEB\\operator\\"+Integer.toString(i+1)+".png"));	  
	System.out.println(s+"\n");
	fw.write(s);
		 }
		 fw.close();
	
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
}
}
