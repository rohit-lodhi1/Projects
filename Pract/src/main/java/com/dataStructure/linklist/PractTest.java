package com.dataStructure.linklist;

import java.util.HashMap;
import java.util.Map;

class PractLinkeList {
	Node head;

	public void addAtFirst(int value) {
		Node temp = new Node(value);
		temp.setNext(this.head);
		this.head = temp;
	}

	public void addAtLast(int value) {
		Node temp = new Node(value);
		if (this.head == null)
			this.head = temp;
		else {
			Node t = this.head;
			while (t.getNext() != null)
				t = t.getNext();
			t.setNext(temp);
		}
	}

	public void addAtNth(int value, int pos) {
		Node temp = new Node(value);
		Node t = this.head;
		if (pos <= 0) {
			this.addAtFirst(value);
			return;
		}
		int count = 1;
		while (t.getNext() != null && count++ < pos - 1) {
			t = t.getNext();
		}
		temp.setNext(t.getNext());
		t.setNext(temp);
	}

	public void removeFromFirst() {
		this.head = this.head.getNext();
	}

	public void removeFromLast() {
		Node temp = this.head;
		if (temp == null)
			return;
		if (temp.getNext() == null)
			this.removeFromFirst();

		while (temp.getNext() != null && temp.getNext().getNext() != null) {
			temp = temp.getNext();
		}
		temp.setNext(null);
	}

	public void removeFromNth(int pos) {
		if (pos <= 1) {
			this.removeFromFirst();
			return;
		}
		Node temp = this.head;
		int count = 1;
		while (temp.getNext() != null && count++ < pos - 1) {
			temp = temp.getNext();
		}
		if (temp.getNext() == null)
			this.removeFromLast();
		else
			temp.setNext(temp.getNext().getNext());
	}

	public String toString() {
		Node t = head;
		String s = "";
		while (t != null) {
			s += t.getData() + " ";
			t = t.getNext();
		}
		return s;
	}
}

class PractDoublyLinkedList {
	NodeD head;

	public void addAtFirst(int value) {
		NodeD temp = new NodeD(value);
		if (this.head == null) {
			this.head = temp;
			return;
		}
		this.head.setPrev(temp);
		temp.setNext(this.head);
		this.head = temp;
	}

	public void addAtLast(int value) {
		NodeD temp = new NodeD(value);
		if (this.head == null) {
			this.head = temp;
			return;
		}
		NodeD t = this.head;
		while (t.getNext() != null) {
			t = t.getNext();
		}
		temp.setPrev(t);
		t.setNext(temp);
	}

	public void addAtNth(int value, int pos) {
		NodeD temp = new NodeD(value);
		if (this.head == null) {
			this.addAtFirst(value);
			return;
		}
		int count = 1;
		NodeD t = this.head;
		while (t.getNext() != null && count++ < pos - 1)
			t = t.getNext();
		temp.setNext(t.getNext());
		temp.setPrev(t);
		t.setNext(temp);
	}

	public void removeFromFirst() {
		if (this.head != null) {
			this.head = this.head.getNext();
		}
	}

	public void removeFromLast() {
		NodeD temp = this.head;
		if (this.head == null || this.head.getNext() == null) {
			this.removeFromFirst();
			return;
		}
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		if (temp.getPrev() != null)
			temp.getPrev().setNext(null);
	}

	public void removeFromNth(int pos) {
		int count = 1;
		if (pos <= 1) {
			this.removeFromFirst();
			return;
		}
		NodeD temp = this.head;
		while (temp.getNext() != null && count++ < pos - 1) {
			temp = temp.getNext();
		}
		if (temp.getNext() == null) {
			this.removeFromLast();
			return;
		}
		temp.getNext().getNext().setPrev(temp);
		temp.getNext().setPrev(null);
		temp.setNext(temp.getNext().getNext());
	}

	public String toString() {
		NodeD temp = this.head;
		String s = "";
		while (temp != null) {
			s += temp.getData() + " ";
			temp = temp.getNext();
		}
		return s;
	}

}

class Circular {
	Node tail;

