

public class LinkedNode<E>{
	
	private E _element;
	private LinkedNode<E> _next;
	
	public LinkedNode()
	{
		this.setElement(null);
		this.setNext(null);
	}
	
	public LinkedNode(E givenElement)
	{
		this.setElement(givenElement);
		this.setNext(null);
	}
	
	public LinkedNode(E givenElement, LinkedNode<E> givenNext)
	{
		this.setElement(givenElement);
		this.setNext(givenNext);
	}
	
	public void setNext(LinkedNode<E> newNext)
	{
		this._next=newNext;
	}
	
	public void setElement(E newElement) {
		this._element=newElement;
	}
	
	public E element()
	{
		return this._element;
	}
	
	
	public LinkedNode<E> next()
	{
		return this._next;
	}
	
}