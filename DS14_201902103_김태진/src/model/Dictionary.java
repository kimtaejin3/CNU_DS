package model;

public abstract class Dictionary<Key extends Comparable<Key>, Obj extends Comparable<Obj>>{


	private int _size;
	private VisitDelegate<Key,Obj> _visitDelegate;
	
	//Getter/Setter
	public int size() {
		return this._size;
	}
	
	protected void setSize(int newSize) {
		this._size=newSize;
	}
	
	public VisitDelegate<Key,Obj> visitDelegate(){
		return this._visitDelegate;
	}
	
	public void setVisitDelegate(VisitDelegate<Key,Obj> newVisitDelegate) {
		this._visitDelegate=newVisitDelegate;
	}
	
	//Constructor
	public Dictionary() {
		this.setSize(0);
	}
	
	//Public abstract methods
	public abstract boolean isEmpty();
	public abstract boolean  isFull(); 
	public abstract boolean  keyDoesExist(Key aKey); 
	public abstract Obj  objectForKey (Key aKey); 
	public abstract boolean  addKeyAndObject (Key aKey, Obj anObject); 
	public abstract Obj  removeObjectForKey (Key aKey); 
	public abstract void  clear (); 
	public abstract Iterator<DictionaryElement<Key,Obj>>iterator(); 
	public abstract void scanInSortedOrder();
	public abstract void scanInReverseOfSortedOrder();
	
	
}
