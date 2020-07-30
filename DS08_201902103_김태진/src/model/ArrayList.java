package model;


public class ArrayList<E extends Comparable<E>> implements Stack<E>{
	//Constants
			private static final int DEFAULT_CAPACITY=5;
			
			//private Instance Variables
			private int _capacity;
			private int _size;
			private E[] _elements;
			
			
			public int capacity() {
				return this._capacity;
			}
			
			private void setCapacity(int newCapacity) {
				this._capacity=newCapacity;
			}
			
			private boolean anElementDoesExistAt(int anOrder) {
				return ((anOrder>=0)&&(anOrder<this.size()));
			}
			
			@Override
			public int size() {
				return this._size;
			}
			
			private void setSize(int newSize) {
				this._size=newSize;
			}
			
			protected E[] elements() {
				return this._elements;
			}
			
			private void setElements(E[] newElements) {
				this._elements=newElements;
			}
			
			private void makeRoomAt(int aPosition) {
				for(int i=this.size()-1; i>aPosition; i--) {
					this.elements()[i]=this.elements()[i-1];
				}
			}
			
			private void removeGapAt(int aPosition)
			{
				for(int i=aPosition+1; i<this.size(); i++) {
					this.elements()[i-1]=this.elements()[i];
				}
				this.elements()[this.size()-1]=null;
			}
			
			@Override
			public boolean isEmpty() {
				return this.size()==0;
			}
			
			@Override
			public boolean isFull() {
				return this.size()==this.capacity();
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
			
			protected void setElementAt(int anOrder, E anElement) {
				if(anOrder<0||anOrder>=this.size()) {
					return;
				}
				else {
					this.elements()[anOrder]=anElement;
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
			
			public boolean add(E anElement) {
				if(this.isFull()) {
					return false;
				}
				else {
					this.elements()[this.size()]=anElement;
					this.setSize(this.size()+1);
					return true;
				}
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
			
			@Override
			public boolean push (E anElement) {
			
				return this.addToLast(anElement) ;
			}
			
			@Override
			public E pop () {
				return this.removeLast();
			}
			
			@Override
			public E peek () {
				if ( this.isEmpty() ) {
						return null;
				}
				else {
					return this.elementAt(this.size()-1); // Last element
				}
			}
			
			@Override
			public void clear() {
				
				for(int i=0; i<this.size(); i++) {
					this.elements()[i]=null;
				}
			}

			
			public ArrayList() {
				this(ArrayList.DEFAULT_CAPACITY);
			}
		
			
			@SuppressWarnings("unchecked")
			public ArrayList(int givenCapacity) {
				this.setCapacity(givenCapacity);
				this.setElements((E[])new Comparable[this.capacity()]);
			}
}
