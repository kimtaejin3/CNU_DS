package model;

public class SortedLinkedList<T extends Comparable<T>> {
	
	private int _size;
	private Node<T> _head;
	
	
	public SortedLinkedList(){
		this._head=null;
		this._size=0;
	}
	
	private int size() {
		return this._size;
	}
	
	private void setSize(int givenSize)
	{
		this._size=givenSize;
	}
	
	private Node<T> head(){
		return this._head;
	}
	
	private void setHead(Node<T> givenNode) {
		this._head=givenNode;
	}
	
	private boolean isEmpty() {
		return this._head==null;
	}
	
	private boolean isFull() {
		return false;
	}
	
	public boolean add(T anElement) {
		if(this.isFull()) {
			return false;
		}
		else {
			Node<T> nodeForAdd=new Node<T>(anElement, null);
			if(this.isEmpty()) {
				this.setHead(nodeForAdd);
			}
			else
			{
				Node<T> current=this.head();
				Node<T> previous=null;
				
				while(current!=null) {
					if(current.element().compareTo(anElement)>0) {
						break;
					}
					previous=current;
					current=current.next();
				}
				
				if(previous==null) {
					nodeForAdd.setNext(this.head());
					this.setHead(nodeForAdd);
				}
				else {
					nodeForAdd.setNext(current);
					previous.setNext(nodeForAdd);
				}
			}
			this.setSize(this.size()+1);
			return true;
		}
	}
	
	
	public T max() {
		if ( this.isEmpty() ) {
			return null;
		}
		else {
			Node<T> currentNode=this.head();
			Node<T> previous=null;
			while(currentNode!=null) {
				previous=currentNode;
				currentNode=currentNode.next();
			}
			return previous.element();
		}
	}
	
//	private void clear() {리스트 기본 요소
//		this._head=null;
//		this._size=0;
//	}
	
}
