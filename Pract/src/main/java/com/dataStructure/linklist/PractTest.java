package com.dataStructure.linklist;

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
		
			
		if(pos<=0||temp==null || temp.getNext()==this.tail) {
			this.removeFromFirst();
			return ;
		}
		int count=1;
		while(count++<pos && temp.getNext()!=this.tail) {
			temp = temp.getNext();
		}
		if(temp.getNext()==this.tail) {
			this.removeFromLast();
			return ;
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
		Circular list = new Circular();
//		list.removeFromLast();
//		list.removeFromFirst();
		list.addAtNth(35, -1);
		list.addAtFirst(40);
		list.addAtLast(30);
		list.addAtFirst(20);
		list.addAtLast(10);
		list.addAtFirst(50);
		list.addAtNth(25, 3);
		System.out.println(list);
		list.removeFromNth(-11);

//		list.removeFromLast();
//		list.removeFromLast();
//		list.removeFromLast();
//		list.removeFromLast();
//		list.removeFromLast();
//		list.removeFromLast();

		System.out.println(list);

	}

}