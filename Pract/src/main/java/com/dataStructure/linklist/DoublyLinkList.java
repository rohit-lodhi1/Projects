package com.dataStructure.linklist;

public class DoublyLinkList {
   NodeD start,current;
   private boolean unique=true;
   DoublyLinkList(){}
   DoublyLinkList(boolean unique)
   {
	   this.unique=unique;
   }
   
   public NodeD createNode(Object data){
	   NodeD temp=new NodeD(data);
	    return temp;
   }
   
   public boolean checkWill(Object data)
   {
	   if(unique==false &&  nodeOf(data)==-1)
		   return true;	   
	   return false;
   }
   
   public void add(Object data) {
	   
	   NodeD temp;
	   if(checkWill(data)||unique==true)
	   {
			   temp=createNode(data);
		   if(start==null)
		       start=temp;
	        else
	        {
		        current.setNext(temp);
		        temp.setPrev(current);
	         }
		   current=temp;		   
	    }
   }
   
   public void addAtFirst(Object data)
   {
	   NodeD temp=createNode(data);
	   if(checkWill(data)||unique==true)
	   {
	   temp.setNext(start);
	   start.setPrev(temp);
	   start=temp;
	   }
	
   }
   
   public void addAtNth(Object data,int pos)
   {
	   NodeD temp=createNode(data);
	   NodeD temp1=traverse(pos);
	   if(pos<2)
	   {
		   addAtFirst(data);		   
	   }
	   else if(pos>nodeCount())
		   add(data);
	   else if(checkWill(data)|| unique==true){
	   temp.setNext(temp1);
	   temp.setPrev(temp1.getPrev());
	   temp1.getPrev().setNext(temp);
	   temp1.setPrev(temp);
	   }
   }
   
   public void deleteAtLast()
   {
	   NodeD temp=traverse(nodeCount());
	   temp.getPrev().setNext(null);	   
   }
   
   public void deleteAtFirst()
   {
	   NodeD temp=start;
	   start=temp.getNext();
	   temp.setNext(null);
   }
   
   public void deleteAtNth(int pos)
   {
	   NodeD temp=traverse(pos);
	   if(pos>nodeCount())
		  deleteAtLast();
	   else if(pos<2)
		   deleteAtFirst();
	   else {
	   temp.getPrev().setNext(temp.getNext());
	   temp.getNext().setPrev(temp.getPrev());
	   }
   }
   
   public void reverse()
   {
	   NodeD pre=null,curr=start,nxt=null;
	   while(curr!=null)
	   {
		   nxt=curr.getNext();
		   curr.setNext(pre);
		   curr.setPrev(nxt);
		   pre=curr;
		   curr=nxt;
	   }
	   current=start;
	   start=pre;	   
   }
   
   public NodeD reverseByRecur(NodeD temp)
   {
	   NodeD revHead,temp1=temp.getNext();
	   if(temp.getNext()==null)
	   {
		current=start;
		   return temp;
	   }
	   else
		   revHead=reverseByRecur(temp.getNext());
	      temp.setNext(temp.getPrev());
	      temp.setPrev(temp1);
	      temp.getPrev().setNext(temp);
	      return revHead;
	   
   }
   
   

   public NodeD reverse(NodeD temp,int grp)
   {
 	   NodeD pre=null,curr=temp,nxt=null;
 	   int c=1;
 	   while(curr!=null && c++<=grp)
 	   {
 	     nxt=curr.getNext();
 	     curr.setNext(pre);
 	     curr.setPrev(nxt);
 	     pre=curr;
 	     curr=nxt;
 	   }
 	   if(curr!=null)
 		   temp.setNext(reverse(curr,grp));
 	   return pre;
   }
   
   
   
   public Object valueOf(int node)
   {
	   Object value=-1;
	   if(node>nodeCount() || node<nodeCount()-nodeCount())
	   {
		   return value;
	   }
	   NodeD temp=traverse(node);
	   value=temp.getData();
	   return value;
   }
   
   public int nodeOf(Object value)
   {
	   NodeD temp=start;
	   int i=1;
	   while(temp!=null)
	   {
		   if(temp.getData()==value)
			   return i;
		   temp=temp.getNext();
		   i++;
	   }
	//   System.out.println("NOT FOUND");
	  return -1;
   }
   
   public NodeD traverse(int pos)
   {
	   int count=1;
	   NodeD temp=start;
	   while(count++<pos && temp!=null)
	   {
		   temp=temp.getNext();
	   }
	   return temp;
   }
   
   public int nodeCount()
   {
	   int count=0;
	   NodeD temp=start;
	   while(temp!=null)
	   {
		   temp=temp.getNext();
		   count++;
	   }
	   return count;
   }
   
   public String toString()
   {
	   NodeD temp=start;
	   String s="";
	   while(temp!=null)
	   {
		   s=s+", "+temp.getData();
		   temp=temp.getNext();
	   }
	   return "["+s.substring(2)+"]";
   }
}
