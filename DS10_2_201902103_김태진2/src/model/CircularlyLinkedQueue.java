package model;

public class CircularlyLinkedQueue<E> implements Queue<E> {

	private int _size;
	private LinkedNode<E> _rearNode;
	
	public CircularlyLinkedQueue() {
		this._size=0;
		this._rearNode=null;
	}
	
	public void setRearNode(LinkedNode<E> newRearNode) {
		this._rearNode=newRearNode;
	}
	
	public LinkedNode<E> rearNode(){
		return this._rearNode;
	}
	
	@Override
	public E elementAt(int anOrder)
	{
		if(anOrder<0||anOrder>=this.size()) {
			return null;
		}
		LinkedNode<E> frontNode=this.rearNode().next();
		for(int i=0; i<anOrder; i++) {
			frontNode=frontNode.next();
		}
		return frontNode.element();
	}
	
	@Override
	public boolean isEmpty() {
		return (this._rearNode==null);
	}
	
	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public int size() {
		return this._size;
	}
	
	public void setSize(int newSize) {
		this._size=newSize;
	}
	
	@Override
	public E front() {
		E frontElement=null;
		
		if(!this.isEmpty()) {
			frontElement=this._rearNode.next().element();
		}
		return frontElement;
	}
	
	@Override
	public E rear() {
		E rearElement=null;
		
		if(!this.isEmpty()) {
			rearElement=this._rearNode.element();
		}
		return rearElement;
	}
	
	@Override
	public boolean enQueue(E anElement)
	{
		if(this.isFull()) {
			return false;
		}
		LinkedNode<E> newRearNode=new LinkedNode<>(anElement,null);
		if(this.isEmpty()) {
			newRearNode.setNext(newRearNode);
		}
		else {
			newRearNode.setNext(this._rearNode.next());
			this._rearNode.setNext(newRearNode);
		}
		this.setSize(this._size+1);
		this._rearNode=newRearNode;
		
		return true;
	}
	
	@Override
	public E deQueue()
	{
		E frontElement=null;
		if(!this.isEmpty()) {
			frontElement=this._rearNode.next().element();
			if(this._rearNode==this._rearNode.next()) {
				this._rearNode=null;
			}
			else {
				this._rearNode.setNext(this._rearNode.next().next());
			}
			this.setSize(this._size-1);
		}
		return frontElement;
	}
	
	
	public Iterator<E> iterator(){
		return new CircularlyLinkedQueueIterator();
	}
	
	private class CircularlyLinkedQueueIterator implements Iterator<E>{
		
		private LinkedNode<E> _nextNode;
		private int count;
		
		private LinkedNode<E> nextNode(){
			return this._nextNode;
		}
		
		private void setNextNode(LinkedNode<E> newNextNode)
		{
			this._nextNode=newNextNode;
		}
		
		private void setCount(int newCount)
		{
			this.count=newCount;
		}
		
		private int count() {
			return this.count;
		}
		
		private CircularlyLinkedQueueIterator() {
			this.setNextNode(CircularlyLinkedQueue.this._rearNode);
			this.setCount(CircularlyLinkedQueue.this.size());
		}
		
		@Override
		public boolean hasNext() {
			return (this.count()>0);
		}
		
		@Override
		public E next() {
			if(this.hasNext()) {
				this.setNextNode(this.nextNode().next());
				E nextElement=this.nextNode().element();
				this.setCount(this.count-1);
				return nextElement;
			}else {
				return null;
			}
		}
	}
	
	public void clear()
	{
		this._rearNode=null;
		this._size=0;
	}
}


















