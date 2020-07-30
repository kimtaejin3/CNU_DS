package model;


public class ArrayList<E extends Comparable<E>>{
	
	//Constants
	private static final int DEFAULT_CAPACITY=100;
	
	//private Instance Variables
	private int _capacity;
	private int _size;
	private E[] _elements;
	
	public int capacity() {
		return this._capacity;
	}
	
	public void setCapacity(int newCapacity) {
		this._capacity=newCapacity;
	}
	
	public int size() {
		return this._size;
	}
	
	public void setSize(int newSize) {
		this._size=newSize;
	}
	
	
	private E[] elements() {
		return this._elements;
	}
	
	private void setElements(E[] newElements) {
		this._elements=newElements;
	}
	
	private boolean anElementDoesExistAt(int anOrder)
	{
		return ((anOrder>=0)&&(anOrder<this.size()));
	}
	
	private void makeRoomAt(int aPosition) {
		for(int i=this.size(); i>aPosition; i--) {
			this.elements()[i]=this.elements()[i-1];
		}
	}
	
	private void removeGapAt(int aPosition)
	{
		for(int i=aPosition+1; i<this._size; i++)
		{
			this._elements[i-1]=this._elements[i];
		}
		this._elements[this._size-1]=null;
	}
	
	//Construct
	@SuppressWarnings("unchecked")
	public ArrayList (int givenCapacity) {
		this.setCapacity (givenCapacity) ;
		this.setElements ((E[]) new Object[ this.capacity()]) ;
	}
	
	public ArrayList () {
		this (ArrayList.DEFAULT_CAPACITY) ;
	}
	
	
	public Iterator<E> iterator(){
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<E> {

		private int _nextPosition;
		
		private int nextPosition() {
			return this._nextPosition;
		}
		
		private void setNextPosition(int newNextPosition) {
			this._nextPosition=newNextPosition;
		}
		
		private ListIterator() {
			this.setNextPosition(0);
		}
		
		@Override 
		public boolean hasNext() {
			return (this.nextPosition()<ArrayList.this.size());
		}
		
		public E next() {
			if(this._nextPosition==ArrayList.this.size()) {
				return null;
			}
			else {
				
				E nextElement=ArrayList.this._elements[this._nextPosition];
				this._nextPosition++;
				return nextElement;
			}
		}
	}
	
	
	public boolean isEmpty() {
		return this.size()==0;
	}
	
	public boolean isFull() {
		return this.size()==this.capacity();
	}
	
	public E last() {
		
		E anElement=this._elements[this._size-1];
		
		return anElement;
	}
	
	public E first() {
		E anElement=this._elements[0];
		
		return anElement;
	}
	
	public boolean doesContain(E anElement) {
		for(int i=0; i<this.size(); i++) {
			if(this.elements()[i].equals(anElement)) {
				return true;
			}
		}
		return false;
	}
	
	public int frequencyOf(E anElement) {
		int frequencyCount=0;
		for(int i=0; i<this.size(); i++) {
			if(this.elements()[i].equals(anElement)) {
				frequencyCount++;
			}
		}
		return frequencyCount;
	}
	
	public E elementAt(int anOrder) {
		
		if(this.anElementDoesExistAt(anOrder)) {
			return this.elements()[anOrder];
		}
		else {
			return null;
		}
	}
	
	public int orderOf(E anElement) {
		//If anElement does not exist, then return -1;
		//If found, return the order of the found element inside _elements[].
		for(int order=0; order<this.size(); order++) {
			if(this.elements()[order].equals(anElement)) {
				return order;
			}
		}
		return -1;
	}
	
	public boolean addTo(E anElement, int anOrder) {
		if(this.isFull()) {
			return false;
		}
		else if(anOrder<0||anOrder>this.size()) {
			return false;
		}
		else {
			this.makeRoomAt(anOrder);
			this.elements()[anOrder]=anElement;
			this.setSize(this.size()+1);
			return true;
		}
	}
	
	public boolean addToFirst(E anElement) {
		if(this.isFull()) {
			return false;
		}
		else {
			this.makeRoomAt(0);
			this.elements()[0]=anElement;
			this.setSize(this.size()+1);
			return true;
		}
	}
	
	public boolean addToLast(E anElement) {
		return this.addTo(anElement, this.size());
	}
	
//	public boolean add(E anElement) {
//		return this.addToLast(anElement);
//	}
	
	public void add(E anElement) {
		if(this.isFull()) {
			return;
		}
		else {
			int start=0;
			while(start<this.size()&&this.elements()[start].compareTo(anElement)==-1) {
				start++;
			}
			this.makeRoomAt(start);
			this.elements()[start]=anElement;
			this.setSize(this.size()+1);
		}
	}
	
	public E removeFrom(int anOrder) {
		E removedElement=null;
		
		if(this.anElementDoesExistAt(anOrder)) {
			removedElement=this.elements()[anOrder];
			this.removeGapAt(anOrder);
			this._size--;
		}
		return removedElement;
	}
	
	public E removeFirst() {
		return removeFrom(0);
	}
	
	public E removeLast() {
		return removeFrom(this._size-1);
	}
	
	public E removeAny()
	{
		return removeLast();
	}
	
	public boolean remove(E anElement)
	{
		int orderOfRemove=this.orderOf(anElement);
		if(orderOfRemove<0) {
			return false;
		}
		else {
			this.removeGapAt(orderOfRemove);
			this._size--;
			return true;
		}
	}
	
	public boolean replaceAt(E anElement, int anOrder) {
		if(this.anElementDoesExistAt(anOrder)) {
			this._elements[anOrder]=anElement;
			return true;
		}
		else {
			return false;
		}
	}
	
	public void clear() {
		for(int i=0; i<this._size; i++) {
			this._elements[i]=null;
		}
		this._size=0;
	}
	
}
