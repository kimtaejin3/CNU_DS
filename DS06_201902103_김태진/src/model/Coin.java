package model;

public class Coin implements Comparable<Coin> {
	
	//상수
	private static final int DEFAULT_VALUE=0;
	//private instance variables
	private int _value;//동전의 금액
	
	public Coin()
	{
		setValue(DEFAULT_VALUE);
	}
	
	public Coin(int givenValue) {
		setValue(givenValue);
	}
	
	public int value()
	{
		return this._value;
	}
	
	public void setValue(int newValue)
	{
		this._value=newValue;
	}
	

	@Override
	public int compareTo(Coin aCoin) {
		if ( this.value() < aCoin.value() ) {
			return -1;
		}
		else if (this.value() > aCoin.value() ) {
			return +1 ;
		}
		else {
			return 0 ;
		}
	}

}
