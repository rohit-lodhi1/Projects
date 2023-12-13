package com.dataStructure.linklist;

public class SinglyCircular {

	Node tail;
	public Node createNode(Object data) {
		Node temp=new Node(data);
		temp.setNext(temp);
		return temp;
	}
	public void add(Object data) {
		Node temp=createNode(data);
		if(tail==null)
		{
			temp.setNext(temp);
			tail=temp;
		}
		else {
			temp.setNext(tail.getNext());
			tail.setNext(temp);
			tail=temp;
		}
	}
	public void addAtFirst(Object data) {
		Node temp=createNode(data);
		if(tail==null)
		{
			add(data);
			return ;
		}
		temp.setNext(tail.getNext());
		tail.setNext(temp);
		
	}
	public void add(Object data, int pos) {
		Node temp=createNode(data);
		if(pos<2 || tail==null)
		{
			addAtFirst(data);
			return ;
		}
		if(pos>nodeCount())
		{
			add(data);
			return ;
		}
		Node temp1=traverse(pos);
	   temp.setNext(temp1.getNext());
	   temp1.setNext(temp);		
	}
	
	public void deleteAtFirst()
	{
		Node temp=tail.getNext();
		tail.setNext(temp.getNext());
		temp.setNext(null);
	}
	
	public void delete()
	{
		Node temp1=traverse(nodeCount());
		temp1.setNext(tail.getNext());
		tail=temp1;
	}
	public void delete(int pos)
	{
		Node temp=traverse(pos);
		Node temp1=temp.getNext();
		temp.setNext(temp1.getNext());
		temp1.setNext(null);
	}
	
	public int nodeCount()
	{
		Node temp=tail.getNext();
		int count=1;
		while(temp!=tail)
		{
			count++;
			temp=temp.getNext();
		}
		return count;
	}
	
	public Node traverse(int pos)
	{
		Node temp=tail.getNext();
		int posCount=2;
		while(temp!=tail && posCount++<pos)
		{
			temp=temp.getNext();
		}
		return temp;
	}
	
	public String toString() {
		String s="";
		Node temp=tail.getNext();
		while(temp!=tail)
		{
			try{
				s+=", "+temp.getData();
				temp=temp.getNext();
			}
			catch(NullPointerException a) {}
			
		}
		s+=", "+temp.getData();
	
		return "["+s.substring(2)+"]";
		
	}
	
	
}
