package com.dollop.controller;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.*;

public class Test {
	
	static Clip clip ;
	
	     public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
	    	 

			playSound("C:\\WEB\\AudioData\\Bhajman-Radhe-Radhe-Govinda (1).wav");
		}
	     public static void playSound(String file) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
	    	 File f = new File(file);
	    	
				AudioInputStream au =  AudioSystem.getAudioInputStream(f);
				 clip = AudioSystem.getClip();
				clip.open(au);
			 
	     }
	     public static void play() {
	    	 clip.start();
	     }
	     public static void stop() {
	    	 clip.stop();
	     }
	     public static void reset() {
	      clip.setMicrosecondPosition(0);
	     }
	     
	     
	}


