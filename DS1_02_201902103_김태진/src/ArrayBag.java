
public class ArrayBag<E> {
	// 비공개 인스턴스 변수
	private static final int DEFAULT_CAPACITY = 100 ;
	private int _capacity ;
	private int _size ;
	private E[] _elements; // ArrayBag의 원소들을 담을 java 배열

	@SuppressWarnings("unchecked")//E에대한 컴파일러의 경고 방지
	public ArrayBag() {
		this.setCapacity(ArrayBag.DEFAULT_CAPACITY);
		this.setElements((E[])new Object[this.capacity()]);
		this.setSize(0);
	}
	
	@SuppressWarnings("unchecked")//E에대한 컴파일러의 경고 방지
	public ArrayBag(int givenCapacity)
	{
		this.setCapacity(givenCapacity);
		this.setElements((E[])new Object[this.capacity()]);
		this.setSize(0);
	}
	
	private int capacity()//Class 내부에서만 사용
	{
		return this._capacity;
	}
	
	private void setCapacity(int newCapacity)//Class 내부에서만 사용
	{
		this._capacity=newCapacity;
	}
	
	public int size()
	{
		return this._size;
	}
	
	private void setSize(int newSize)//Class 내부에서만 사용
	{
		this._size=newSize;
	}
	
	private E[] elements()//Class 내부에서만 사용
	{
		return this._elements;
	}
	
	private void setElements(E[] newElements)//Class 내부에서만 사용
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
	
	//보고서
	public boolean doesContain(E anElement)
	{
		//found변수를 초기화 하지 않고, 직관적으로 해결함.
		for(int i=0; i<this._size; i++)
		{
			if(this.elements()[i].equals(anElement)) {
				return true;
			}
		}
		return false;
	}
	//보고서
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
	
	//보고서
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














