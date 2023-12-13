package com.pract;


class MyThread extends Thread{
//	public void run() {
//		for(int i=1;i<11;i++)
//			System.out.println("thread 1 "+i*2);
//	}
}

class MyTh implements Runnable{


	
	@Override
	public  void run() {
		for(int i=1;i<11;i++)
		System.out.println(Thread.currentThread().getName()+i*3);
	}
	
	
}

class A implements Runnable{

	@Override
	public  void run() {
		// TODO Auto-generated method stub
		
		A a  = new A();
		Thread t = new Thread(a);
		t.start();
		System.out.println(t.isDaemon());
		for(int i=1;i<11;i++) {
			  try {
				  if(Thread.currentThread().getName().equals("Thread-0"))
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"  "+i*3);
		}
	}
	
}

public class Threading {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InterruptedException {
		MyTh m=new MyTh();
		A a = new A();
		Thread t = new Thread(a);
		t.setDaemon(true);
		t.start();
		Thread.currentThread().sleep(4000);
		System.out.println("hello");
		 
//		Thread t1 = new Thread(a);
//		t1.start();
//		
		
//		t.setName("Rohit");

	}
}
