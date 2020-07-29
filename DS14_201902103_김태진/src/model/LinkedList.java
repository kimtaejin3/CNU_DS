package model;

public class LinkedList<T> implements Stack<T> {
	
	private int _size;
	private Node<T> _head;
	
	public boolean anElementDoesExistAt(int anOrder) {
		return ((anOrder>=0)&&(anOrder<this._size));
	}
	
	public LinkedList(){
		this._head=null;
		this._size=0;
	}
	@Override
	public int size() {
		return this._size;
	}
	@Override
	public boolean isEmpty() {
		return this._head==null;
	}
	@Override
	public boolean isFull() {
		return false;
	}
	
	
	public boolean doesContain(T anElement) {
		
		Node<T> temp=this._head;
		
		while(temp!=null) {
			if(temp.element().equals(anElement)) {
				return true;
			}
			temp=temp.next();
		}
		return false;
	}
	
	public T elementAt(int anOrder) {
		
		if(this.anElementDoesExistAt(anOrder)) {
			Node<T> temp=this._head;
			
			int nodeCount=0;
			
			while(nodeCount<anOrder) {
				temp=temp.next();
				nodeCount++;
			}
			return temp.element();
		}
		else {
			return null;
		}
	}
	
	public T firstElement() {
		T anElement=this.elementAt(0);
		return anElement;
	}
	
	public T lastElement() {
		T anElement=this.elementAt(this._size-1);
		return anElement;
	}
	
	public int orderOf(T anElement) {
		
		Node<T> temp=this._head;
		int order=0;
		
		while(temp!=null&&!temp.element().equals(anElement)) {
			order++;
			temp=temp.next();
		}
		
		if(temp==null) {
			return -1;
		}
		else {
			return order;
		}
	}
	
	public boolean addTo(T anElement, int anOrder) {
		
		if(this.anElementDoesExistAt(anOrder)) {
			return false;
		}
			
		else if(this.isFull()) {
			return false;
		}
		else
		{
			Node<T> newNode=new Node<>(anElement,null);
			if(anOrder==0) {
				newNode.setNext(this._head);
				this._head=newNode;
			}
			else
			{
				Node<T> previous=this._head;
				for(int i=1; i<anOrder; i++) {
					previous=previous.next();
				}
				newNode.setNext(previous.next());
				previous.setNext(newNode);
			}
			this._size++;
			return true;
		}
	}
	
	
	public boolean addToFirst(T anElement) {
		if(this.isFull()) {
			return false;
		}
		else {
			Node<T> newNode=new Node<>(anElement,this._head);
			this._head=newNode;
			this._size++;
			return true;
		}
	}
	
	public boolean addToLast(T anElement) {
		
		if(this.isFull()) {
			return false;
		}
		else {
			Node<T> newNode=new Node<>(anElement,null);
			if(this.isEmpty()) {
				this._head=newNode;
			}
			else {
				Node<T> last=this._head;
				
				while(last.next()!=null) {
					last=last.next();
				}
				last.setNext(newNode);
			}
			this._size++;
			return true;
		}
	}
	
	public boolean add(T anElement) {
		//마지막에 넣는 것 보다 처음에 넣는 것이 효율적.
		return this.addToFirst(anElement);
	}
	
	
	public T removeFrom(int anOrder) {
		if(!this.anElementDoesExistAt(anOrder)) {
			return null;
		}
		else
		{
			Node<T> removed=null;
			if(anOrder==0) {
				removed=this._head;
				this._head=this._head.next();
			}
			else {
				Node<T> previous=this._head;
				for(int i=1; i<anOrder; i++) {
					previous=previous.next();
				}
				removed=previous.next();
				previous.setNext(removed.next());
			}
			this._size--;
			return removed.element();
			
		}
	}
	
	
	public T removeFirst() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			
			T removedElement=this._head.element();
			this._head=this._head.next();
			this._size--;
			return removedElement;
		}
	}
	
	public T removeLast() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			T removedElement=null;
			if(this._head.next()==null) {
				removedElement=this._head.element();
				this._head=null;
			}
			else {
				Node<T> previous=this._head;
				Node<T> last=previous.next();
				while(last.next()!=null) {
					previous=last;
					last=last.next();
				}
				removedElement=last.element();
				previous.setNext(null);
			}
			this._size--;
			return removedElement;
		}
	}
	
	public T removeAny()
	{
		return this.removeFirst();//removelast()라면 시간이 더 걸림.
	}
	
	public boolean remove(T anElement)
	{
		Node<T> previous=null;
		Node<T> current=this._head;
		
		while((current!=null)&&(!current.element().equals(anElement))) {
			previous=current;
			current=current.next();
		}
		
		if(current==null) {
			return false;
		}
		else {
			if(current==this._head) {
				this._head=this._head.next();
			}
			else {
				previous.setNext(current.next());
			}
			this._size--;
			return true;
		}
	}
	
	
	public boolean replaceAt(T anElement, int anOrder)
	{
		if(!this.anElementDoesExistAt(anOrder)) {
			return false;
		}
		else {
			Node<T> current=this._head;
			for(int i=0; i<anOrder; i++) {
				current=current.next();
			}
			current.setElement(anElement);
			return true;
		}
	}
	
	@Override
	public boolean push (T anElement) {
	
		return this.addToLast(anElement) ;
	}
	
	@Override
	public T pop () {
		return this.removeLast();
	}
	
	@Override
	public T peek () {
		if ( this.isEmpty() ) {
				return null;
		}
		else {
			return this.elementAt(this.size()-1); // Last element
		}
	}
	
	@Override
	public void clear() {
		this._head=null;
		this._size=0;
	}
	
}
