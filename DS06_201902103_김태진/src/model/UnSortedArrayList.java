package model;

public class UnSortedArrayList<E extends Comparable<E>>{
	
	//Constants
		private static final int DEFAULT_CAPACITY=100;
		
		//private Instance Variables
		private int _capacity;
		private int _size;
		private E[] _elements;
		
		
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
				E max=this.elements()[0];
				for(int i=0; i<this.size(); i++) {
					if(this.elements()[i].compareTo(max)==1) {
						max=this.elements()[i];
					}
				}
				return max;
			}
		}
		
		public boolean add(E anElement) {
			if(this.isFull()) {
				return false;//�� á�ٸ� �Լ��� �׳� �����ϰ� ��. ������, �̹� �ǽ������� �� �� ���� ����. �迭�� ũ�⸦ ���� �����͸�ŭ ����.
			}
			else {
				this.elements()[this.size()]=anElement;
				this.setSize(this.size()+1);
				return true;
			}
		}
		
		
		public UnSortedArrayList() {
			this(UnSortedArrayList.DEFAULT_CAPACITY);
		}
	
		
		@SuppressWarnings("unchecked")
		public UnSortedArrayList(int givenCapacity) {
			this.setCapacity(givenCapacity);
			this.setElements((E[])new Comparable[this.capacity()]);
		}

	
}
