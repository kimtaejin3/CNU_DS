package model;

public class UnSortedLinkedList<T extends Comparable<T>> {
	
	private int _size;
	private Node<T> _head;
	
	
	public UnSortedLinkedList(){
		this._head=null;
		this._size=0;
	}
	/* ������ ������ ����Ʈ �⺻����̰�,��Ŭ���� ���� ���� �ּ�ó����. 
	private int size() {
		return this._size;
	}
	

	private Node<T> head(){
		return this._head;
	}
	
	private void setHead(Node<T> givenNode) {
		this._head=givenNode;
	}
	*/
	private boolean isEmpty() {
		return this._head==null;
	}
	
	private boolean isFull() {
		return false;
	}
	
	public boolean addToFirst(T anElement) {
		if(this.isFull()) {
			return false;
		}
		else {
			Node<T> newNode=new Node<T>(anElement,this._head);
			this._head=newNode;
			this._size++;
			return true;
		}
	}
	
	
	public boolean add(T anElement) {
		//�������� �ִ� �� ���� ó���� �ִ� ���� ȿ����.
		return this.addToFirst(anElement);
	}
	
	
	public T max() {
		if ( this.isEmpty() ) {
			return null;
		}
		else {
			Node<T> currentNode=this._head;
			T max=currentNode.element();
			
			while(currentNode!=null) {
				if(currentNode.element().compareTo(max)==1) {
					max=currentNode.element();
				}
				currentNode=currentNode.next();
			}
			
			return max;
		}
	}
	
//	private void clear() {
//		this._head=null;
//		this._size=0;
//	}
	
}
