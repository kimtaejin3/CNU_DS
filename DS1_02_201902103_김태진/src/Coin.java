
public class Coin {
	
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
	public boolean equals(Object otherCoin)
	{
		//otherCoin의 실제클래스 비교
		if(otherCoin.getClass()!=Coin.class) {
			return false;
		}
		else// aCoin의 class를 안전하게 Coin class로 형변환가능
		{
			return (this.value()==((Coin)otherCoin).value());
		}
	}
}
