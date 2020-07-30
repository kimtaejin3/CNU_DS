package model;

public class SortedArrayList<E extends Comparable<E>>{
	
	//Constants
		private static final int DEFAULT_CAPACITY=100;
		
		//private Instance Variables
		private int _capacity;
		private int _size;
		private E[] _elements;
		
		private void makeRoomAt(int aPosition) {
			for(int i=this.size(); i>aPosition; i--) {
				this.elements()[i]=this.elements()[i-1];
			}
		}
		
		private int capacity() {
			return this._capacity;
		}
		
		private void setCapacity(int newCapacity) {
			this._capacity=newCapacity;
		}
		
		private int size() {
			return this._size;
		}
		
		private void setSize(int newSize) {
			this._size=newSize;
		}
		
		
		private E[] elements() {
			return this._elements;
		}
		
		private void setElements(E[] newElements) {
			this._elements=newElements;
		}
		
		private boolean isEmpty() {
			return this.size()==0;
		}
		
		private boolean isFull() {
			return this.size()==this.capacity();
		}
		
		public E max() {
			if ( this.isEmpty() ) {
				return null;
			}
			else {
				return this.elements()[this.size()-1];
			}
		}
		
		public boolean add(E anElement) {
			if(this.isFull()) {
				return false;
			}
			else {
				int start=0;
				while(start<this.size()&&this.elements()[start].compareTo(anElement)<0) {
					start++;
				}
				
				this.makeRoomAt(start);
				
				this.elements()[start]=anElement;
				this.setSize(this.size()+1);
				return true;
			}
		}
		
		
		public SortedArrayList() {
			this(SortedArrayList.DEFAULT_CAPACITY);
		}
	
		
		@SuppressWarnings("unchecked")
		public SortedArrayList(int givenCapacity) {
			this.setCapacity(givenCapacity);
			this.setElements((E[])new Comparable[this.capacity()]);
		}

	
}