	public void addAtFirst(int value) {
		Node temp = new Node(value);
		temp.setNext(temp);
		if (this.tail == null)
			tail = temp;
		else {
			Node t = this.tail.getNext();
			while (this.tail != t) {
				t = t.getNext();
			}
			temp.setNext(this.tail.getNext());
			this.tail.setNext(temp);
		}
	}

	public void addAtLast(int value) {
		Node temp = new Node(value);
		temp.setNext(temp);
		if (this.tail == null)
			this.tail = temp;
		else {
			temp.setNext(this.tail.getNext());
			this.tail.setNext(temp);
			this.tail = temp;
		}
	}

	public void addAtNth(int value, int pos) {
		if (pos <= 0) {
			this.addAtFirst(value);
			return;
		}

		Node temp = new Node(value);
		temp.setNext(temp);
		int count = 1;
		Node t = this.tail.getNext();
		while (count++ < pos - 1 && t != this.tail) {
			t = t.getNext();
		}
		if (t == this.tail) {
			this.addAtLast(value);
			return;
		}
		temp.setNext(t.getNext());
		t.setNext(temp);
	}

	public void removeFromFirst() {
		if (this.tail == null)
			return;
		Node temp = this.tail.getNext();
		if (temp == this.tail)
			this.tail = null;
		else {

			this.tail.setNext(temp.getNext());

		}
	}

	public void removeFromLast() {
		Node temp = this.tail;

		if (temp == null || temp.getNext() == this.tail) {
			this.tail = null;
			return;
		}

		while (temp.getNext() != this.tail) {
			temp = temp.getNext();
		}

		temp.setNext(this.tail.getNext());
		this.tail = temp;
	}

	public void removeFromNth(int pos) {
		Node temp = this.tail;

		if (pos <= 0 || temp == null || temp.getNext() == this.tail) {
			this.removeFromFirst();
			return;
		}
		int count = 1;
		while (count++ < pos && temp.getNext() != this.tail) {
			temp = temp.getNext();
		}
		if (temp.getNext() == this.tail) {
			this.removeFromLast();
			return;
		}
		temp.setNext(temp.getNext().getNext());
	}

	public String toString() {
		String s = "";
		if (this.tail == null)
			return s;

		Node temp = this.tail.getNext();
		while (temp != tail) {
			s += temp.getData() + " ";
			temp = temp.getNext();
		}
		s += temp.getData();
		return s;
	}
}

