package com.dataStructure.queue;

public class Queue{
	 final static int MAX=4;
	int queue[] = new int[MAX];
	int front=-1,rear=-1;
	
	
	public boolean isEmpty() {
		return front==-1;
	}
	
	public boolean isFull() {
		return rear==MAX-1 ;
	}
	
	public int enqueue(int data) {
		if(!isFull()) {
			
			if(front==-1)
			  front=0;
               if(rear==MAX-1)
            	   rear=0;
			return queue[++rear]=data;
            
		}
		else
			System.out.println("STACK IS FULL");
		System.exit(10);
		return 0;	
	}
	
	public int dequeue() {
		if(!isEmpty()) {
			return queue[front++];
		}
		else
			System.out.println("STACK IS EMPTY");
		System.exit(10);
		return 0;
	}
	
	
	
	public void view() {
		if(front==0)
			while(front<=rear)
				System.out.println(front +" -> "+queue[front++]);
		else
		{
			while(front<MAX)
				System.out.println(front +" -> "+queue[front++]);
			front=0;
			while(front<=rear)
				System.out.println(front +" -> "+queue[front++]);
		}
	}
	
	
	
	public static void main(String[] args) {
	   Queue q = new Queue();
	   System.out.println(q.enqueue(1));
	   System.out.println(q.enqueue(2));
	   System.out.println(q.enqueue(3));
	   System.out.println(q.enqueue(4));
	   System.out.println(q.dequeue());
	   System.out.println(q.dequeue());
	   System.out.println(q.dequeue());
	   System.out.println(q.enqueue(1));
	   System.out.println(q.enqueue(2));
	   System.out.println(q.enqueue(3));
	   System.out.println(q.enqueue(3));
	   System.out.println(q.enqueue(3));
	   
	}
	
	
	
}