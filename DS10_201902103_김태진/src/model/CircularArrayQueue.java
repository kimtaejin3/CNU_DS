package model;

public class CircularArrayQueue<E> implements Queue<E> {
	
	private static final int DEFAULT_CAPACITY=100;
	
	private int _maxLength;
	private int _frontPosition;
	private int _rearPosition;
	private E[] _elements;
	
	private int maxLength() {
		return this._maxLength;
	}
	
	private void setMaxLength(int newMaxlength) {
		this._maxLength=newMaxlength;
	}
	
	public int capacity() {
		return (this.maxLength()-1);
	}
	
	public E[] elements() {
		return this._elements;
	}
	
	public void setElements(E[] newElements) {
		this._elements=newElements;
	}
	
	private int frontPosition() {
		return this._frontPosition;
	}
	
	private void setFrontPosition(int newFrontPosition) {
		this._frontPosition=newFrontPosition;
	}
	
	private int rearPosition() {
		return this._rearPosition;
	}
	
	private void setRearPosition(int newRearPosition) {
		this._rearPosition=newRearPosition;
	}
	
	@Override
	public int size() {
		if(this.rearPosition()>=this.frontPosition()) {
			return (this.rearPosition()-this.frontPosition());
		}
		else {
			return (this.rearPosition()+this.maxLength()-this.frontPosition());
		}
	}

	@Override
	public boolean isFull() {
		if((this._rearPosition+1)%(this._maxLength)==this._frontPosition) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isEmpty() {
		return (this._frontPosition==this._rearPosition);
	}

	@Override
	public E front() {
		E frontElement=null;
		if(!this.isEmpty()) {
			frontElement=this._elements[this._frontPosition+1];
		}
		return frontElement;
	}

	@Override
	public E rear() {
		E rearElement=null;
		if(!this.isEmpty()) {
			rearElement=this._elements[this._rearPosition];
		}
		return rearElement;
	}

	@Override
	public boolean enQueue(E anElement) {
		
		if(this.isFull()) {
			return false;
		}
		this._rearPosition=(this._rearPosition+1)%this.maxLength();
		this._elements[this._rearPosition]=anElement;
		return true;
	}

	@Override
	public E deQueue() {
		
		E frontElement=null;
		this._frontPosition=(this._frontPosition+1)%this.maxLength();
		frontElement=this._elements[this._frontPosition];
		this._elements[this._frontPosition]=null;
		return frontElement;
	}

	@Override
	public void clear() {
		
		this.setFrontPosition(0);
		this.setRearPosition(0);
		
		for(int i=0; i<this.maxLength(); i++) {
			this._elements[i]=null;
		}
	}

	@Override
	public E elementAt(int anOrder) {
		
		E element=this.elements()[(this.frontPosition()+1+anOrder)%this.maxLength()];
		return element;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return (new CircularArrayQueueIterator());
	}
	
	private class CircularArrayQueueIterator implements Iterator<E> {
		
		private int _nextOrder;
		private int nextOrder() {
			return this._nextOrder;
		}
		private void setNextOrder(int newNextOrder) {
			this._nextOrder=newNextOrder;
		}
		
		private CircularArrayQueueIterator() {
			this.setNextOrder(0);
		}
		
		@Override
		public boolean hasNext() {
			return ((this._nextOrder)<(CircularArrayQueue.this.size()));
		}
		
		@Override
		public E next() {
			E nextElement=null;
			
			if(this.hasNext()) {
				nextElement=CircularArrayQueue.this.elementAt(this.nextOrder());
				this.setNextOrder(this._nextOrder+1);
			}
			return nextElement;
		}
		
	}
	
	public CircularArrayQueue() {
		this(CircularArrayQueue.DEFAULT_CAPACITY);
	}
	
	
	@SuppressWarnings("unchecked")
	public CircularArrayQueue(int givenCapacity) {
		this.setMaxLength(givenCapacity+1);
		this.setElements((E[])new Object[this.maxLength()]);
		this.setFrontPosition(0);
		this.setRearPosition(0);
	}
	
	
	
}