public class PractTest {
	public static void main(String[] args) {
//		PractLinkeList list = new PractLinkeList();
//		list.addAtLast(10);
//		list.addAtLast(20);
//		list.addAtLast(30);
//		list.addAtFirst(5);
//		list.addAtNth(25, 3);
//		list.removeFromLast();
//		list.removeFromLast();
//		list.removeFromLast();
//		list.removeFromLast();
//		list.removeFromLast();
//		list.removeFromNth(-11);
//		System.out.println(list);

//		PractDoublyLinkedList list = new PractDoublyLinkedList();
//		list.addAtLast(10);
//		list.addAtLast(20);
//		list.addAtLast(30);
//		list.addAtLast(40);
//		list.addAtNth(15, 2);
//		list.removeFromNth(-11);
//		System.out.println(list);
//		Circular list = new Circular();
//		list.removeFromLast();
//		list.removeFromFirst();
//		list.addAtNth(35, -1);
//		list.addAtFirst(40);
//		list.addAtLast(30);
//		list.addAtFirst(20);
//		list.addAtLast(10);
//		list.addAtFirst(50);
//		list.addAtNth(25, 3);
//		System.out.println(list);
//		list.removeFromNth(-11);

//		list.removeFromLast();
//		list.removeFromLast();
//		list.removeFromLast();
//		list.removeFromLast();
//		list.removeFromLast();
//		list.removeFromLast();

//		System.out.println(list);
//		System.out.println(2%3);
//
//		ListNode head = new ListNode(1);
//		head.next= new ListNode(2);
//		head.next.next=new ListNode(3);
//		System.err.println(System.currentTimeMillis());
//		head=Solution.reverse(head);
//		ListNode right=Solution.findRightHead(0,head);
////		System.out.println();
//		head=Solution.reverse(head);
////	   	System.out.println(print(head));;
//	   	ListNode temp =head;
//	   	while(temp.next!=null){
////	   		System.err.println(temp.val);
//            temp=temp.next;
//        }
//        temp.next=head;
//        head=right;
////        printCircular(temp);
//        
//        while(temp.next!=right)
//            temp=temp.next;
//        temp.next=null;
//        System.err.println(System.currentTimeMillis());
//        System.out.println(print(head));
//		PractLinkeList l = new PractLinkeList();
//		l.addAtLast(1);
//		l.addAtLast(1);
//		l.addAtLast(1);
//		l.addAtLast(3);
//		l.addAtLast(4);
//		l.addAtLast(4);
//		l.addAtLast(5);
//		l.addAtLast(5);
//		
//		System.out.println(l);
//		count(l);
//		System.out.println(l);
//		
//		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
//		head.next.next.next.next.next = new ListNode(6);
//		head.next.next.next.next.next.next = new ListNode(7);
		
		ListNode head2 = new ListNode(1);
		head2.next = new ListNode(2);
		head2.next.next = new ListNode(3);
		head2.next.next.next = new ListNode(2);
		head2.next.next.next.next = new ListNode(1);
//		head2.next.next.next.next.next = new ListNode(8);
//		head = partition(head, 1);
//	    head=reversePart2(head, 3,5 );
//		System.out.println(print(head));
//		System.out.println(print(head));
//		System.out.println(System.currentTimeMillis());
//		reOrder(head);
//		System.out.println(System.currentTimeMillis());
		
//		System.out.println(print(mergeInBetweenLinkedLists(head,1,4,head2)));
//System.out.println();
		
//		System.out.println(print(mergeSortedLinkeListWithSpaceO1(head,head2)));
		System.out.println(palindormeCheck(head2));
		
	}
	
	
	public static ListNode reverse(ListNode prev,ListNode curr) {
		if(curr==null)
			return prev;
		ListNode revHead = reverse(curr,curr.next);
		curr.next=prev;
		return revHead;
	}
	
	
	public static boolean palindormeCheck(ListNode head) {
		ListNode slow=head,fast=head;
		ListNode prev=slow;
		while(fast!=null && fast.next!=null) {
			prev=slow;
			slow=slow.next;
			fast=fast.next.next;
		}

		ListNode revHead = reverse(null,prev);
		prev.next=null;
		while(revHead!=null && head!=null) {
			if(head.val!=revHead.val)
				return false;
             head=head.next;
             revHead=revHead.next;
		}
		return true;
	}
	
	public static ListNode mergeSortedLinkeListWithSpaceO1(ListNode first,ListNode second) {
		ListNode response=first;
		if(first==null)
			return second;
		if(second==null)
			return first;
		// make smallest first element list first
		if(first.val>=second.val) {
			ListNode t = second;
			second=first;
			first=t;
			response=first;
		}
		System.out.println(first.val);
		ListNode curr=first;
		while(first.next!=null && second!=null) {
			curr = first.next;
			if(curr!=null && curr.val>=second.val) {
//				System.out.println(first.val);
				first.next=second;
				ListNode t= second.next;
				second.next = curr;
				second=t;
			}
			first=first.next;
		}
		System.out.println(first.next);
		
		if(first.next==null)
		{
			first.next=second;
		}
	System.out.println(response.val);
		return response;
	}
	
	
	public static ListNode mergeInBetweenLinkedLists(ListNode list1,int a,int b,ListNode list2) {
		
		ListNode temp=list1,temp2=list2;
		while(temp2.next!=null) {
			temp2 = temp2.next;
		}
		System.out.println(temp2.val);
		ListNode joinFrom=list1;
		int count=0;
		while(temp!=null && count<=b) {
			if(count==a) {
				System.out.println(count+" --"+" val ="+joinFrom.val);
				joinFrom.next = list2;
			}
			System.out.println("temp ="+temp.val+ " join="+joinFrom.val);
			joinFrom = temp;
		    temp = temp.next;
		    count++;
		}
		
//		System.out.println(temp.val);
		temp2.next=temp;
		return list1;
	}
	
	
	public static ListNode reOrder(ListNode head) {
		ListNode slow = head,fast=head;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		ListNode temp2=reverse(slow);
		
		ListNode temp1=head;
		while(temp1!=null && temp2!=null && temp1.next!=temp2 ) {
			ListNode c1=temp1.next;
			ListNode c2=temp2.next;
			temp1.next=temp2;
			temp2.next=c1;
			temp1=c1;
			temp2=c2;
		}
		
		System.out.println(print(head));
		return null;
	}
	
	
	public static ListNode reverse(ListNode head) {
		ListNode pre=null,curr=head,next=null;
		while(curr!=null) {
			next=curr.next;
			curr.next=pre;
			pre=curr;
			curr=next;
		}
		return pre;
	}
	
