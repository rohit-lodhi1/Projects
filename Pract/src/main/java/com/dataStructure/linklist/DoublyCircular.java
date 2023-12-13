package com.dataStructure.linklist;

public class DoublyCircular {
   
	public NodeD tail =null;
	public NodeD temp =null;
	
	public boolean add(Object data) {
	   NodeD node = new NodeD(data);
	   node.setNext(node);
	    if(tail==null)
	    	tail=node;
	    else
	    {
	    	   node.setNext(tail.getNext());
	    	   tail.setNext(node);
               tail.getNext().setPrev(node);
	    	   node.setPrev(tail);
	    	   
	    	   tail=node;
	    }
		
		return true;
	}
	
	
	public void print(DoublyCircular d) {
		NodeD temp = d.tail.getNext();
		while(temp!=tail) {
			System.out.print(temp.getData()+" -> ");
			temp=temp.getNext();
		}
		System.out.println(temp.getData());
	}
	
	
	public static void main(String[] args) {
	  DoublyCircular d = new DoublyCircular();
	    d.add(10);
	    d.add(20);
	   // System.out.println(d.tail.getNext().getPrev().getData());
	    
	    d.print(d);
		System.out.println(d.tail.getData());
		
	}
	
}
