

public class LinkedBag<E>{

	private int _size;
	private LinkedNode<E> _head;
	
	public LinkedBag()
	{
		this.setSize(0);
		this.setHead(null);
	}
	
	public boolean doesContain(E anElement)
	{
		LinkedNode<E> currentNode=this.head();
		while(currentNode!=null)
		{
			if(currentNode.element().equals(anElement))
			{
				return true;
			}
			currentNode=currentNode.next();
		}
		return false;
	}
	
	public int frequencyOf(E anElement)
	{
		int frequencyCount=0;
		LinkedNode<E> currentNode=this._head;
		while(currentNode!=null) {
			if(currentNode.element().equals(anElement))
			{
				frequencyCount++;
			}
			currentNode=currentNode.next();
		}
		return frequencyCount;
	}
	
	public E elementAt(int anOrder)
	{
		if(anOrder<0||anOrder>=this._size)
		{
			return null;
		}
		else
		{
			LinkedNode<E> currentNode=this.head();
			for(int i=0; i<anOrder; i++)
			{
				currentNode=currentNode.next();
			}
			return currentNode.element();
		}
	}
	
	public E any()
	{
		if(this.isEmpty()) {
			return null;
		}
		else
		{
			return this.head().element();
		}
	}
	
	public boolean add(E anElement)
	{
		if(this.isFull()) {
			return false;
		}
		else
		{
			LinkedNode<E> newNode=new LinkedNode<E>();
			newNode.setElement(anElement);
			newNode.setNext(this.head());
			this.setHead(newNode);
			this.setSize(this.size()+1);
			return true;
		}
	}
	
	public E removeAny()
	{
		if(this.isEmpty()){
			return null;
		}
		else {
			E removedElement=this.head().element();
			this.setHead(this.head().next());
			this.setSize(this.size()-1);
			return removedElement;
		}
	}
	
	public boolean remove(E anElement)
	{
		if(this.isEmpty())
		{
			return false;
		}
		else
		{
			LinkedNode<E> previousNode=null;
			LinkedNode<E> currentNode=this._head;
			boolean found=false;
			while(currentNode!=null&&!found)
			{
				if(currentNode.element().equals(anElement)) {
					found=true;
				}
				else {
					previousNode=currentNode;
					currentNode=currentNode.next();
				}
			}
			
			if(!found) {
				return false;
			}else
			{
				if(currentNode==this.head()) {
					this.setHead(this.head().next());
				}
				else
				{
					previousNode.setNext(currentNode.next());
				}
				this.setSize(this.size()-1);
				return true;
			}	
		}
	}
	
	public void clear()
	{
		this.setSize(0);;
		this.setHead(null);
	}
	
	public boolean isEmpty()
	{
		return (this._head==null);
	}
	
	public boolean isFull()
	{
		return false;
	}
	
	private void setSize(int newSize)
	{
		this._size=newSize;
	}
	
	public int size() {
		return this._size;
	}
	
	
	private LinkedNode<E> head()
	{
		return this._head;
	}
	
	private void setHead(LinkedNode<E> newHead)
	{
		this._head=newHead;
	}
	
}