	public static ListNode reversePart2(ListNode head,int left,int right) {
		ListNode joinSt=head,revSt=head,revEnd=head,joinEnd=null,temp=head;
		int count=1;
		while(temp!=null) {
			if(count+1==left) {
			   joinSt=temp;
			   revSt=temp.next;
			}
			if(count==right) {
				revEnd=temp;
				joinEnd=temp.next;
				break;
			}
			count++;
			temp=temp.next;
		}
		revEnd.next=null;
		System.out.println("RevSt ="+revSt.val+" RevENd="+revEnd.val+" JoinSt ="+joinSt.val+" joinEnd="+joinEnd);
		ListNode newHead = reverse(revSt);
		
		  joinSt.next=newHead;
		  System.out.println();
		
		  revSt.next = joinEnd;
		  if(revSt==joinSt)
			  return newHead;
		return head;
	}
	
	

	public static ListNode addNode(ListNode head, int val) {
		ListNode temp = new ListNode(val);
		if (head == null) {
			head = temp;
		} else {
			ListNode t = head;
			while (t.next != null) {
				t = t.next;
			}
			t.next = temp;
		}
		return head;
	}

	public static ListNode partition(ListNode head, int x) {
		ListNode temp = head;
		ListNode l1 = null, l2 = null;
		while (temp != null) {
			if (temp.val >= x)
				l2 = addNode(l2, temp.val);
			else
				l1 = addNode(l1, temp.val);
			temp = temp.next;
		}
		temp = l1;
		if (temp == null)
			return l2;
		while (temp.next != null)
			temp = temp.next;
		temp.next = l2;
		return l1;
	}

	public static void count(PractLinkeList list) {
		Map<Integer, Integer> cot = new HashMap<>();
		Node t = list.head;
		while (t != null) {
			Integer integer = cot.get(t.getData());
			if (integer == null)
				cot.put((Integer) t.getData(), 1);
			else {
				cot.put((Integer) t.getData(), ++integer);
			}
			t = t.getNext();
		}

		t = list.head;
		Node temp = t;
		while (t != null) {
			Integer integer = cot.get(t.getData());
			System.err.println(t.getData());
			if (integer > 1) {
				if (t == list.head) {
					list.head = t.getNext();
				}
				temp.setNext(t.getNext());
			} else {
				temp = t;
			}
			t = t.getNext();
		}

		System.err.println(cot);

	}

	public static String printCircular(ListNode temp) {
		String s = "";
		ListNode t = temp;
		while (t.next != temp) {
//			System.err.print(t.val+" ");
			s += t.val + " ";
			t = t.next;
		}
		s += t.val;
		return s;
	}

	public static String print(ListNode t) {
		String s = "";
		while (t != null) {
			s += t.val + " ";
			t = t.next;
		}
		return s;
	}

}

//
// 
class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
 
class Solution {
    
    public static ListNode reverse(ListNode head){
        ListNode pre = null,curr=head,next=null;
        while(curr!=null){
            next = curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        return pre;
    }
    
    public static ListNode findRightHead(int k,ListNode head){
        int count=1;
        ListNode temp=head;
        while(count<k){
            while(temp!=null && count++<k){
                temp = temp.next;
            }
            if(temp==null)
                temp=head;
            
        }
        return temp;
    }
    
    public static ListNode rotateRight(ListNode head, int k) {
        ListNode temp=reverse(head);
        ListNode right = findRightHead(k,head);
    temp=reverse(head);
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=head;
        while(temp.next!=right)
            temp=temp.next;
        temp.next=null;
        return right;
    }
}