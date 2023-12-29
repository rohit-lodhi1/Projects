package com.dataStructure.linklist;

import java.util.Scanner;

//
//public class Test {
//
//	public static void main(String[] args) {
//	//  SinglyCircular l1=new SinglyCircular();
//	  
////	  l1.add(10);
////	  l1.add(20);
////	  l1.add(30);
////	  l1.add(40);
//	  
//	//  l1.addAtFirst(5);
//	  //l1.add(99,7);
//	  //l1.deleteAtFirst();
//	//  l1.delete(2);
//	  
//	/*  l1.addA(20);
//	  l1.add(40); 
//	  l1.add(40); 
//	  l1.add(50);   */
////	  l1.addAtFirst(5);
////	  l1.addAtFirst(5);
//
//	//  l1.addAtNth(99,10);
//	//  l1.addAtNth(99, 2);
//	//  l1.deleteAtLast();
//	//  l1.deleteAtFirst();
//	//  l1.deleteAtNth(2);
//	//  System.out.println(l1.current.getData());
//		
//		
//		LinkList l1 = new LinkList();
//		LinkList l2 = new LinkList();
//		l1.add("A");
//		l1.add("B");
//		l1.add("A");
//		l1.add("A");
//		System.out.println(l1);
//		System.out.println(LinkListAplications.polindrom(l1.start));
//		l2.add(1);
//		l2.add(2);
//		l2.add(3);	
//		l2.add(4);
//		l2.add(5);	
//		l2.add(6);
//		l2.add(7);	
//		l2.add(8);
//		l2.add(9);	
//		l2.add(10);
//	//	System.out.println(l2);
//	//	l2.delete(l2.start, 2);
//	//	System.out.println(l1);
//		System.out.println(l2);
//         
////	l1.start=	LinkListAplications.reverse(l1.start);
////	l1.start=	LinkListAplications.AddLists(l1.start, l2.start);
//	//	l2.start = LinkListAplications.sortDesc(l2.start);
//		l2.start = LinkListAplications.DeleteNAfterM(l2.start, 2, 2);
//	  System.out.println(l2);
//	}
//}

public class Test {
	public static int beautiful(int i, int j, int k) {
		int count = 0, s = 0, store;
		for (int l = i; l <= j; l++) {
			store = l;
			s = 0;
			while (store != 0) {

				int r = store % 10;
				store = store / 10;
				s = s * 10 + r;
			}
			if ((l - s) % k == 0)
				count++;
			// System.out.println(s);
		}
		return count;
	}

	public static void main(String[] args) {
//	  LinkList l = new LinkList();
//	  l.add(10);
//	  l.add(20);
//	  l.add(30);
//	  l.add(40);
//	System.out.println(l);
//	   l.start = reverse(l.start);
//	 while(l.start!=null) {
//		 System.out.print(l.start.getData());
//		 l.start = l.start.getNext();
//	 }

		// l.add(50);
		// l.start.getNext().getNext().getNext().getNext().setNext(l.start.getNext().getNext());
//	  
//	  System.out.println(LinkListAplications.loopDetection(l.start)!=null);
//	  LinkListAplications.remove(l.start);
		// System.out.println(loopDetection(l.start)!=null);
//	System.out.println(removeLoop(l.start));
//	  removeNthNodeFromEnd(l,3);
//	  removeNthNodeFromEnd(2,l);
		// System.out.println(l);
		LinkList l = new LinkList();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		l.add(6);
		l.add(7);

//		Node[] node = { l.start, l2.start,l3.start,l4.start };
		
		
//		System.out.println(mergeKSortedLists(node));;
//		System.out.println(plus(l.start));
		System.out.println(l);
		l.start=swap(l.start);
		System.out.println(l);
		System.out.println(l.start.getData());;
		System.out.println(l.start.getNext().getData());;
		System.out.println(l.start.getNext().getNext().getData());;
		System.out.println(l.start.getNext().getNext().getNext().getData());;
	//	System.out.println(l.start.getNext().getNext().getNext().getNext().getData());;
		
	}
	
	 public static Node swap(Node t1,Node t2) {
		
		 if(t1==null || t1.getNext()==null)
			 return t1;
		 t2 = t1.getNext();
	//	 System.out.println(t1.getData()+"  -  "+t2.getNext());
		 t1.setNext(t2.getNext());
		 t2.setNext(t1);
		 Node temp=swap(t1.getNext(),t2);
		 t1.setNext(temp);
		 return t2;
		 
	 }
	public static Node swap(Node start) {
		return swap(start,start);
	}
	
	
	public static LinkList plus(Node start) {
		 Node temp= plusOne(start, start);
		 LinkList l = new LinkList();
		 if(temp==start) {
		  l.add(1);
		  
		  while(start!=null) {
			  l.add(start.getData());
			  start = start.getNext();
		  }
	 return l;
		 }
		 l.start=start;
		 return  l;
	}
	
	public static Node plusOne(Node start,Node temp) {
		if(temp==null)
			return temp;
		plusOne(start,temp.getNext());
		System.out.println((int)temp.getData());
		if((int)temp.getData()<9) {
			temp.setData((int)temp.getData()+1);
			return temp;
		}
		
		   temp.setData(0);
		 return temp;
		
//		return temp;
	 // return new linklist with values holding 0;
		  
		
	}
	

	public static LinkList mergeKSortedLists(Node[] node) {
		LinkList list = new LinkList();

		for (int i = 0; i < node.length; i++) {
			Node temp = node[i];

			while (temp != null) {
				list.add(temp.getData());
				temp = temp.getNext();
			}
		}

		Node i = list.start, j = list.start;
		while (i != null) {
			j = list.start;
			while (j != null && j.getNext() != null) {

				if ((int) j.getData() > (int) j.getNext().getData()) {
					int k = (int) j.getData();
					j.setData(j.getNext().getData());
					j.getNext().setData(k);
				}
				j = j.getNext();
			}

			i = i.getNext();
		}
return list;
	}

	public static void removeNthNodeFromEnd(Integer n, LinkList l) {
		Node curr = l.start, prev = null, next = null;
		while (curr != null) {
			next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
		}
		l.start = prev;
		int count = 0;
		curr = l.start;
		while (count++ < n && curr != null) {
			curr = curr.getNext();
		}
		l.start = curr;
		System.out.println(l);

	}

	public static void removeNthNodeFromEnd(LinkList l, Integer n) {
		Node temp = l.start;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.getNext();
		}
		if (count < 2) {
			l.start = null;
			return;
		}
		if (count <= n) {
			l.start = l.start.getNext();
			return;
		}
		int go = count - n;
		count = 1;
		temp = l.start;
		while (temp != null && count++ < go) {
			temp = temp.getNext();

		}
		if (temp.getNext() != null)

			temp.setNext(temp.getNext().getNext());

	}

	public static Node loopDetection(Node head) {
		Node slow = head, fast = head;
		while (fast != null && fast.getNext() != null) {
			fast = fast.getNext().getNext();
			slow = slow.getNext();
			if (fast == slow)
				return slow;
		}

		return null;
	}

	public static boolean removeLoop(Node head) {
		Node slow = loopDetection(head), st = head;
		if (slow == null)
			return false;
		while (st.getNext() != slow.getNext()) {
			st = st.getNext();
			slow = slow.getNext();
		}
		slow.setNext(null);
		return true;
	}

	public static Node reverse(Node temp) {

		if (temp.getNext() == null)
			return temp;
		else {

			Node end = reverse(temp.getNext());
			System.out.println(end.getData());
			temp.getNext().setNext(temp);
			temp.setNext(null);
			return end;
		}

	}

}