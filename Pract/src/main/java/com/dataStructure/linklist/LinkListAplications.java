package com.dataStructure.linklist;

public class LinkListAplications {
	public static Node reverse(Node list1) {
		Node pre=null,curr=list1,nxt;
		
		while(curr!=null) {
			nxt=curr.getNext();
			curr.setNext(pre);
			pre=curr;
			curr=nxt;
		}
		return pre;
	}
	
  public static Node AddLists(Node list1,Node list2) {
	  list1=reverse(list1);
	  list2=reverse(list2);
	  LinkList sum = new LinkList();
	  int carry=0;
	  while(list1!=null && list2!=null) {
		  int a = (Integer)list1.getData();
		  int b = (Integer)list2.getData();
		  int c = a+b+carry;
		  carry=0;
		  if(c>9) {
			  sum.add(c%10);
			carry = c/10;  
		  }
		  else
			  sum.add(c);
		  list1=list1.getNext();
		  list2=list2.getNext();
		 
		  
	  }
	while(list1!=null) {
		sum.add(list1.getData());
		list1=list1.getNext();
	}
	while(list2!=null) {
		sum.add(list2.getData());
		list2=list2.getNext();
	}
	sum.start = reverse(sum.start);
	return sum.start;
  }
   
  public static Node sort(Node list1) {
	  Node temp=list1,list=list1;
	  while(list!=null) {
		  temp=list.getNext();
		  while(temp!=null) {
			if((Integer)temp.getData()<(Integer)list.getData()) {
				int t = (Integer)list.getData();
				list.setData(temp.getData());
				temp.setData(t);
			}
			temp = temp.getNext();
		  }
		  list= list.getNext();
	  }
	  return list1;
  }
  

  
  public static Node sortDesc(Node list1) {
	  Node temp=list1,list=list1;
	  while(list!=null) {
		  temp=list.getNext();
		  while(temp!=null) {
			if((Integer)temp.getData()>(Integer)list.getData()) {
				int t = (Integer)list.getData();
				list.setData(temp.getData());
				temp.setData(t);
			}
			temp = temp.getNext();
		  }
		  list= list.getNext();
	  }
	  return list1;
  }
  
  public static Node DeleteNAfterM(Node temp,int n,int m) {
	  int count=0,d=1;
	  LinkList list = new LinkList();
	  list.start=temp;
	  Node temp2 = temp;
	  while(temp2!=null) {
		  
		  count=0;
		  while(temp2!=null && count++<n && temp2.getNext()!=null) {
			  temp2.setNext(temp2.getNext().getNext());
			  //  temp2.getNext().setNext(null);
		  }
		  count=0;
	      while(count++<m && temp2!=null) {
	    	  temp2=temp2.getNext();
	      }
	  }
	 
	  return list.start;
  }
  
  public static boolean polindrom(Node temp) {
	  String s ="";
	  while(temp!=null) {
		  s+=(String)temp.getData();
		  temp=temp.getNext();
	  }
	  String rev = new StringBuilder(s).reverse().toString();
	  
	  return rev.equals(s);
  }
  

  public static Node loopDetection(Node head) {
		Node slow = head, fast = head;
		while (fast != null && fast.getNext() != null) {

			slow = slow.getNext();
			fast = fast.getNext().getNext();

			if (slow == fast)
				return slow;
			System.out.println(slow.getData() + " -> " + fast.getData());
		}
		return null;
  }
  
  public static boolean remove(Node head) {
		Node slow = loopDetection(head), curr = head;
		if (slow == null)
			return false;
		while (curr.getNext() != slow.getNext()) {
			curr = curr.getNext();
			slow = slow.getNext();
		}
		slow.setNext(null);
		return true;
  }
  
  

  
}




