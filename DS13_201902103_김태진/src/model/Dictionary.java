package model;

public abstract class Dictionary<Key extends Comparable<Key>, Obj extends Comparable<Obj>>{


	private int _size;
	
	//Getter/Setter
	public int size() {
		return this._size;
	}
	
	protected void setSize(int newSize) {
		this._size=newSize;
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
	
	
}
