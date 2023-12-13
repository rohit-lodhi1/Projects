package com.playSound;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.*;


public class PlaySound {
     public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    	 
		playSound("C:\\WEB\\AudioData\\Bhajman-Radhe-Radhe-Govinda (1).wav");
	}
     public static void playSound(String file) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    	 File f = new File(file);
    	
			AudioInputStream au =  AudioSystem.getAudioInputStream(f);
			Clip clip = AudioSystem.getClip();
			clip.open(au);
		
    	 String s="";
    	 int choice=0;
    	 Scanner sc = new Scanner(System.in);
    	 while(choice!=4){
    		 System.out.println("1. Play");
    		 System.out.println("2. Stop");
    		 System.out.println("3. Reset");
    		 System.out.println("4. Quite");
    		
    		try{
    			s=sc.next();
    			choice = Integer.parseInt(s);
    		}catch(Exception e) {
    			System.out.println("ENTRE NO ONLY");
    			choice=0;
    			continue;
    		}
    		 switch (choice) {
    		 
			case 1: clip.start();break;
			case 2: clip.stop();break;
			case 3: clip.setMicrosecondPosition(0);clip.start();break;
			case 4: System.out.println("Bhag Bsdk😏");System.exit(1);
			
			default:
              System.out.println("Wrong Input");			   
			}
    		
    	 }
	
    	 
     }
}
