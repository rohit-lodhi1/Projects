package com.pract;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.fasterxml.jackson.core.util.BufferRecycler;

import java.io.InputStream;
import java.io.OutputStream;


class SyncPipe implements Runnable
{
public SyncPipe(InputStream istrm, OutputStream ostrm) {
      istrm_ = istrm;
      ostrm_ = ostrm;
  }
  public void run() {
      try
      {
          final byte[] buffer = new byte[1024];
          for (int length = 0; (length = istrm_.read(buffer)) != -1; )
          {
              ostrm_.write(buffer, 0, length);
          }
      }
      catch (Exception e)
      {
          e.printStackTrace();
      }
  }
  private final OutputStream ostrm_;
  private final InputStream istrm_;
}



public class BugFix {
   public static void check(File f) throws IOException {
	  
	   String [] command = {
			   "cmd",
	   };
	   Process p ;
	   try {
		   p = Runtime.getRuntime().exec(command);
		   new Thread(new SyncPipe(p.getErrorStream(),System.err)).start();
		   new Thread(new SyncPipe(p.getInputStream(),System.err)).start();
		   PrintWriter pw = new PrintWriter(p.getOutputStream());
		   pw.println("cd..");
		   pw.println("cd..");
		   pw.println("cd..");
		   pw.println("cd abc");
		   pw.println(" javac "+f.getName());
		   pw.close();
		   p.waitFor();
		   
	   }catch(Exception e) {
		 //  e.printStackTrace();
	   }
	   
   }
   public static void main(String[] args) throws IOException {
	File f = new File("C://abc//sample.java");
	System.out.println(f.getName());
	check(f);
  }
}
