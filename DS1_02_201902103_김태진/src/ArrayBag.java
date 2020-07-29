
public class ArrayBag<E> {
	// ����� �ν��Ͻ� ����
	private static final int DEFAULT_CAPACITY = 100 ;
	private int _capacity ;
	private int _size ;
	private E[] _elements; // ArrayBag�� ���ҵ��� ���� java �迭

	@SuppressWarnings("unchecked")//E������ �����Ϸ��� ��� ����
	public ArrayBag() {
		this.setCapacity(ArrayBag.DEFAULT_CAPACITY);
		this.setElements((E[])new Object[this.capacity()]);
		this.setSize(0);
	}
	
	@SuppressWarnings("unchecked")//E������ �����Ϸ��� ��� ����
	public ArrayBag(int givenCapacity)
	{
		this.setCapacity(givenCapacity);
		this.setElements((E[])new Object[this.capacity()]);
		this.setSize(0);
	}
	
	private int capacity()//Class ���ο����� ���
	{
		return this._capacity;
	}
	
	private void setCapacity(int newCapacity)//Class ���ο����� ���
	{
		this._capacity=newCapacity;
	}
	
	public int size()
	{
		return this._size;
	}
	
	private void setSize(int newSize)//Class ���ο����� ���
	{
		this._size=newSize;
	}
	
	private E[] elements()//Class ���ο����� ���
	{
		return this._elements;
	}
	
	private void setElements(E[] newElements)//Class ���ο����� ���
	{
		this._elements=newElements;
	}
	
	
	public boolean isEmpty()
	{
		return (this.size()==0);
	}
	
	public boolean isFull()
	{
		return (this.size()==this.capacity());
	}
	
	//����
	public boolean doesContain(E anElement)
	{
		//found������ �ʱ�ȭ ���� �ʰ�, ���������� �ذ���.
		for(int i=0; i<this._size; i++)
		{
			if(this.elements()[i].equals(anElement)) {
				return true;
			}
		}
		return false;
	}
	//����
	public int frequencyOf(E anElement)
	{
		int frequencyCount=0;
		for(int i=0; i<this._size; i++)
		{
			if(this.elements()[i].equals(anElement))
			{
				frequencyCount++;
			}
		}
		return frequencyCount++;
	}
	
	//����
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
	
	public boolean remove(E anElement) {
		
		boolean found=false;
		int foundIndex=-1;
		
		
		for(int i=0; i<this.size()&&!found; i++)
		{
			if(this.elements()[i].equals(anElement))
			{
				foundIndex=i;
				found=true;
			}
		}
		
		if(!found) {
			return false;
		}else {
			for(int i=foundIndex; i<this.size()-1; i++)
			{
				this.elements()[i]=this.elements()[i+1];
			}
			this.elements()[this.size()-1]=null;
			this.setSize(this.size()-1);
			return true;
		}	
	}
	
	public E elementAt(int anOrder)
	{
		if((0<=anOrder)&&(anOrder<this.size())) {
			return this.elements()[anOrder];
		}
		else
		{
			return null;
		}
	}
	
	public void clear()
	{
		for(int i=0; i<this.size(); i++)
		{
			this.elements()[i]=null;
		}
		this.setSize(0);
	}
}














