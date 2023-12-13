package com.dataStructure.linklist;

public class NodeD {
  
	private Object data;
	private NodeD next;
	private NodeD prev;
	
	
	public NodeD(Object data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public NodeD getNext() {
		return next;
	}
	public void setNext(NodeD next) {
		this.next = next;
	}
	public NodeD getPrev() {
		return prev;
	}
	public void setPrev(NodeD prev) {
		this.prev = prev;
	}
	
	
}
